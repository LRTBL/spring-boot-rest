package com.lrtbl.helloworld.restMongo.controllers;


import com.lrtbl.helloworld.restMongo.models.ClientModel;
import com.lrtbl.helloworld.restMongo.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usersmongo")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllUsers () {
        return new ResponseEntity<>(clientService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientModel> createUser (@RequestBody ClientModel  clientModel) {
        return new ResponseEntity<>(clientService.createUser(clientModel), HttpStatus.CREATED);
    }
}
