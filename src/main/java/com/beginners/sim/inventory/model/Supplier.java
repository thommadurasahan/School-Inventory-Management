package com.beginners.sim.inventory.model;

import com.beginners.sim.order.model.Order;
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
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierId;
    private String supplierName;
    private String supplierAddress;
    private int supplierContactNo;
    @Temporal(TemporalType.DATE)
    private Date supplierAddedOn;

    @OneToMany(mappedBy = "supplier")
    private List<Item> items;

    @OneToMany(mappedBy = "supplier")
    private List<Order> orders;

    @ManyToMany(mappedBy = "supplier")
    private Set<Type> types = new HashSet<>();
}
