package io.lker.passport.converter;

import io.lker.passport.model.User;
import io.lker.passport.model.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOConverter implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(User user) {
        return new UserDTO(
                user.getUsername(),
                user.isEnabled(),
                user.getCreatedDate()
        );
    }
}
