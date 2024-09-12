package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ErrorMessages2")
public class ErrorMessages2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "errorCode")
    private Errors error;

    @ManyToOne
    @JoinColumn(name = "languageId")
    private ErrorLanguages2 language;

    private String text;

    // Getters and Setters
}
