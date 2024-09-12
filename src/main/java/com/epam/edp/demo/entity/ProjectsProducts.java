package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "Projects_Products", indexes = {
        @Index(columnList = "projectId, productId", unique = true)
})
public class ProjectsProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Projects project;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private Timestamp updatedOn;

    // Getters and Setters
}
