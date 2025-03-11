package com.begginers.sim.inventory.model;

import com.begginers.sim.order.model.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "supply",
            joinColumns = @JoinColumn(name = "typeId"),
            inverseJoinColumns = @JoinColumn(name = "supplierId")
    )
    private Set<Supplier> suppliers = new HashSet<>();

    @ManyToMany(mappedBy = "types")
    private Set<Order> orders = new HashSet<>();
}