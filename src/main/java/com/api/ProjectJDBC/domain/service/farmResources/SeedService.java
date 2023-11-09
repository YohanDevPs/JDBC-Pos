package com.api.ProjectJDBC.domain.service.farmResources;


import com.api.ProjectJDBC.domain.entities.resources.Seed;

import java.util.List;

public interface SeedService {
    
    public void save(Seed Seed);
    public Seed getById(long id);
    public List<Seed> getAll();
    public void remove(long id);
    public void update(Seed Seed);
}
