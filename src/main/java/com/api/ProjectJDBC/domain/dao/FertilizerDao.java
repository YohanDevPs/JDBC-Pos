package com.api.ProjectJDBC.domain.dao;

import com.api.ProjectJDBC.domain.entities.resources.Fertilizer;

import java.util.List;

public interface FertilizerDao {

    List<Fertilizer> getAll();
    void save(Fertilizer fertilizer);
    Fertilizer getById(Long id);
    void update(Fertilizer fertilizer);
    void remove(Long id);
}
