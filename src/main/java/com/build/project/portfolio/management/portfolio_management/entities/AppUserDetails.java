package com.build.project.portfolio.management.portfolio_management.entities;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUserDetails implements UserDetails {
    private Optional<Users> user;

    public AppUserDetails(Optional<Users> user1) {
        this.user = user1;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return user.map(Users::getPasswordHash).orElse(null);
    }

    @Override
    public String getUsername() {
        return user.map(Users::getUsername).orElse(null);
    }

}
