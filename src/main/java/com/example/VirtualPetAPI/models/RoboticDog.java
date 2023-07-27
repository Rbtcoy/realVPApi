package com.example.VirtualPetAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoboticDog extends RoboticPet implements Walkable{
    
    private boolean isWalked;
    private boolean walkedBuffer;
    private boolean isCageDirty;
    @Id
    @GeneratedValue
    private Long id;
    
    public Long getId(){
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
    
    public RoboticDog(String name, String description) {
        super(name, description);
        this.oilLevel = 30;
        this.play = 60;
        this.healthValue = 10;
        this.happiness = 10;
        this.healthDisplay = ":D";
        this.isWalked = false;
        this.isCageDirty = false;
    }
    public RoboticDog(){
        
    }

    public void timePass(){
        oilLevel -= 2;
        if(!isWalked){
            healthValue--;
            if(randoTen >= 10){
                isCageDirty = true;
            }
            happiness--;
        }
        if(isCageDirty){
            healthValue--;
            happiness--;
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
        if(walkedBuffer){
            walkedBuffer = false;
        }else{
            isWalked = false;
        }
    }
    public void walkThatAnimal(){
        isWalked = true;
        happiness+=2;
        walkedBuffer = true;
    }
    public void cleanCage(){
        isCageDirty = false;
    }
}
