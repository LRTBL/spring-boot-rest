package com.lrtbl.helloworld.dependencyinjection.classes;

import com.lrtbl.helloworld.dependencyinjection.interfaces.Volador;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Setter
@Getter
@Component("animal")
//@Scope("prototype")
@Scope("singleton")
public class Animal implements Volador {

    private static final Logger log = LoggerFactory.getLogger(Animal.class);

    private String nombre = "JOSEJOSE";

    @Value("${circle.radiussss:12}")
    private Integer edad;

    @Override
    public String volar() {
        log.info("Estoy volando$" + this.edad);
        return null;
    }
}
