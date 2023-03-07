package com.example.testSpring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor // constructeur feragh
@Data
@Entity //yaaml taable fel base ismha aala ism class wala ken nheb nbadel ism nhotou entre parenthése
public class Test {
    @Id // hat champ id comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;
    private String name;
    private boolean active;
    private int age;


}
