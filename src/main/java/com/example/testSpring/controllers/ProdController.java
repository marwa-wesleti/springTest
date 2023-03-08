package com.example.testSpring.controllers;

import com.example.testSpring.models.Produit;
import com.example.testSpring.services.ProdService.ProdClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Produit")
public class ProdController {
    @Autowired
    ProdClassService prodService;

    @GetMapping("/getAll")
    ResponseEntity<?> getAllProd(){
        return prodService.getAll();
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<?> getByIdProd(@PathVariable("id") Long id){return prodService.getById(id);}

    @PostMapping("/add")
    ResponseEntity<?> addProd(@RequestBody Produit produit){return prodService.add(produit);}

    @PatchMapping("update/{id}")
    ResponseEntity<?> updateProd(@RequestBody Produit produit,@PathVariable("id") Long id){return prodService.update(produit,id);}

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deleteProd(@PathVariable("id") Long id){
        return prodService.delete(id);
    }
}
