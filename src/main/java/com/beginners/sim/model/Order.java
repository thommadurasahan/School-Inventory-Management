package com.beginners.sim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchase")
// Table name of this Entity cannot be same as the class name because order is a reserved keyword in SQL (MySQL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.DATE)
    @Column(name = "ordered_on")
    private Date orderedOn;

    // Order (M) - Type (M) Relationship
    @ManyToMany
    @JoinTable(
            name = "ordered_type",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    @JsonIgnore
    private Set<Type> types = new HashSet<>();

    // Order (M) - Supplier (1) Relationship
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}