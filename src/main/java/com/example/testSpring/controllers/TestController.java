package com.example.testSpring.controllers;

import com.example.testSpring.models.Test;
import com.example.testSpring.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;


@RestController // restfull
@RequestMapping("Test")
public class TestController {
   @Autowired // bch yorbet variable heka bel class hedhi dependency injection
    TestService testService;
   @PostMapping //  bch t9olou ili methode hedhi post
   ResponseEntity<?> ajouterTests (@RequestBody Test test){
       return  testService.create(test);
   }
   @GetMapping
    ResponseEntity<?> afficher(){
       return testService.getAll();
   }
   @GetMapping("/findById/{id}")
    ResponseEntity<?> afficherById(@PathVariable("id") Long id){
       return testService.getById(id);
   }



}
