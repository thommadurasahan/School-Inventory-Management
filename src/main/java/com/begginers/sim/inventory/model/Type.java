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
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class TypeNotFoundException


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long typeId;
    private String typeName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date typeAddedOn;

    @OneToMany(mappedBy = "type")
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;
}