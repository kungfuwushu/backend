package fr.kungfunantes.backend.security;

import fr.kungfunantes.backend.model.Profile;
import fr.kungfunantes.backend.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    ProfileRepository profileRepository;

    // redefined UserDetailsService loadUserByUsername method
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Profile profile = profileRepository.findByUsername(username)
          // .orElse(() -> Account account = accountRepository.findByEmail(usernameOrEmail))
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));

        return UserPrincipal.create(profile);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrincipal.create(profile);
    }
}
