package com.api.ProjectJDBC.domain.dao;

import com.api.ProjectJDBC.domain.entities.resources.Seed;

import java.util.List;

public interface SeedDao {

    List<Seed> getAll();
    void save(Seed seed);
    Seed getById(Long id);
    void update(Seed seed);
    void remove(Long id);
}
