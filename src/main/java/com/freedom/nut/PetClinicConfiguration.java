package com.freedom.nut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PetClinicConfiguration {
    private PetClinicProperties petClinicProperties;

    @Autowired
    public PetClinicConfiguration(PetClinicProperties petClinicProperties) {
        this.petClinicProperties = petClinicProperties;
    }

    @PostConstruct
    public void init() {
        System.out.println("Display owners with pets :" + petClinicProperties.isDisplayOwnersWithPets());
    }

}
