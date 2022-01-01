package com.lrtbl.helloworld.rest.services;

import com.lrtbl.helloworld.rest.entities.Role;
import com.lrtbl.helloworld.rest.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role createRole (Role role) {
        return roleRepository.save(role);
    }
}
