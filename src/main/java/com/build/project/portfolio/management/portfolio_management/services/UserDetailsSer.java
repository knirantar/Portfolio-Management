package com.build.project.portfolio.management.portfolio_management.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.build.project.portfolio.management.portfolio_management.entities.AppUserDetails;
import com.build.project.portfolio.management.portfolio_management.entities.Users;
import com.build.project.portfolio.management.portfolio_management.repositories.UserRepository;

@Service
public class UserDetailsSer implements UserDetailsService {

    UserRepository userRepository;

    public UserDetailsSer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new AppUserDetails(user);

    }

}
