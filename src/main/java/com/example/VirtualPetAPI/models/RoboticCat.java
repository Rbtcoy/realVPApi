package com.example.VirtualPetAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoboticCat extends RoboticPet {

    @Id
    @GeneratedValue
    private Long id;
    
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public RoboticCat(String name, String description){
        super(name, description);
    }
    
}

