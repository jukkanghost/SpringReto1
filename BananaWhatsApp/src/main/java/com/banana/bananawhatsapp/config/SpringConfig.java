package com.banana.bananawhatsapp.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.banana.bananaWhatsapp.persistencia", "com.banana.bananaWhatsapp.servicios", "com.banana.bananaWhatsapp.controladores"})
@PropertySource("classpath:application.properties")
@EntityScan("com.banana.bananaWhatsapp.modelos")
@EnableAutoConfiguration
@EnableJpaRepositories("com.banana.bananaWhatsapp.persistencia")
public class SpringConfig {
}
