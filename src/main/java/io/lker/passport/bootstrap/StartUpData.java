package io.lker.passport.bootstrap;

import io.lker.passport.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartUpData implements CommandLineRunner {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public StartUpData(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start up data loading...");
        loadData();
    }

    private void loadData() {

        User user = User.builder().username("r@r.com")
                .enabled(true)
                .build();


    }
}
