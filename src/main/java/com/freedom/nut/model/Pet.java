package com.freedom.nut.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_pet")
@Data
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", owner=" + owner + "]";
    }

}
