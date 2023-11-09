package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.Acquisition;

import java.util.List;

public interface AcquisitionService {

    public void save(Acquisition acquisition);
    public Acquisition getById(long id);
    public List<Acquisition> getAll();
    public void remove(long id);
    public void update(Acquisition acquisition);
}