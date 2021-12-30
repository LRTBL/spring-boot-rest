package com.lrtbl.helloworld.rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String nickName;
    private String username;
    private String password;
}
