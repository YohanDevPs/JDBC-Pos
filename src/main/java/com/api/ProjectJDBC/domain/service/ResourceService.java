package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.Resource;

import java.util.List;

public interface ResourceService {
    public void save(Resource Resource);
    public Resource getById(long id);
    public List<Resource> getAll();
    public void remove(long id);
    public void update(Resource Resource);
}
