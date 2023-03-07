package com.example.testSpring.services;

import com.example.testSpring.models.Test;
import org.springframework.http.ResponseEntity;

public interface TestServ {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> create(Test test);
    ResponseEntity<?> update(Test test,Long id);
    ResponseEntity<?> delete(Long id);


}
