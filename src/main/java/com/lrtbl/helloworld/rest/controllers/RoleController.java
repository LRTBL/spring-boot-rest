package com.lrtbl.helloworld.rest.controllers;

import com.lrtbl.helloworld.rest.dto.RoleDTO;
import com.lrtbl.helloworld.rest.entities.Role;
import com.lrtbl.helloworld.rest.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/roles")
@RestController
@RequiredArgsConstructor
public class RoleController {

    private final ModelMapper modelMapper;
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole (@RequestBody RoleDTO roleDTO) {
        Role role = convertToEntity(roleDTO);
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<Role> updateRole (@PathVariable("roleId") Integer roleId, @RequestBody RoleDTO roleDTO){
        Role role = convertToEntity(roleDTO);
        return new ResponseEntity<>(roleService.updateRole(roleId,role), HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole (@PathVariable Integer roleId){
        roleService.deleteRole(roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Role convertToEntity(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, Role.class);
    }
}
