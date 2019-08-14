package io.lker.passport.service.impl;

import io.lker.passport.exception.UserIdNotFoundException;
import io.lker.passport.model.User;
import io.lker.passport.repository.UserRepository;
import io.lker.passport.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        log.info("findAll() called");
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(Long aLong) {
        log.info("findById() with userid: {}", aLong);
        return userRepository.findById(aLong)
                .orElseThrow(() -> new UserIdNotFoundException(aLong));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        log.info("findByUsername() with username: {}", username);
        return Optional.ofNullable(userRepository.findByUsernameIgnoreCase(username))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }

    @Override
    public User disableUserById(Long id) {
        log.info("disableUserById() with id: {}", id);
        Optional<User> userOptional = Optional.ofNullable(findById(id));
        userOptional.orElseThrow(() -> new UserIdNotFoundException(id));
        User user = userOptional.get();
        log.info("disabling user with id: {}", user.getId());
        user.setEnabled(false);
        return save(user);
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }
}
