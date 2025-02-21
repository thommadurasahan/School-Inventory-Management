package com.begginers.sim.inventory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte typeId;
    private String typeName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date typeAddedOn;

    @OneToMany(mappedBy = "type")
    private List<Item> items;
}
