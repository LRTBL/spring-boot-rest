package com.lrtbl.helloworld.restMongo.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "product")
@ToString
public class ProductModel {

    @Id
    private String id;

    private String name;

    private ObjectId clientId;

    private Date createdAt;

    private Date updatedAt;
}
