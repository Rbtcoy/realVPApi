package com.example.VirtualPetAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VirtualPetAPI.models.OrganicCat;

public interface OrganicCatRepository extends JpaRepository<OrganicCat, Long>{
    
}
