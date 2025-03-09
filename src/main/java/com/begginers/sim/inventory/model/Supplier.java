package com.begginers.sim.inventory.model;

import com.begginers.sim.order.model.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Supplier {
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class SupplierNotFoundException

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    private String supplierName;
    private String supplierAddress;
    private int supplierContactNo;
    @Temporal(TemporalType.DATE)
    private Date supplierAddedOn;

    @OneToMany(mappedBy = "supplier")
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @OneToMany(mappedBy = "supplier")
    private List<Order> orders;
}
