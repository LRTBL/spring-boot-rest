package com.lrtbl.helloworld.dependencyinjection.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:areas.properties")
public class PropertyConfiguration {

    @Bean
    public PropertySourcesPlaceholderConfigurer loadProperties () {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
