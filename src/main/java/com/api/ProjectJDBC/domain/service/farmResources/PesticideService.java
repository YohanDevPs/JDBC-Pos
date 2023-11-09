package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.entities.resources.Pesticide;

import java.util.List;

public interface PesticideService {
    
    void save(Pesticide pesticide);
    Pesticide getById(long id);
    List<Pesticide> getAll();
    void remove(long id);
    void update(Pesticide pesticide);
}
