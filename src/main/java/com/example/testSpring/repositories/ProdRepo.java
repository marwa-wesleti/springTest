package com.example.testSpring.repositories;

import com.example.testSpring.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdRepo extends JpaRepository<Produit,Long> {
    Optional<Produit> findProduitByNomProd(String nom);
    boolean existsByNomProd(String nom);
}
