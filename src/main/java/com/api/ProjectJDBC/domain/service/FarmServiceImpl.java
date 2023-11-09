package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.Farm;
import com.api.ProjectJDBC.domain.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService{

    @Autowired
    private FarmRepository repository;

    @Override
    public void save(Farm farm) {
        repository.save(farm);
    }

    @Override
    public Farm getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Farm> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(long id) {
        repository.remove(id);
    }

    @Override
    public void update(Farm farm) {
        repository.update(farm);
    }
}
