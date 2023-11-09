package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.entities.resources.Seed;
import com.api.ProjectJDBC.domain.repository.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedServiceImpl implements SeedService{

    @Autowired
    private SeedRepository repository;

    @Override
    public void save(Seed seed) {
        repository.save(seed);
    }

    @Override
    public Seed getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Seed> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(long id) {
        repository.remove(id);
    }

    @Override
    public void update(Seed seed) {
        repository.update(seed);
    }
}
