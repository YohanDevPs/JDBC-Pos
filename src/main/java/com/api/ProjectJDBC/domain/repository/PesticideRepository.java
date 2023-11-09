package com.api.ProjectJDBC.domain.repository;

import com.api.ProjectJDBC.domain.dao.PesticideDao;
import com.api.ProjectJDBC.domain.entities.resources.Pesticide;
import com.api.ProjectJDBC.domain.enums.PesticideType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class PesticideRepository implements PesticideDao {

    private JdbcTemplate jdbcTemplate;

    public PesticideRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pesticide> getAll() {
        String sql = "SELECT id, name, quantity, description, pesticide_type, amount FROM tpesticide";
        return jdbcTemplate.query(sql, (rs, i) ->  new Pesticide(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat(3),
                rs.getString("description"),
                Enum.valueOf(PesticideType.class, rs.getString("pesticide_type")),
                rs.getFloat("amount")
        ));
    };

    public void save(Pesticide pesticide) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO tpesticide (name, quantity, description, pesticide_type, amount) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pesticide.getName());
            pst.setFloat(2, pesticide.getQuantity());
            pst.setString(3, pesticide.getDescription());
            pst.setString(4, String.valueOf(pesticide.getPesticideType()));
            pst.setFloat(5, pesticide.getAmount());
            return pst;
        }, keyHolder);
        pesticide.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    public Pesticide getById(Long id) {
        String sql = "SELECT name, quantity, description, pesticide_type, amount FROM tpesticide WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Pesticide(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat(3),
                rs.getString("description"),
                Enum.valueOf(PesticideType.class, rs.getString("pesticide_type")),
                rs.getFloat("amount")
        ));
    }

    public void update(Pesticide pesticide) {
        String sql = "UPDATE tfertilizer SET name = ? , quantity = ?, description = ?, pesticide_type = ?, amount = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                pesticide.getName(),
                pesticide.getQuantity(),
                pesticide.getDescription(),
                pesticide.getPesticideType(),
                pesticide.getId());
    }

    public void remove(Long id) {
        String sql = "DELETE FROM tpesticide WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
