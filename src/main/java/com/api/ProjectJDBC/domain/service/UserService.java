package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void save(User user);
    User getById(long id) throws SQLException;
    List<User> getAll();
    void remove(long id);
    void update(User user) throws SQLException;
}
