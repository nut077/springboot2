package com.freedom.nut.dao.jdbc;

import com.freedom.nut.dao.OwnerRepository;
import com.freedom.nut.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepositoryJdbcImpl implements OwnerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OwnerRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Owner> rowMapper = (rs, i) -> {
        Owner owner = new Owner();
        owner.setId(rs.getLong("id"));
        owner.setFirstName(rs.getString("first_name"));
        owner.setLastName(rs.getString("last_name"));
        return owner;
    };

    @Override
    public List<Owner> findAll() {
        String sql = "select * from t_owner";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Owner findById(Long id) {
        String sql = "select * from t_owner where id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<Owner> findByFirstName(String firstName) {
        String sql = "select * from t_owner where first_name like ?";
        return jdbcTemplate.query(sql, rowMapper, "%" + firstName + "%");
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return null;
    }

    @Override
    public void create(Owner owner) {

    }

    @Override
    public Owner update(Owner owner) {
        return null;
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from t_owner where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
