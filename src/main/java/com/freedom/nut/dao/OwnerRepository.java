package com.freedom.nut.dao;

import com.freedom.nut.model.Owner;

import java.util.List;

public interface OwnerRepository {
    List<Owner> findAll();
    Owner findById(Long id);
    List<Owner> findByFirstName(String firstName);
    List<Owner> findByLastName(String lastName);
    void create(Owner owner);
    Owner update(Owner owner);
    void delete(Long id);
}
