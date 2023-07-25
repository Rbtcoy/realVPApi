package com.example.VirtualPetAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPetAPI.models.RoboticDog;

public interface RoboticDogRepository extends JpaRepository<RoboticDog, Long>{
    
}
