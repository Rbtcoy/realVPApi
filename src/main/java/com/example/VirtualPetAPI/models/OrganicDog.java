package com.example.VirtualPetAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrganicDog  extends OrganicPet implements Walkable{

    @Id
    @GeneratedValue
    private Long id;
    private int randoTen = (int) ((Math.random() * 10)+1);
    private boolean isWalked = false;
    private boolean isCageDirty = false;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean getWalkedState(){
        return isWalked;
    }
    public boolean getIsCageDirty(){
        return isCageDirty;
    }
    public OrganicDog(String name, String description) {
        super(name, description);
        
    }

    public OrganicDog(){
        
    }
    
    public void timePass(){
        if(!isWalked){
            healthValue--;
            if(randoTen >= 10){
                isCageDirty = true;
            }
            happiness--;
        }
        if(isCageDirty){
            healthValue--;
        }
        if(happiness < 7){
            healthValue--;
        }
        if(healthValue == 10){
            healthDisplay = ":D";
        }else if(healthValue < 10 && healthValue > 5){
            healthDisplay = ":|";
        }else if(healthValue < 5){
            healthDisplay = ":(";
        }
        isWalked = false;
    }

    public void walkThatAnimal(){
        isWalked = true;
    }
    public void cleanCage(){
        isCageDirty = false;
    }
}
