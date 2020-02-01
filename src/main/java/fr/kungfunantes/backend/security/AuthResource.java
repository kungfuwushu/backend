package fr.kungfunantes.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.kungfunantes.backend.exception.*;
import fr.kungfunantes.backend.model.Profile;
import fr.kungfunantes.backend.model.Account;
import fr.kungfunantes.backend.model.Role;
import fr.kungfunantes.backend.model.Role.RoleName;
import fr.kungfunantes.backend.repository.ProfileRepository;
import fr.kungfunantes.backend.repository.AccountRepository;
import fr.kungfunantes.backend.repository.RoleRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);

        // create response
        Map response = new HashMap();
        response.put("token", new JwtAuthenticationResponse(jwt));
        response.put("user", (UserPrincipal) authentication.getPrincipal()); // get signed in user

        return ResponseEntity.ok(response);
    }

    // create new account
    @SuppressWarnings({"unchecked", "rawtypes"})
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        // check if email is available
        if(accountRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse("Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // check if username is available
        if(profileRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse("Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }


        // Create new account
        Account newAccount = new Account(signUpRequest.getEmail(), signUpRequest.getPassword());
        newAccount.setPassword(passwordEncoder.encode(newAccount.getPassword()));

        // Create new profile
        Profile newProfile = new Profile(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getUsername());


        Role userRole = roleRepository.findByName(RoleName.USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        // user.setRoles(Collections.singleton(userRole));

        Account createdAccount = accountRepository.save(newAccount);
        Profile createdProfile = profileRepository.save(newProfile);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(createdProfile.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse("User registered successfully"));
    }
}
