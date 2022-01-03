package com.lrtbl.helloworld.rest.services;

import com.github.javafaker.Faker;
import com.lrtbl.helloworld.rest.models.User;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceByFaker {

    private Faker faker;
    private List<User> users;

    @PostConstruct
    public void init() {
      for (int i = 0; i < 100; i++) {
        users.add(
            new User(
                faker.funnyName().name(), faker.name().username(), faker.dragonBall().character()));
      }
    }

    public List<User> getUsers(String startWith) {
      if (startWith != null)
        return users.stream()
            .filter(user -> user.getUsername().startsWith(startWith))
            .collect(Collectors.toList());
      return users;
    }

    public User getUserByUsername (String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findAny().orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("User %s not found", username)));
    }

    public User createUser (User user){
        if(users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User %s not found", user.getUsername()));
        }
        users.add(user);
        return user;
    }

    public User updateUser (@NotNull User user, String userName){
        User userToBeUpload = getUserByUsername(userName);
        userToBeUpload.setNickName(user.getNickName());
        userToBeUpload.setPassword(user.getPassword());
        return userToBeUpload;
    }

    public void deleteUser (String username) {
        User userToBeDelete = getUserByUsername(username);
        users.remove(userToBeDelete);
    }
}
