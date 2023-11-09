package com.api.ProjectJDBC.domain.entities;

import com.api.ProjectJDBC.domain.enums.SeedType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tseed")
public class Seed extends Resource{

    private String description;
    @Column(name = "seed_type")
    private SeedType seedType;
    private float amount;

    public Seed(Long id, String name, float quantity, String description, SeedType seedType, float amount) {
        super(id, name, quantity);
        this.description = description;
        this.seedType = seedType;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SeedType getSeedType() {
        return seedType;
    }

    public void setSeedType(SeedType seedType) {
        this.seedType = seedType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
