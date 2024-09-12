package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "SupplierUsers")
public class SupplierUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID supplierId;
    private String email;

    // Getters and Setters
}
