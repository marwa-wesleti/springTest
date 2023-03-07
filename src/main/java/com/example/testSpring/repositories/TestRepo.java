package com.example.testSpring.repositories;

import com.example.testSpring.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test,Long> {

}
