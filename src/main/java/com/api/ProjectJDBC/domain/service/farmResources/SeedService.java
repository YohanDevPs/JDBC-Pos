package com.api.ProjectJDBC.domain.service.farmResources;


import com.api.ProjectJDBC.domain.entities.resources.Seed;

import java.util.List;

public interface SeedService {
    
    void save(Seed Seed);
    Seed getById(long id);
    List<Seed> getAll();
    void remove(long id);
    void update(Seed Seed);
}
