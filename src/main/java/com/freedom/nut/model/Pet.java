package com.freedom.nut.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_pet")
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSeqGen")
    @SequenceGenerator(name = "petClinicSeqGen", sequenceName = "petclinic_sequence")
    private Long id;
    private String name;
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
