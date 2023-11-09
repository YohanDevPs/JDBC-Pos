package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.Resource;
import com.api.ProjectJDBC.domain.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceRepository repository;

    @Override
    public void save(Resource resource) {
        repository.save(resource);
    }

    @Override
    public Resource getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Resource> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(long id) {
        repository.remove(id);
    }

    @Override
    public void update(Resource resource) {
        repository.update(resource);
    }
}
