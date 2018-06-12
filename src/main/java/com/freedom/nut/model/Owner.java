package com.freedom.nut.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_owner")
@NoArgsConstructor
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSeqGen")
    @SequenceGenerator(name = "petClinicSeqGen", sequenceName = "petclinic_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Set<Pet> pets = new HashSet<>();

    @Override
    public String toString() {
        return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
