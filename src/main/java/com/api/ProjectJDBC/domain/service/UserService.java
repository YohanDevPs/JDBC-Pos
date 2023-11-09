package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public void save(User user);
    public User getById(long id) throws SQLException;
    public List<User> getAll();
    public void remove(long id);
    public void update(User user) throws SQLException;
}
