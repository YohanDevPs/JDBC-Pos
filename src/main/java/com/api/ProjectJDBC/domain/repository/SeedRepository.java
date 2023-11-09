package com.api.ProjectJDBC.domain.repository;

import com.api.ProjectJDBC.domain.dao.SeedDao;
import com.api.ProjectJDBC.domain.entities.resources.Seed;
import com.api.ProjectJDBC.domain.enums.SeedType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;


@Repository
public class SeedRepository implements SeedDao {
    private JdbcTemplate jdbcTemplate;

    public SeedRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Seed> getAll() {
        String sql = "SELECT id, name, quantity, description, seed_type, amount FROM tseed";
        return jdbcTemplate.query(sql, (rs, i) ->  new Seed(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat(3),
                rs.getString("description"),
                Enum.valueOf(SeedType.class, rs.getString("seed_type")),
                rs.getFloat("amount")
        ));
    }

    public void save(Seed seed) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO tseed (name, quantity, description, seed_type, amount) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, seed.getName());
            pst.setFloat(2, seed.getQuantity());
            pst.setString(3, seed.getDescription());
            pst.setString(4, String.valueOf(seed.getSeedType()));
            pst.setFloat(5, seed.getAmount());
            return pst;
        }, keyHolder);
        seed.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    public Seed getById(Long id) {
        String sql = "SELECT name, quantity, description, seed_type, amount FROM tseed WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Seed(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat(3),
                rs.getString("description"),
                Enum.valueOf(SeedType.class, rs.getString("seed_type")),
                rs.getFloat("amount")
        ));
    }

    public void update(Seed seed) {
        String sql = "UPDATE tfertilizer SET name = ? , quantity = ?, description = ?, seed_type = ?, amount = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                seed.getName(),
                seed.getQuantity(),
                seed.getDescription(),
                seed.getSeedType(),
                seed.getId());
    }

    public void remove(Long id) {
        String sql = "DELETE FROM tseed WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
