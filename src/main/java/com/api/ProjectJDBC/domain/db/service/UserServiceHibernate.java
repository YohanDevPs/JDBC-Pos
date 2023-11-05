package com.api.ProjectJDBC.domain.db.service;

import com.api.ProjectJDBC.domain.db.repository.UserRepository;
import com.api.ProjectJDBC.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceHibernate implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        repository.save(user);
        return user;
    }
    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getById(long id) {
        return repository.getById(id);
    }


    @Override
    public void remove(long id) {
        repository.deleteById(id);
    }

    @Override
    public User update(User user) {
        return repository.update(user);
    }
}
