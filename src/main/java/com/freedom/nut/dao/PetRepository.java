package com.freedom.nut.dao;

import com.freedom.nut.model.Pet;

import java.util.List;

public interface PetRepository {
    Pet findById(Long id);
    List<Pet> findByOwnerId(Long ownerId);
    void create(Pet pet);
    Pet update(Pet pet);
    void delete(Long id);
    void deleteByOwner(Long ownerId);
}
