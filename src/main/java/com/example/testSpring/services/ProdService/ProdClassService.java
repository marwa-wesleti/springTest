package com.example.testSpring.services.ProdService;

import com.example.testSpring.models.Produit;
import com.example.testSpring.repositories.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdClassService implements ProdInterface{
    @Autowired
    private ProdRepo prodRepo;
    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(prodRepo.findAll());
    }


    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Produit> produit=prodRepo.findById(id);
        if(produit.isPresent())
            return ResponseEntity.ok(produit.get());
        else
            return ResponseEntity.ok("product dosn't exist");
    }

    @Override
    public ResponseEntity<?> add(Produit produit) {
       return ResponseEntity.ok(prodRepo.save(produit));
    }

    @Override
    public ResponseEntity update(Produit updateProduit, Long id) {
        Optional<Produit> produit=prodRepo.findById(id);
        if(produit.isPresent()){
            Produit updated =produit.get();
            updated.setNomProd(updateProduit.getNomProd());
            updated.setPrix(updateProduit.getPrix());
            updated.setStock(updateProduit.getStock());
            updated.setExist(updateProduit.isExist());
            prodRepo.save(updated);
            return ResponseEntity.ok(updated);
        }
        else
            return ResponseEntity.ok("product dosn't exist");

    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Optional<Produit> produit=prodRepo.findById(id);
        if(produit.isPresent()) {
            Produit deletedProd=produit.get();
            prodRepo.delete(deletedProd);
            return ResponseEntity.ok("Product deleted");
        }

        else
            return ResponseEntity.ok("Product dosn't exist");
    }
}
