package io.lker.passport.service;

import io.lker.passport.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends CrudService<User, Long> {
    Optional<User> findByUsername(String username);
    User disableUserById(Long id);
}
