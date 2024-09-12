package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID supplierId;
    private String assortmentGroup;
    private String shortDescription;

    // Getters and Setters
}
