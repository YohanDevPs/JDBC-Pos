package com.api.ProjectJDBC.domain.dao;

import com.api.ProjectJDBC.domain.entities.resources.Pesticide;

import java.util.List;

public interface PesticideDao {

    List<Pesticide> getAll();
    void save(Pesticide pesticide);
    Pesticide getById(Long id);
    void update(Pesticide pesticide);
    void remove(Long id);
}
