package com.api.ProjectJDBC.controller;

import com.api.ProjectJDBC.domain.entities.Farm;
import com.api.ProjectJDBC.domain.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/farm/v1")
public class FarmController {

    @Autowired
    private FarmService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Farm farm) {
        service.save(farm);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Farm> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Farm getById(@PathVariable(value = "id") Long id) throws SQLException {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Farm Farm) throws SQLException {
        service.update(Farm);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Long id) {
        service.remove(id);
    }
}
