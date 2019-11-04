package io.lker.passport.service;

import io.lker.passport.model.Role;
import io.lker.passport.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        log.info("findByName() with name: {}", name);
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Username not found: " + name));
    }

    @Override
    public List<Role> findAll() {
        log.info("roles findAll() called");
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);

        return roles;
    }

    @Override
    public Role findById(Long aLong) {
        log.info("findById() with role: {}", aLong);
        return roleRepository.findById(aLong)
                .orElseThrow(() -> new RuntimeException("Role not found: " + aLong));
    }

    @Override
    public Role save(Role object) {
        log.info("role save()");
        return roleRepository.save(object);
    }

    @Override
    public void delete(Role object) {
        log.info("role delete()");
        roleRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        log.info("role deletebyid(): {}", aLong);
        roleRepository.deleteById(aLong);
    }
}
