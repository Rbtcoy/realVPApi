package com.example.VirtualPetAPI.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class RoboticPet extends VirtualPet{
    protected int oilLevel = 30;
    protected int randoTen = (int) ((Math.random() * 10)+1);

    @Id
    @GeneratedValue
    protected Long id;

    public int getOilLevel(){
        return oilLevel;
    }

    public void oilRobo(){
        oilLevel += 10;
    }

    public RoboticPet(String name, String description){
        super(name, description);
    }

    public RoboticPet(){
        
    }

    public void timePass(){
        oilLevel -= 2;
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
        
    }
    
}
