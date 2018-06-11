package com.freedom.nut.dao.jdbc;

import com.freedom.nut.dao.PetRepository;
import com.freedom.nut.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepositoryJdbcImpl implements PetRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PetRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pet findById(Long id) {
        return null;
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public void create(Pet pet) {

    }

    @Override
    public Pet update(Pet pet) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteByOwner(Long ownerId) {
        String sql = "delete from t_pet where id = ?";
        jdbcTemplate.update(sql, ownerId);
    }
}
