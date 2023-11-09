package com.api.ProjectJDBC.domain.repository;

import com.api.ProjectJDBC.domain.dao.FertilizerDao;
import com.api.ProjectJDBC.domain.entities.resources.Fertilizer;
import com.api.ProjectJDBC.domain.enums.FertilizerType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class FertilizerRepository implements FertilizerDao {
    
    private JdbcTemplate jdbcTemplate;

    public FertilizerRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Fertilizer> getAll() {
        String sql = "SELECT id, name, quantity, description, fertilizer_type, amount FROM tfertilizer";
        return jdbcTemplate.query(sql, (rs, i) ->  new Fertilizer(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat(3),
                rs.getString("description"),
                Enum.valueOf(FertilizerType.class, rs.getString("fertilizer_type")),
                rs.getFloat("amount")
        ));
    }

    public void save(Fertilizer fertilizer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO tfertilizer (name, quantity, description, fertilizer_type, amount) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, fertilizer.getName());
            pst.setFloat(2, fertilizer.getQuantity());
            pst.setString(3, fertilizer.getDescription());
            pst.setString(4, String.valueOf(fertilizer.getFertilizerType()));
            pst.setFloat(5, fertilizer.getAmount());
            return pst;
        }, keyHolder);
        fertilizer.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    public Fertilizer getById(Long id) {
        String sql = "SELECT name, quantity, description, fertilizer_type, amount FROM tfertilizer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Fertilizer(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat(3),
                rs.getString("description"),
                Enum.valueOf(FertilizerType.class, rs.getString("fertilizer_type")),
                rs.getFloat("amount")
        ));
    }

    public void update(Fertilizer fertilizer) {
        String sql = "UPDATE tfertilizer SET name = ? , quantity = ?, description = ?, fertilizer_type = ?, amount = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                fertilizer.getName(),
                fertilizer.getQuantity(),
                fertilizer.getDescription(),
                fertilizer.getFertilizerType(),
                fertilizer.getId());
    }

    public void remove(Long id) {
        String sql = "DELETE FROM tseed WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
