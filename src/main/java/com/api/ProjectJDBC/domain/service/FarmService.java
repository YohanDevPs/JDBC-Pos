package com.api.ProjectJDBC.domain.service;

import com.api.ProjectJDBC.domain.entities.Farm;

import java.sql.SQLException;
import java.util.List;

public interface FarmService {

    public void save(Farm farm);
    public Farm getById(long id) throws SQLException;
    public List<Farm> getAll();
    public void remove(long id);
    public void update(Farm farm) throws SQLException;
}
