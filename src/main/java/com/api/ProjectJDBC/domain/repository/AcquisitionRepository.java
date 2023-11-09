package com.api.ProjectJDBC.domain.repository;

import com.api.ProjectJDBC.domain.entities.Acquisition;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class AcquisitionRepository {

    private JdbcTemplate jdbcTemplate;

    public AcquisitionRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Acquisition> getAll() {
        String sql = "SELECT id, description, dateTime FROM tacquisition";
        return jdbcTemplate.query(sql, (rs, i) ->  new Acquisition(
                rs.getLong("id"),
                rs.getString("description"),
                new Date(rs.getDate("date").getTime())
        ));
    };

    public void save(Acquisition acquisition) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO tacquisition (description, date) VALUES (?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, acquisition.getDescription());
            pst.setDate(2, new java.sql.Date(acquisition.getDate().getTime()));
            return pst;
        }, keyHolder);
        acquisition.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    public Acquisition getById(Long id) {
        String sql = "SELECT id, description, date FROM tacquisition WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Acquisition(
                rs.getLong("id"),
                rs.getString("description"),
                new Date(rs.getDate("date").getTime())
        ));
    }

    public void update(Acquisition acquisition) {
        String sql = "UPDATE tacquisition SET name = ?, quantity = ? WHERE id = ?";
        jdbcTemplate.update(sql, acquisition.getDescription(), acquisition.getDate(), acquisition.getId());
    }

    public void remove(Long id) {
        String sql = "DELETE FROM tacquisition WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
