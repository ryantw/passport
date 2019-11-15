package io.lker.passport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@EntityScan({"com.pwandp.store","io.lker.passport"})
@EnableJpaRepositories({"com.pwandp.store","io.lker.passport"})
@SpringBootApplication(scanBasePackages = {"com.pwandp.store","io.lker.passport"})
public class PassportApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(PassportApplication.class, args);
	}
}
