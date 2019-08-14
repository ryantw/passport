package io.lker.passport.service;

import io.lker.passport.model.User;
import io.lker.passport.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        List<User> users = new ArrayList<>();
        users.add(User.builder().id(1L).username("r@r.com")
                .enabled(true).build());
        users.add(User.builder().id(2L).username("a@a.com")
                .enabled(true).build());

        when(userRepository.findAll()).thenReturn(users);

        List<User> returnedUsers = userService.findAll();

        assertNotNull(returnedUsers);
        assertEquals(2, returnedUsers.size());
    }

    @Test
    void findById() {
        Optional<User> optionalUser = Optional.of(
                User.builder().id(1L).username("r@r.com")
                .enabled(true).build()
        );
        when(userRepository.findById(anyLong())).thenReturn(optionalUser);
        User returnedUser = userService.findById(anyLong());
        assertNotNull(returnedUser);
        assertEquals(1L, returnedUser.getId());
        verify(userRepository, times(1)).findById(anyLong());

    }

    @Test
    void findByUsername() {
    }

    @Test
    void disableUserById() {
    }

    @Test
    void save() {
        Optional<User> optionalUser = Optional.of(
                User.builder().id(1L).username("r@r.com")
                        .enabled(true).build()
        );
        when(userRepository.save(any())).thenReturn(optionalUser.get());
        User savedUser = userService.save(optionalUser.get());
        assertNotNull(savedUser);
        verify(userRepository).save(any());
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        Optional<User> optionalUser = Optional.of(
                User.builder().id(1L).username("r@r.com")
                        .enabled(true).build()
        );
        userService.delete(optionalUser.get());
        verify(userRepository, times(1)).delete(optionalUser.get());
    }

    @Test
    void deleteById() {
        Long id = 1L;
        userService.deleteById(id);
        verify(userRepository, times(1)).deleteById(anyLong());
    }
}