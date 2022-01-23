package com.lrtbl.helloworld.restMongo.controllers;


import com.lrtbl.helloworld.dependencyinjection.classes.OtroAnimal;
import com.lrtbl.helloworld.rest.dto.RoleDTO;
import com.lrtbl.helloworld.rest.entities.Role;
import com.lrtbl.helloworld.restMongo.dto.ClientDto;
import com.lrtbl.helloworld.restMongo.models.ClientModel;
import com.lrtbl.helloworld.restMongo.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usersmongo")
@RequiredArgsConstructor
public class ClientController {

    private final ModelMapper modelMapper;
    private final ClientService clientService;

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllUsers () {
        return new ResponseEntity<>(clientService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientModel> createUser (@Valid @RequestBody ClientDto clientDto) {
        ClientModel client = convertToEntity(clientDto);
        return new ResponseEntity<>(clientService.createUser(client), HttpStatus.CREATED);
    }

    private ClientModel convertToEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto, ClientModel.class);
    }
}
