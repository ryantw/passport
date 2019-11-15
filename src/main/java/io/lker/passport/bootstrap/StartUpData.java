package io.lker.passport.bootstrap;

import io.lker.passport.model.Role;
import io.lker.passport.model.User;
import io.lker.passport.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Component
@Slf4j
public class StartUpData implements CommandLineRunner {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;

    public StartUpData(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start up data loading...");
        loadUsers();
    }

    private void loadUsers() {

        Role role = Role.builder()
                .name("ROLE_ADMIN")
                .build();

        User user = User.builder()
                .id(1L)
                .username("r@r.com")
                .createdDate(LocalDateTime.now())
                .password(bCryptPasswordEncoder.encode("test"))
                .enabled(true)
                .roles(Arrays.asList(role))
                .build();

        userService.save(user);
    }
}
