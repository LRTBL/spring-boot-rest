package com.lrtbl.helloworld.restMongo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class ClientModel {

    @Id
    private String id;

    private String username;

    private String password;

    private Date createdAt;

    private Date updatedAt;
}
