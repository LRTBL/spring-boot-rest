package com.lrtbl.helloworld.dependencyinjection.classes;

import com.lrtbl.helloworld.dependencyinjection.interfaces.Volador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component("otro_animal")
public class OtroAnimal implements Volador {

    private static final Logger log = LoggerFactory.getLogger(OtroAnimal.class);

    @Override
    public String volar() {
        log.info("Estoy volando como el otro animal");
        return null;
    }
}
