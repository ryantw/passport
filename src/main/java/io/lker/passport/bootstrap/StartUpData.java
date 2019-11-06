package io.lker.passport.bootstrap;

import io.lker.passport.model.User;
import io.lker.passport.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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

        User user = User.builder()
                .id(1L)
                .username("r@r.com")
                .createdDate(LocalDateTime.now())
                .password(bCryptPasswordEncoder.encode("test"))
                .enabled(true)
                .build();

        userService.save(user);
    }
}
