package com.api.ProjectJDBC.domain.repository;

import com.api.ProjectJDBC.domain.dao.UserDao;
import com.api.ProjectJDBC.domain.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAll() {
        String sql = "SELECT id, name, email, password FROM tuser";
        return jdbcTemplate.query(sql, (rs, i) ->  new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password")
        ));
    };

    public void save(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO tuser (name, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            return pst;
        }, keyHolder);
        user.setId((int) Objects.requireNonNull(keyHolder.getKey()).longValue());
    }


    public User getById(Long id) {
        String sql = "SELECT id, name, email, password FROM tuser WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password")
        ));
    }

    public void update(User user) {
        String sql = "UPDATE tuser SET name = ?, email = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getId());
    }

    public void remove(Long id) {
        String sql = "DELETE FROM tuser WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
