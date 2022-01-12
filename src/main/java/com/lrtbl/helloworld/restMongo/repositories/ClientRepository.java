package com.lrtbl.helloworld.restMongo.repositories;


import com.lrtbl.helloworld.restMongo.models.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientModel, String> {

}
