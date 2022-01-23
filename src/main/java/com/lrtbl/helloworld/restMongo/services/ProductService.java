package com.lrtbl.helloworld.restMongo.services;


import com.lrtbl.helloworld.lifecycle.LIfeCycleBean;
import com.lrtbl.helloworld.restMongo.models.ClientModel;
import com.lrtbl.helloworld.restMongo.models.ProductModel;
import com.lrtbl.helloworld.restMongo.repositories.ClientRepository;
import com.lrtbl.helloworld.restMongo.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(LIfeCycleBean.class);

    ProductRepository productRepository;
    ClientRepository clientRepository;

    public ProductModel createProduct(ProductModel productModel, String clientId) {

        Optional<ClientModel> clientModel = clientRepository.findById(clientId);
        if(!clientModel.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Client id %s doesn't exits", clientId));
        }
        productModel.setId(null);
        productModel.setClientId(new ObjectId(clientId));
        productModel.setCreatedAt(new Date(System.currentTimeMillis()));
        return productRepository.save(productModel);
    }
}
