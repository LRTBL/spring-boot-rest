package com.lrtbl.helloworld.rest.controllers;

import com.lrtbl.helloworld.rest.models.User;
import com.lrtbl.helloworld.rest.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> get() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

}
