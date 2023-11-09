package com.api.ProjectJDBC.domain.service.farmResources;

import com.api.ProjectJDBC.domain.entities.resources.Fertilizer;

import java.util.List;

public interface FertilizerService {

    void save(Fertilizer fertilizer);
    Fertilizer getById(long id);
    List<Fertilizer> getAll();
    void remove(long id);
    void update(Fertilizer fertilizer);
}
