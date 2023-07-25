package com.example.VirtualPetAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrganicCat extends OrganicPet{
    
    @Id
    @GeneratedValue
    private Long id;
    
    
    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public OrganicCat(String name, String description) {
        super(name, description);
    }
    
}
