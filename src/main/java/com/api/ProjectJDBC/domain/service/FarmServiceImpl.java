package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.dao.FarmDao;
import com.api.ProjectJDBC.domain.entities.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    @Autowired
    private FarmDao farmDao;

    @Override
    public void save(Farm farm) {
        farmDao.save(farm);
    }

    @Override
    public Farm getById(long id) {
        return farmDao.getById(id);
    }

    @Override
    public List<Farm> getAll() {
        return farmDao.getAll();
    }

    @Override
    public void remove(long id) {
        farmDao.remove(id);
    }

    @Override
    public void update(Farm farm) {
        farmDao.update(farm);
    }
}
