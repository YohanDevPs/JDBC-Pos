package com.api.ProjectJDBC.domain.controller;

import com.api.ProjectJDBC.domain.entities.Acquisition;
import com.api.ProjectJDBC.domain.service.AcquisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/acquisition/v1")
public class AcquisitionController {

    @Autowired
    private AcquisitionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Acquisition acquisition) {
        service.save(acquisition);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Acquisition> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Acquisition getById(@PathVariable(value = "id") Long id) throws SQLException {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Acquisition Acquisition) throws SQLException {
        service.update(Acquisition);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Long id) {
        service.remove(id);
    }
}
