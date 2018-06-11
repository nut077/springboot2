package com.freedom.nut.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_owner")
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSeqGen")
    @SequenceGenerator(name = "petClinicSeqGen", sequenceName = "petclinic_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}
