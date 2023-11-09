package com.api.ProjectJDBC.domain.dao;

import com.api.ProjectJDBC.domain.entities.Acquisition;

import java.util.List;
public interface AcquisitionDao {

    List<Acquisition> getAll();
    void save(Acquisition acquisition);
    Acquisition getById(Long id);
    void update(Acquisition acquisition);
    void remove(Long id);
}
