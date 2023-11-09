package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.Farm;

import java.sql.SQLException;
import java.util.List;

public interface FarmService {

    void save(Farm farm);
    Farm getById(long id) throws SQLException;
    List<Farm> getAll();
    void remove(long id);
    void update(Farm farm) throws SQLException;
}
