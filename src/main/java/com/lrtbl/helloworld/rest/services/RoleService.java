package com.lrtbl.helloworld.rest.services;

import com.lrtbl.helloworld.rest.entities.Role;
import com.lrtbl.helloworld.rest.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    private KafkaTemplate<Integer, String> kafkaTemplate;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role createRole (Role role) {
        Role roleCreated = roleRepository.save(role);
        kafkaTemplate.send("spring-topic", roleCreated.getName());
        return roleCreated;
    }

    public Role updateRole (Integer roleId,  Role role){

        Optional<Role> result = roleRepository.findById(roleId);
        if(!result.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exits", roleId));
        }
        role.setId(roleId);
        return roleRepository.save(role);
    }

    public void deleteRole (Integer roleId){
        Optional<Role> result = roleRepository.findById(roleId);
        if(!result.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exits", roleId));
        }
        roleRepository.deleteById(roleId);
    }
}
