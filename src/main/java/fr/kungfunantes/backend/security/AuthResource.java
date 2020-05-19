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
import fr.kungfunantes.backend.model.Rank;
import fr.kungfunantes.backend.model.Member;
import fr.kungfunantes.backend.model.Role.RoleName;
import fr.kungfunantes.backend.repository.ProfileRepository;
import fr.kungfunantes.backend.repository.MemberRepository;
import fr.kungfunantes.backend.repository.AccountRepository;
import fr.kungfunantes.backend.repository.RankRepository;
import fr.kungfunantes.backend.repository.RoleRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    RankRepository rankRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
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

        // check if username is available
        if (profileRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse("Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // check if email is available
        Account account;
        if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
            // get account if it exists
            Optional<Account> optionalAccount = accountRepository.findByEmail(signUpRequest.getEmail());
            account = optionalAccount.get();
        } else {
          // Create new account
          account = new Account(
            signUpRequest.getEmail(),
            passwordEncoder.encode(signUpRequest.getPassword())
          );
          accountRepository.save(account);
        }

        // Create new profile
        Profile newProfile = new Profile(
          signUpRequest.getFirstName(),
          signUpRequest.getLastName(),
          signUpRequest.getUsername(),
          account
        );
        // set up roles
        Role userRole = roleRepository.findByName(RoleName.USER)
                .orElseThrow(() -> new AppException("User Role not set."));
        newProfile.setRoles(Collections.singleton(userRole));
        Profile createdProfile = profileRepository.save(newProfile);

        // create Member with rank 1
        List<Rank> ranks = rankRepository.findByOrderByPositionAsc();
        Rank rank = ranks.get(0);
        Member newMember = new Member(
          newProfile,
          rank
        );
        memberRepository.save(newMember);


        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(createdProfile.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse("User registered successfully"));
    }
}
