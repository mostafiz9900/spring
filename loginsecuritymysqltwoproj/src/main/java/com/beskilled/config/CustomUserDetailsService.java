package com.beskilled.config;

import com.beskilled.entity.User;
import com.beskilled.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> optionalUser=userRepo.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
