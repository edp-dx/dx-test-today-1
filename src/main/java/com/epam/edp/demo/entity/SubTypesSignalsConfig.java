package com.epam.edp.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "SubTypes_SignalsConfig", indexes = {
        @Index(columnList = "subTypeId, signalsConfigId", unique = true)
})
public class SubTypesSignalsConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "subTypeId")
    private SubTypes subType;

    @ManyToOne
    @JoinColumn(name = "signalsConfigId")
    private SignalsConfig signalsConfig;

    // Getters and Setters
}
