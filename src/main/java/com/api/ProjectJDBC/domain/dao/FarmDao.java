package com.api.ProjectJDBC.domain.dao;

import com.api.ProjectJDBC.domain.entities.Farm;

import java.util.List;

public interface FarmDao {

    List<Farm> getAll();
    void save(Farm farm);
    Farm getById(Long id);
    void update(Farm farm);
    void remove(Long id);
}
