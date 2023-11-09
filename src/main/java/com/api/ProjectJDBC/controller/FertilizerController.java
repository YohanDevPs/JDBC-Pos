package com.api.ProjectJDBC.controller;

import com.api.ProjectJDBC.domain.entities.resources.Fertilizer;
import com.api.ProjectJDBC.domain.service.farmResources.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fertilizer/v1")
public class FertilizerController {

    @Autowired
    private FertilizerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Fertilizer fertilizer) {
        service.save(fertilizer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fertilizer> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fertilizer getById(@PathVariable(value = "id") Long id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Fertilizer fertilizer)  {
        service.update(fertilizer);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Long id) {
        service.remove(id);
    }
}

