package com.example.VirtualPetAPI;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VirtualPetNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(VirtualPetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String virtualPetNotFoundHandler(VirtualPetNotFoundException ex){
        return ex.getMessage();
    }
    
}
