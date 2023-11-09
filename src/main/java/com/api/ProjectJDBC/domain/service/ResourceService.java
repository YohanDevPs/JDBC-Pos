package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.resources.Resource;

import java.util.List;

public interface ResourceService {

    void save(Resource Resource);
    Resource getById(long id);
    List<Resource> getAll();
    void remove(long id);
    void update(Resource Resource);
}
