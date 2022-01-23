package com.lrtbl.helloworld.restMongo.repositories;

import com.lrtbl.helloworld.restMongo.models.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {
}
