package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.entities.resources.Fertilizer;
import com.api.ProjectJDBC.domain.repository.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizerServiceImpl implements FertilizerService{

    @Autowired
    private FertilizerRepository repository;

    @Override
    public void save(Fertilizer fertilizer) {
        repository.save(fertilizer);
    }

    @Override
    public Fertilizer getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Fertilizer> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(long id) {
        repository.remove(id);
    }

    @Override
    public void update(Fertilizer fertilizer) {
        repository.update(fertilizer);
    }
}
