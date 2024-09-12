package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ErrorMessages3", indexes = {
        @Index(columnList = "errorCode", unique = true)
})
public class ErrorMessages3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "errorCode")
    private Errors error;

    @Enumerated(EnumType.STRING)
    private ErrorMessages3Language language;

    private String text;

    // Getters and Setters
}
