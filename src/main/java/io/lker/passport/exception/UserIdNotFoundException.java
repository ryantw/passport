package io.lker.passport.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserIdNotFoundException extends UsernameNotFoundException {
    public UserIdNotFoundException(Long id){
        super("Could not find user with id: " + id);
    }
}
