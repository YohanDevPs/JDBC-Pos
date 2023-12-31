package com.api.ProjectJDBC.domain.repository;

import com.api.ProjectJDBC.domain.dao.ResourceDao;
import com.api.ProjectJDBC.domain.entities.resources.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class ResourceRepository implements ResourceDao {

    private JdbcTemplate jdbcTemplate;

    public ResourceRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Resource> getAll() {
        String sql = "SELECT id, name, quantity FROM tresource";
        return jdbcTemplate.query(sql, (rs, i) ->  new Resource(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat(3)
        ));
    };

    public void save(Resource resource) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO tresource (name, quantity) VALUES (?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, resource.getName());
            pst.setFloat(2, resource.getQuantity());
            return pst;
        }, keyHolder);
        resource.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    public Resource getById(Long id) {
        String sql = "SELECT id, name, quantity FROM tresource WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Resource (
                rs.getLong("id"),
                rs.getString("name"),
                rs.getFloat("quantity")
        ));
    }

    public void update(Resource resource) {
        String sql = "UPDATE tresource SET name = ?, quantity = ? WHERE id = ?";
        jdbcTemplate.update(sql, resource.getName(), resource.getQuantity(), resource.getId());
    }

    public void remove(Long id) {
        String sql = "DELETE FROM tresource WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
