package io.lker.passport.controllers;

import io.lker.passport.service.UserServiceImpl;
import io.lker.passport.util.TokenHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class UserAuthentication {
    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final TokenHelper tokenHelper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAuthentication(UserServiceImpl userService, AuthenticationManager authenticationManager, TokenHelper tokenHelper) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenHelper = tokenHelper;
    }


}
