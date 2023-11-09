package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.entities.resources.Pesticide;
import com.api.ProjectJDBC.domain.repository.PesticideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesticideServiceImpl implements PesticideService{


    @Autowired
    private PesticideRepository repository;

    @Override
    public void save(Pesticide pesticide) {
        repository.save(pesticide);
    }

    @Override
    public Pesticide getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Pesticide> getAll() {
        return repository.getAll();
    }

    @Override
    public void remove(long id) {
        repository.remove(id);
    }

    @Override
    public void update(Pesticide pesticide) {
        repository.update(pesticide);
    }
}
