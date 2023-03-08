package com.example.testSpring.services;

import com.example.testSpring.models.Test;
import com.example.testSpring.repositories.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService implements TestServ{
  @Autowired
    private TestRepo testRepo;
    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(testRepo.findAll());
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Test> test=testRepo.findById(id);
        if(test.isPresent())
            return ResponseEntity.ok(test.get());

        else
            return ResponseEntity.ok("test not exist");

    }

    @Override
    public ResponseEntity<?> create(Test test) {
        return ResponseEntity.ok(testRepo.save(test));
    }

    @Override
    public ResponseEntity<?> update(Test Uptest, Long id) {
        Optional<Test> test=testRepo.findById(id);
        if(test.isPresent()) {
            Test updatedTest=test.get();
            updatedTest.setActive(Uptest.isActive());
            testRepo.save(updatedTest);
            return ResponseEntity.ok(updatedTest);
        }
        else
            return ResponseEntity.ok("test not exist");

    }

    @Override
    public ResponseEntity<?> delete(Long id) {
       Optional<Test> test=testRepo.findById(id);
       if(test.isPresent()){
           testRepo.deleteById(id);
           return ResponseEntity.ok("test deleted");
       }
       else
           return ResponseEntity.ok("test not exist");


    }
}
