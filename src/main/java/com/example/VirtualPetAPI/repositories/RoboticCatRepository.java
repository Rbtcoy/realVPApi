package com.example.VirtualPetAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPetAPI.models.RoboticCat;

public interface RoboticCatRepository extends JpaRepository<RoboticCat, Long> {
    
}
