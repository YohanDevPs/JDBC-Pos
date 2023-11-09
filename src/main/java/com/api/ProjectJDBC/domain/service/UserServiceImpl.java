package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.User;
import com.api.ProjectJDBC.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User getById(long id) throws SQLException {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(long id) {
        repository.remove(id);
    }

    @Override
    public void update(User user) throws SQLException {
        repository.update(user);
    }
}
