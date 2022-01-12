package com.lrtbl.helloworld.restMongo.services;


import com.lrtbl.helloworld.restMongo.models.ClientModel;
import com.lrtbl.helloworld.restMongo.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    ClientRepository clientRepository;

    public List<ClientModel> getUsers() {
        return clientRepository.findAll();
    }

    public ClientModel createUser(ClientModel clientModel) {
        clientModel.setCreatedAt(new Date(System.currentTimeMillis()));
        return clientRepository.save(clientModel);
    }
}
