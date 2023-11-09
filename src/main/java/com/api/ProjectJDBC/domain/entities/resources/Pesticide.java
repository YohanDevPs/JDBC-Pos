package com.api.ProjectJDBC.domain.entities.resources;

import com.api.ProjectJDBC.domain.enums.PesticideType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tpesticide")
public class Pesticide extends Resource {

    private String description;
    @Column(name = "pesticide_type")
    private PesticideType pesticideType;
    private float amount;

    public Pesticide(Long id, String name, float quantity, String description, PesticideType pesticideType, float amount) {
        super(id, name, quantity);
        this.description = description;
        this.pesticideType = pesticideType;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PesticideType getPesticideType() {
        return pesticideType;
    }

    public void setPesticideType(PesticideType pesticideType) {
        this.pesticideType = pesticideType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
