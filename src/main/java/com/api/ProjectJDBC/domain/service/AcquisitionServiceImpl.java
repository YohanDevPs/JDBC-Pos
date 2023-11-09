package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.Acquisition;
import com.api.ProjectJDBC.domain.repository.AcquisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquisitionServiceImpl implements AcquisitionService{

    @Autowired
    private AcquisitionRepository repository;


    @Override
    public void save(Acquisition acquisition) {
        repository.save(acquisition);
    }

    @Override
    public Acquisition getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Acquisition> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(long id) {
        repository.remove(id);
    }

    @Override
    public void update(Acquisition acquisition) {
        repository.update(acquisition);
    }
}
