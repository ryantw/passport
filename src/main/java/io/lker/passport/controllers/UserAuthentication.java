package io.lker.passport.controllers;

import io.lker.passport.model.JwtAuthenticationRequest;
import io.lker.passport.model.UserTokenState;
import io.lker.passport.service.UserServiceImpl;
import io.lker.passport.util.SecurityConstants;
import io.lker.passport.util.TokenHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class UserAuthentication {
    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final TokenHelper tokenHelper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAuthentication(UserServiceImpl userService,
                              AuthenticationManager authenticationManager,
                              TokenHelper tokenHelper,
                              BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenHelper = tokenHelper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletResponse response){

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        String jws = tokenHelper.generateToken(user.getUsername());
        long expiresIn = SecurityConstants.EXPIRATION_DATE;

        return ResponseEntity.ok(new UserTokenState(jws, expiresIn));
    }
}
