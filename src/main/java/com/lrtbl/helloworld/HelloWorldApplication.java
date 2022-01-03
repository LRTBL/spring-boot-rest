package com.lrtbl.helloworld;

import com.github.javafaker.Faker;
import com.lrtbl.helloworld.aop.TargetObject;
import com.lrtbl.helloworld.dependencyinjection.classes.Animal;
import com.lrtbl.helloworld.lifecycle.LIfeCycleBean;
import com.lrtbl.helloworld.profiles.EnviromentService;
import com.lrtbl.helloworld.rest.entities.User;
import com.lrtbl.helloworld.rest.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
//public class HelloWorldApplication {
public class HelloWorldApplication implements ApplicationRunner {

	@Autowired
	private Faker faker;

	@Autowired
	private UserRepository repository;
//	private static final Logger log = LoggerFactory.getLogger(HelloWorldApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(HelloWorldApplication.class, args);
//		TargetObject targetObject = context.getBean(TargetObject.class);
//		targetObject.helloString("HOLA MUNDO");
//		LIfeCycleBean bean = context.getBean(LIfeCycleBean.class);
//		EnviromentService enviromentService = context.getBean(EnviromentService.class);
//		log.info(enviromentService.getEnviroment());
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i =0; i<50; i++){
			User user = new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			user.setProfile(null);
			repository.save(user);
		}

	}
}
