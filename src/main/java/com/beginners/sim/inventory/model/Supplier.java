package com.beginners.sim.inventory.model;

import com.beginners.sim.order.model.Order;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private long supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_address")
    private String supplierAddress;

    @Column(name = "supplier_contact_no")
    private int supplierContactNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "supplier_added_on")
    private Date supplierAddedOn;

    // Item (M) - Supplier (1) Relationship (Opposite Side)
    @OneToMany(mappedBy = "supplier")
    private List<Item> items;

    // Type (M) - Supplier (M) Relationship (Opposite Side)
    @ManyToMany(mappedBy = "suppliers")
    private Set<Type> types = new HashSet<>();

    // Order (M) - Supplier (1) Relationship (Opposite Side)
    @OneToMany(mappedBy = "supplier")
    private List<Order> orders;
}
