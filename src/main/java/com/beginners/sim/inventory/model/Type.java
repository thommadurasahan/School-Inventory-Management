package com.beginners.sim.inventory.model;

import com.beginners.sim.order.model.Order;
import com.beginners.sim.repair.model.Repair;
import com.beginners.sim.survey.model.Survey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private long typeId;

    @Column(name = "type_name")
    private String typeName;

    @Temporal(TemporalType.DATE)
    @Column(name = "type_added_on")
    private Date typeAddedOn;

    // Item (M) - Type (1) Relationship
    @OneToMany(mappedBy = "type")
    private List<Item> items;

    // Type (M) - Supplier (M) Relationship (Owner Side)
    @ManyToMany
    @JoinTable(
            name = "supply",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers = new HashSet<>();

    // Order (M) - Type (M) Relationship (Opposite Side)
    @ManyToMany(mappedBy = "types")
    private Set<Order> orders = new HashSet<>();

    // Repair (M) - Type (M) Relationship (Opposite Side)
    @ManyToMany(mappedBy = "types")
    private Set<Repair> repairs = new HashSet<>();

    // Survey (1) - Type (1) Relationship (Opposite Side)
    @OneToOne(mappedBy = "type")
    private Survey survey;
}