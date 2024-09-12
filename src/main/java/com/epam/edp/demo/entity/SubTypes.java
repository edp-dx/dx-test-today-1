package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "SubTypes")
public class SubTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MainTypes mainType;

    // Getters and Setters
}
