package com.build.project.portfolio.management.portfolio_management.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.build.project.portfolio.management.portfolio_management.entities.Users;
import com.build.project.portfolio.management.portfolio_management.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/csrf_token")
    public CsrfToken getCSRFToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/register")
    public Users registerNewUser(@RequestBody Users user) {
        userService.registerUser(user);
        return user;
    }

}
