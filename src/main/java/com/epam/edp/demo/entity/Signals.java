package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "Signals")
public class Signals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "projectCode")
    private Projects project;

    private Timestamp deliveryTime;
    private boolean delivered;

    @Enumerated(EnumType.STRING)
    private SignalType type;

    private boolean invalid;

    // Getters and Setters
}
