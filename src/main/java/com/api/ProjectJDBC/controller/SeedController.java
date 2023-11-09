package com.api.ProjectJDBC.controller;

import com.api.ProjectJDBC.domain.entities.resources.Seed;
import com.api.ProjectJDBC.domain.service.farmResources.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seed/v1")
public class SeedController {

    @Autowired
    private SeedService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Seed seed) {
        service.save(seed);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Seed> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Seed getById(@PathVariable(value = "id") Long id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Seed seed)  {
        service.update(seed);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Long id) {
        service.remove(id);
    }
}
