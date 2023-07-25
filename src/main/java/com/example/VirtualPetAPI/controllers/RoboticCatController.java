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
import com.example.VirtualPetAPI.models.RoboticCat;
import com.example.VirtualPetAPI.repositories.RoboticCatRepository;

@RestController
public class RoboticCatController {
    private final 
    RoboticCatRepository repository;

    RoboticCatController(RoboticCatRepository repository){
        this.repository = repository;
    }

    @GetMapping("/RoboticCat")
    List<RoboticCat> all(){
        return repository.findAll();
    }

    @PostMapping("/RoboticCat")
    RoboticCat newRoboticCat(@RequestBody RoboticCat newRoboticCat){
        return repository.save(newRoboticCat);
    }

    @GetMapping("/RoboticCat/{id}")
    RoboticCat one(@PathVariable Long id){

        return repository.findById(id)
            .orElseThrow(() -> new VirtualPetNotFoundException(id));
    }

    @PutMapping("/RoboticCat/{id}")
    RoboticCat replaceRoboticCat(@RequestBody RoboticCat newRoboticCat, 
    @PathVariable Long id){

        return repository.findById(id)
            .map(roboticcat -> {
                roboticcat.setName(newRoboticCat.getName());
                roboticcat.setDescription(newRoboticCat.getDescription());
                return repository.save(roboticcat);
        })
        .orElseGet(() -> {
            newRoboticCat.setId(id);
            return repository.save(newRoboticCat);
        });
    }

    @DeleteMapping("/RoboticCat/{id}")
    void deleteRoboticCat(@PathVariable Long id){
        repository.deleteById(id);
    }

   
}
