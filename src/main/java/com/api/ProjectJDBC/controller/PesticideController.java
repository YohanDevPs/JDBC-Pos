package com.api.ProjectJDBC.controller;

import com.api.ProjectJDBC.domain.entities.resources.Pesticide;
import com.api.ProjectJDBC.domain.service.farmResources.PesticideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesticide/v1")
public class PesticideController {

    @Autowired
    private PesticideService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Pesticide Pesticide) {
        service.save(Pesticide);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pesticide> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pesticide getById(@PathVariable(value = "id") Long id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Pesticide pesticide)  {
        service.update(pesticide);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Long id) {
        service.remove(id);
    }
}

