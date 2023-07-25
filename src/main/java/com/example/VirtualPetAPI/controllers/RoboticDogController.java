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
import com.example.VirtualPetAPI.models.RoboticDog;
import com.example.VirtualPetAPI.repositories.RoboticDogRepository;

@RestController
public class RoboticDogController {
    private final RoboticDogRepository repository;

    RoboticDogController(RoboticDogRepository repository){
        this.repository = repository;
    }

    @GetMapping("/RoboticDog")
    List<RoboticDog> all(){
        return repository.findAll();
    }

    @PostMapping("/RoboticDog")
    RoboticDog newRoboticDog(@RequestBody RoboticDog newRoboticDog){
        return repository.save(newRoboticDog);
    }

    @GetMapping("/RoboticDog/{id}")
    RoboticDog one(@PathVariable Long id){

        return repository.findById(id)
            .orElseThrow(() -> new VirtualPetNotFoundException(id));
    }

    @PutMapping("/RoboticDog/{id}")
    RoboticDog replaceRoboticDog(@RequestBody RoboticDog newRoboticDog, 
    @PathVariable Long id){

        return repository.findById(id)
            .map(roboticdog -> {
                roboticdog.setName(newRoboticDog.getName());
                roboticdog.setDescription(newRoboticDog.getDescription());
                return repository.save(roboticdog);
        })
        .orElseGet(() -> {
            newRoboticDog.setId(id);
            return repository.save(newRoboticDog);
        });
    }

    @DeleteMapping("/RoboticDog/{id}")
    void deleteRoboticDog(@PathVariable Long id){
        repository.deleteById(id);
    }

}
