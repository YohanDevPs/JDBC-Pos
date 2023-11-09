package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.Acquisition;

import java.util.List;

public interface AcquisitionService {

    void save(Acquisition acquisition);
    Acquisition getById(long id);
    List<Acquisition> getAll();
    void remove(long id);
    void update(Acquisition acquisition);
}