package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "Projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    private String fileName;

    @Enumerated(EnumType.STRING)
    private ProjectMainType mainType;

    @Enumerated(EnumType.STRING)
    private ProjectSubType subType;

    private String assortmentCategory;
    private Timestamp createdOn;
    private Timestamp deadline;
    private Timestamp inEffectFrom;

    // Getters and Setters
}
