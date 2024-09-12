package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "CategoryManagers")
public class CategoryManagers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String email;
    private String assortmentCategory;

    // Getters and Setters
}
