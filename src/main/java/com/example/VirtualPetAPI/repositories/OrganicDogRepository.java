package com.example.VirtualPetAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPetAPI.models.OrganicDog;

public interface OrganicDogRepository extends JpaRepository<OrganicDog, Long>{
    
}
