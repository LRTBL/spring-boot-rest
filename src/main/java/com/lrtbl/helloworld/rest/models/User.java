package com.lrtbl.helloworld.rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
public class User {

    @NotEmpty
    @NotNull
    private String nickName;

    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String password;
}
