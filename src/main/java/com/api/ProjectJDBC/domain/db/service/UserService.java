package com.api.ProjectJDBC.domain.db.service;

import com.api.ProjectJDBC.domain.entities.User;

import java.util.List;

public interface UserService {
    public User save(User user);
    public User getById(long id);
    public List<User> getAll();
    public void remove(long id);
    public User update(User user);
}
