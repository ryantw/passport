package io.lker.passport.service;

import io.lker.passport.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CrudService<User, Long> {
    User findByUsername(String username);
    User disableUserById(Long id);
}
