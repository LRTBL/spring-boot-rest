package com.lrtbl.helloworld.restMongo.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ClientDto {

    @NotNull(message = "Usuario obligatorio")
    private String username;

    private String password;

}
