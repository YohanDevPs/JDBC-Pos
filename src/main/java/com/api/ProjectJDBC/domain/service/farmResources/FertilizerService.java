package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.entities.resources.Fertilizer;

import java.util.List;

public interface FertilizerService {

    public void save(Fertilizer fertilizer);
    public Fertilizer getById(long id);
    public List<Fertilizer> getAll();
    public void remove(long id);
    public void update(Fertilizer fertilizer);
}
