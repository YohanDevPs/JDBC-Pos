package com.api.ProjectJDBC.domain.controller;

import com.api.ProjectJDBC.domain.entities.User;
import com.api.ProjectJDBC.domain.db.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable(value = "id") Long id) {
        return userService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Long id) {
        userService.remove(id);
    }
}
