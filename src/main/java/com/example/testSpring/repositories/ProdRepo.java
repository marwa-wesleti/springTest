package com.example.testSpring.repositories;

import com.example.testSpring.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRepo extends JpaRepository<Produit,Long> {
}
