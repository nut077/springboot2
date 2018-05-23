package com.freedom.nut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = PetClinicProperties.class)
public class NutApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutApplication.class, args);
    }
}
