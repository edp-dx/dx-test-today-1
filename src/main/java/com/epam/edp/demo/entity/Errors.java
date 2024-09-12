package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Errors")
public class Errors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    private String initialErrorMessage;
    private String enrichedErrorMessageEnglish;
    private String enrichedErrorMessageDutch;
    private String attribute;

    @Enumerated(EnumType.STRING)
    private ErrorReceiverType receiverType;

    // Getters and Setters
}
