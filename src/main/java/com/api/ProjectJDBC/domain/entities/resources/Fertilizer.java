package com.api.ProjectJDBC.domain.entities.resources;

import com.api.ProjectJDBC.domain.enums.FertilizerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tfertilizer")
public class Fertilizer extends Resource {
    @Column(name = "description")
    private String description;
    @Column(name = "fertilizer_type")
    private FertilizerType fertilizerType;
    private float amount;

    public Fertilizer(Long id, String name, float quantity, String description, FertilizerType fertilizerType, float amount) {
        super(id, name, quantity);
        this.description = description;
        this.fertilizerType = fertilizerType;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FertilizerType getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(FertilizerType fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
