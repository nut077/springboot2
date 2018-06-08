package com.freedom.nut.model;

import lombok.Data;

import java.util.Date;

@Data
public class Pet {
    private Long id;
    private String name;
    private Date birthDate;
    private Owner owner;
}
