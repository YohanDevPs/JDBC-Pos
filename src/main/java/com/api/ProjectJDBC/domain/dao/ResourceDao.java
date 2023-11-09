package com.api.ProjectJDBC.domain.dao;

import com.api.ProjectJDBC.domain.entities.resources.Resource;

import java.util.List;

public interface ResourceDao {

    List<Resource> getAll();
    void save(Resource resource);
    Resource getById(Long id);
    void update(Resource resource);
    void remove(Long id);
}
