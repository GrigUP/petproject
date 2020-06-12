package ru.grig.petproject.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.grig.petproject.domain.repositories.BaseUserRepository;
import ru.grig.petproject.security.BaseUserDetails;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final BaseUserRepository baseUserRepository;

    public AppUserDetailsService(BaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new BaseUserDetails(baseUserRepository.
                findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found by name = " + username)));
    }
}
