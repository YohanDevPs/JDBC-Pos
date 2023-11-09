package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.dao.AcquisitionDao;
import com.api.ProjectJDBC.domain.entities.Acquisition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquisitionServiceImpl implements AcquisitionService {

    @Autowired
    private AcquisitionDao acquisitionDao;


    @Override
    public void save(Acquisition acquisition) {
        acquisitionDao.save(acquisition);
    }

    @Override
    public Acquisition getById(long id) {
        return acquisitionDao.getById(id);
    }

    @Override
    public List<Acquisition> getAll() {
        return acquisitionDao.getAll();
    }

    @Override
    public void remove(long id) {
        acquisitionDao.remove(id);
    }

    @Override
    public void update(Acquisition acquisition) {
        acquisitionDao.update(acquisition);
    }
}
