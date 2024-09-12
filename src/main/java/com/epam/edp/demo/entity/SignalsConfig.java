package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "SignalsConfig")
public class SignalsConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private SignalType signalType;

    private int daysPriorToDeadline;
    private String timeOfTheDay;
    private int numberOfRetries;
    private int retryInterval;

    // Getters and Setters
}
