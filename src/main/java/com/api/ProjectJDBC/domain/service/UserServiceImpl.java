package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.dao.UserDao;
import com.api.ProjectJDBC.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User getById(long id) throws SQLException {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void remove(long id) {
        userDao.remove(id);
    }

    @Override
    public void update(User user) throws SQLException {
        userDao.update(user);
    }
}
