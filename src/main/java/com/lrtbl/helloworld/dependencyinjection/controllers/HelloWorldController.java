package com.lrtbl.helloworld.dependencyinjection.controllers;


import com.lrtbl.helloworld.dependencyinjection.classes.Animal;
import com.lrtbl.helloworld.dependencyinjection.interfaces.Volador;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello-world")
@RequiredArgsConstructor
public class HelloWorldController {

    private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Qualifier("otro_animal")
    private final Volador volador;

    private final Animal animal;

    private final List<Volador> listaVoladores;
    @GetMapping
    public ResponseEntity<String> helloWorld () {
        volador.volar();
        listaVoladores.forEach((Volador::volar));
        logger.info(animal.getNombre());
        return new ResponseEntity<>("Hello Wor", HttpStatus.OK);
    }
}