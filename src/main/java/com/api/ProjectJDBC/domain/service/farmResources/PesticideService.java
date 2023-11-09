package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.entities.resources.Pesticide;

import java.util.List;

public interface PesticideService {
    
    public void save(Pesticide pesticide);
    public Pesticide getById(long id);
    public List<Pesticide> getAll();
    public void remove(long id);
    public void update(Pesticide pesticide);
}
