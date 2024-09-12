package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ErrorMessages1", indexes = {
        @Index(columnList = "errorCode", unique = true)
})
public class ErrorMessages1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "errorCode")
    private Errors error;

    private String english;
    private String dutch;

    // Getters and Setters
}
