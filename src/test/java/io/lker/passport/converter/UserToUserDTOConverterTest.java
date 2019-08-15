package io.lker.passport.converter;

import io.lker.passport.PassportApplication;
import io.lker.passport.model.User;
import io.lker.passport.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PassportApplication.class)
@WebAppConfiguration
@Slf4j
class UserToUserDTOConverterTest {

    @Autowired
    @Qualifier("mvcConversionService")
    ConversionService conversionService;

    @Test
    public void convertUserToUserDTO(){
        User user = User.builder().id(1L).username("r@r.com")
                .createdDate(LocalDateTime.now()).build();

        UserDTO userDTO = conversionService.convert(user, UserDTO.class);

        assertEquals(user.getUsername(), userDTO.getUsername());
    }

}