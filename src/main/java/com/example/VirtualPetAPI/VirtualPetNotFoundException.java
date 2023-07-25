package com.example.VirtualPetAPI;

public class VirtualPetNotFoundException extends RuntimeException{

    public VirtualPetNotFoundException(Long id){
        super("Could not find pet with id: " + id);
    }
    
}
