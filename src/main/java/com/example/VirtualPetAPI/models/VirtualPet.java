package com.example.VirtualPetAPI.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.data.annotation.Id;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VirtualPet {
    
    @Id
    @GeneratedValue
    protected Long id;
    protected int food = 60;
    protected int water = 60;
    protected int play = 60;
    protected int healthValue = 10;
    protected int happiness = 10;
    protected String healthDisplay = ":D";
    protected String name = "";
    protected String description = "";
    

    protected int randoFive = (int) (Math.random() * 5);
    protected int randoTwo = (int) ((Math.random() * 2)+1);

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public VirtualPet(){
        this.name = "Charley";
        this.description = "He's a dumb dog...";
    }

    public int getWater() {
        return water;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public int getHappiness() {
        return happiness;
    }

    public String getHealthDisplay() {
        return healthDisplay;
    }

    public int getPlay() {
        return play;
    }

    public int getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void feedPet() {
        food += 10;
        water -= randoFive;
        play -= randoFive;
    }

    public void waterPet() {
        food -= randoFive;
        water += 10;
        play -= randoFive;
    }

    public void playPet() {
        food -= randoFive;
        water -= randoFive;
        play += 10;
    }

    public void reduceHappiness(){
        happiness--;
    }
    
    public void timePass(){
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
