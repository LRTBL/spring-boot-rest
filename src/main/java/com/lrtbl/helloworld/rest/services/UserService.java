package com.lrtbl.helloworld.rest.services;

import com.github.javafaker.Faker;
import com.lrtbl.helloworld.rest.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private Faker faker;
    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i=0; i<100; i++) {
            users.add(new User(faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
        }
    }

    public List<User> getUsers () {
        return users;
    }
}
