package com.example.VirtualPetAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VirtualPetAPI.VirtualPetNotFoundException;
import com.example.VirtualPetAPI.models.OrganicDog;
import com.example.VirtualPetAPI.repositories.OrganicDogRepository;

@RestController
public class OrganicDogController {
    

    private final OrganicDogRepository repository;

    OrganicDogController(OrganicDogRepository repository){
        this.repository = repository;
    }

    @GetMapping("/OrganicDog")
    List<OrganicDog> all(){
        return repository.findAll();
    }

    @PostMapping("/OrganicDog")
    OrganicDog newOrganicDog(@RequestBody OrganicDog newOrganicDog){
        return repository.save(newOrganicDog);
    }

    @GetMapping("/OrganicDog/{id}")
    OrganicDog one(@PathVariable Long id){

        return repository.findById(id)
            .orElseThrow(() -> new VirtualPetNotFoundException(id));
    }

    @PutMapping("/OrganicDog/{id}")
    OrganicDog replaceOrganicDog(@RequestBody OrganicDog newOrganicDog, 
    @PathVariable Long id){

        return repository.findById(id)
            .map(organicdog -> {
                organicdog.setName(newOrganicDog.getName());
                organicdog.setDescription(newOrganicDog.getDescription());
                return repository.save(organicdog);
        })
        .orElseGet(() -> {
            newOrganicDog.setId(id);
            return repository.save(newOrganicDog);
        });
    }

    @DeleteMapping("/OrganicDog/{id}")
    void deleteOrganicDog(@PathVariable Long id){
        repository.deleteById(id);
    }
}
