package io.lker.passport.service;

import io.lker.passport.exception.UserIdNotFoundException;
import io.lker.passport.model.User;
import io.lker.passport.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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
        Optional<User> optionalUser = Optional.of(
                User.builder().id(1L).username("r@r.com")
                        .enabled(true).build()
        );
        when(userRepository.findByUsernameIgnoreCase(anyString())).thenReturn(optionalUser);
        User returnedUser = userService.findByUsername("r@r.com");
        assertNotNull(returnedUser);
        assertEquals(optionalUser.get().getUsername(), returnedUser.getUsername());
        verify(userRepository, times(1)).findByUsernameIgnoreCase(anyString());
    }

    @Test
    void disableUserById() {
        Optional<User> optionalUser = Optional.of(
                User.builder().id(1L).username("r@r.com")
                        .enabled(true).build()
        );
        when(userRepository.save(any())).thenReturn(optionalUser.get());
        when(userRepository.findById(anyLong())).thenReturn(optionalUser);
        User returnedUser = userService.save(optionalUser.get());
        User disableUserById = userService.disableUserById(returnedUser.getId());
        assertNotNull(disableUserById);
        assertEquals(false, disableUserById.isEnabled());
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

    @Test
    void getFindByIdNotFound(){
        assertThrows(UserIdNotFoundException.class,
                ()->{
                    User notFound = User.builder().id(100L).build();
                    userService.findById(notFound.getId());
                }
        );
    }

    @Test
    void getUsernameNotFound(){
        assertThrows(UsernameNotFoundException.class,
                ()->{
                    User notFound = User.builder().id(1L).username("r@r.com").build();
                    userService.findByUsername(notFound.getUsername());
                }
        );
    }
}