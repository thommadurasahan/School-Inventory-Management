package com.beginners.sim.order.model;

import com.beginners.sim.inventory.model.Supplier;
import com.beginners.sim.inventory.model.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ordered_on")
    private Date orderedOn;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany
    @JoinTable(
            name = "ordered_type",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<Type> Types = new HashSet<>();
}