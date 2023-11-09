package com.api.ProjectJDBC.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tfarm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean licence;
    private String register;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Farm(Long id, String name, boolean licence, String register, User user) {
        this.id = id;
        this.name = name;
        this.licence = licence;
        this.register = register;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLicence() {
        return licence;
    }

    public void setLicence(boolean licence) {
        this.licence = licence;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
