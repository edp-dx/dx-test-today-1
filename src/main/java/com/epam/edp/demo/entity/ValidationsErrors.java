package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "ValidationsErrors", indexes = {
        @Index(columnList = "projectCode, supplierId, productId, errorCode", unique = true)
})
public class ValidationsErrors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "projectCode")
    private Projects project;

    private UUID supplierId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;

    @ManyToOne
    @JoinColumn(name = "errorCode")
    private Errors error;

    private String initialErrorMessage;
    private Timestamp createdOn;
    private Timestamp solvedOn;

    // Getters and Setters
}
