package com.api.ProjectJDBC.domain.dao;

import com.api.ProjectJDBC.domain.entities.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();
    void save(User user);
    User getById(Long id);
    void update(User user);
    void remove(Long id);
}
