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
import com.example.VirtualPetAPI.models.OrganicCat;
import com.example.VirtualPetAPI.repositories.OrganicCatRepository;

@RestController
public class OrganicCatController {

    private final OrganicCatRepository repository;

    OrganicCatController(OrganicCatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/OrganicCat")
    List<OrganicCat> all(){
        return repository.findAll();
    }

    @PostMapping("/OrganicCat")
    OrganicCat newOrganicCat(@RequestBody OrganicCat newOrganicCat){
        return repository.save(newOrganicCat);
    }

    @GetMapping("/OrganicCat/{id}")
    OrganicCat one(@PathVariable Long id){

        return repository.findById(id)
            .orElseThrow(() -> new VirtualPetNotFoundException(id));
    }

    @PutMapping("/OrganicCat/{id}")
    OrganicCat replaceOrganicCat(@RequestBody OrganicCat newOrganicCat, 
    @PathVariable Long id){

        return repository.findById(id)
            .map(organiccat -> {
                organiccat.setName(newOrganicCat.getName());
                organiccat.setDescription(newOrganicCat.getDescription());
                return repository.save(organiccat);
        })
        .orElseGet(() -> {
            newOrganicCat.setId(id);
            return repository.save(newOrganicCat);
        });
    }

    @DeleteMapping("/OrganicCat/{id}")
    void deleteOrganicCat(@PathVariable Long id){
        repository.deleteById(id);
    }

}
