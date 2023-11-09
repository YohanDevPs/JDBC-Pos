package com.api.ProjectJDBC.domain.controller;

import com.api.ProjectJDBC.domain.entities.Resource;
import com.api.ProjectJDBC.domain.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource/v1")
public class ResourceController {
    @Autowired
    private ResourceService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Resource Resource) {
        service.save(Resource);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Resource> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Resource getById(@PathVariable(value = "id") Long id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Resource Resource)  {
        service.update(Resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Long id) {
        service.remove(id);
    }
}
