package com.example.t2305m_springboot.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;
    private Double salary;

    // Getters and Setters
    // (Generated using IDE or Lombok for brevity)
}