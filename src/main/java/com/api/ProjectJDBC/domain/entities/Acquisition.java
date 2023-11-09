package com.api.ProjectJDBC.domain.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tacquisition")
public class Acquisition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFarm")
    private Farm farm;
    @ManyToMany(mappedBy = "acquisitions",
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<Resource> resourceList;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Acquisition(Long id, String description, Date date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
