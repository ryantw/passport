package io.lker.passport.service;

import io.lker.passport.model.Role;
import io.lker.passport.repository.RoleRepository;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    RoleRepository roleRepository;

    @InjectMocks
    RoleServiceImpl roleService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByName() {
        Optional<Role> optionalRole = Optional.of(
                Role.builder()
                        .id(1L)
                        .name("ROLE_ADMIN")
                        .build()
        );
        when(roleRepository.findByName(anyString()))
                .thenReturn(optionalRole);
        Role returnedRole = roleService.findByName("ROLE_ADMIN");
        assertNotNull(returnedRole);
        assertEquals(optionalRole.get().getName(), returnedRole.getName());
        verify(roleRepository, times(1))
                .findByName(anyString());
    }

    @Test
    void findAll() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder().id(1L)
                .name("ROLE_ADMIN")
                .build()
        );
        roles.add(Role.builder().id(2L)
                .name("ROLE_MODERATOR")
                .build()
        );
        roles.add(Role.builder().id(3L)
                .name("ROLE_USER")
                .build()
        );

        when(roleRepository.findAll()).thenReturn(roles);
        List<Role> returnedRoles =  roleService.findAll();
        assertNotNull(returnedRoles);
        assertEquals(3, returnedRoles.size());
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Optional<Role> optionalRole = Optional.of(
                Role.builder()
                        .id(1L)
                        .name("ROLE_ADMIN")
                        .build()
        );
        when(roleRepository.findById(anyLong()))
                .thenReturn(optionalRole);
        Role returnedRole = roleService.findById(anyLong());
        assertNotNull(returnedRole);
        assertEquals(1L, returnedRole.getId());
        verify(roleRepository, times(1))
                .findById(anyLong());
    }

    @Test
    void save() {
        Optional<Role> optionalRole = Optional.of(
                Role.builder()
                        .id(1L)
                        .name("ROLE_ADMIN")
                        .build()
        );
        when(roleRepository.save(any()))
                .thenReturn(optionalRole.get());
        Role savedRole = roleService.save(optionalRole.get());
        assertNotNull(savedRole);
        verify(roleRepository).save(any());
        verify(roleRepository, times(1))
                .save(any());
    }

    @Test
    void delete() {
        Optional<Role> optionalRole = Optional.of(
                Role.builder()
                        .id(1L)
                        .name("ROLE_ADMIN")
                        .build()
        );
        roleService.delete(optionalRole.get());
        verify(roleRepository, times(1))
                .delete(optionalRole.get());
    }

    @Test
    void deleteById() {
        Long id = 1L;
        roleService.deleteById(id);
        verify(roleRepository, times(1))
                .deleteById(anyLong());
    }

    @Test
    void getFindByIdNotFound(){
        assertThrows(RuntimeException.class,
                ()->{
                    Role notFound = Role.builder().id(100L).build();
                    roleService.findById(notFound.getId());
                });
    }

    @Test
    void getRoleNameNotFound(){
        assertThrows(RuntimeException.class,
                ()->{
                    Role notFound = Role.builder().id(1L).name("ROLE_ADMIN").build();
                    roleService.findByName(notFound.getName());
                }
        );

    }
}