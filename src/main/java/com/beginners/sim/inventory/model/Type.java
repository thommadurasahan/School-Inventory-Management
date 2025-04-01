package com.beginners.sim.inventory.model;

import com.beginners.sim.order.model.Order;
import com.beginners.sim.survey.model.Survey;
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
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private long typeId;

    @Column(name = "type_name")
    private String typeName;

    @Temporal(TemporalType.TIMESTAMP)
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
    @ManyToMany(mappedBy = "type")
    private Set<Order> orders = new HashSet<>();

    @OneToOne(mappedBy = "type")
    private Survey survey;
}