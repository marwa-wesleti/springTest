package com.example.testSpring.services.ProdService;

import com.example.testSpring.models.Produit;
import org.springframework.http.ResponseEntity;

public interface ProdInterface {

    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> add(Produit produit);
    ResponseEntity<?> update(Produit produit, Long id);
    ResponseEntity<?> delete(Long id);
}
