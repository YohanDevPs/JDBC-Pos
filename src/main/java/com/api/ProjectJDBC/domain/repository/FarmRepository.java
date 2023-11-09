package com.api.ProjectJDBC.domain.repository;

import com.api.ProjectJDBC.domain.dao.FarmDao;
import com.api.ProjectJDBC.domain.entities.Farm;
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
public class FarmRepository implements FarmDao {

    private JdbcTemplate jdbcTemplate;
    private UserRepository userRepository;

    public FarmRepository(JdbcTemplate jdbcTemplate, UserRepository userRepository){
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
    }

    public List<Farm> getAll() {
        String sql = "SELECT id, name, licence, register, idUser FROM tfarm";
        return jdbcTemplate.query(sql, (rs, i) ->  new Farm(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getBoolean(3),
                rs.getString("register"),
                rs.getObject(5, User.class)
        ));
    }

    public void save(Farm farm) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO tfarm (name, licence, register, idUser) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, farm.getName());
            pst.setBoolean(2, farm.isLicence());
            pst.setString(3, farm.getRegister());
            pst.setLong(4, farm.getUser().getId());
            return pst;
        }, keyHolder);
        farm.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    public Farm getById(Long id) {
        String sql = "SELECT id, name, licence, register, idUser FROM tfarm WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Farm farmResult = new Farm(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getBoolean("licence"),
                    rs.getString("register"),
                    null // Deixe idUser como null por enquanto
            );
            // Recuperar o objeto User separadamente usando o idUser
            Long userId = rs.getLong("idUser");
            User user = userRepository.getById(userId);
            farmResult.setUser(user);
            return farmResult;
        });
    };

    public void update(Farm farm) {
        String sql = "UPDATE tfarm SET name = ?, licence = ?, register = ? WHERE id = ?";
        jdbcTemplate.update(sql, farm.getName(), farm.isLicence(), farm.getRegister(), farm.getId());
    }

    public void remove(Long id) {
        String sql = "DELETE FROM tfarm WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
