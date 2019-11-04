package io.lker.passport.service;

import io.lker.passport.model.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService extends CrudService<Role, Long> {
    Role findByName(String name);
}
