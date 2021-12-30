package com.lrtbl.helloworld;

import com.lrtbl.helloworld.dependencyinjection.classes.Animal;
import com.lrtbl.helloworld.lifecycle.LIfeCycleBean;
import com.lrtbl.helloworld.profiles.EnviromentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class HelloWorldApplication {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldApplication.class);


	public static void main(String[] args) {
//		SpringApplication.run(HelloWorldApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(HelloWorldApplication.class, args);
		LIfeCycleBean bean = context.getBean(LIfeCycleBean.class);
//		EnviromentService enviromentService = context.getBean(EnviromentService.class);
//		log.info(enviromentService.getEnviroment());
	}

}
