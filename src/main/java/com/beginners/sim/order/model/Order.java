package com.beginners.sim.order.model;

import com.beginners.sim.inventory.model.Supplier;
import com.beginners.sim.inventory.model.Type;
import com.beginners.sim.survey.model.Survey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order")
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ordered_on")
    private Date orderedOn;

    // Order (M) - Type (M) Relationship (Owner Side)
    @ManyToMany
    @JoinTable(
            name = "ordered_type",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<Type> types = new HashSet<>();

    // Order (M) - Supplier (1) Relationship (Owner SIde)
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // Survey (1) - Order (1) Relationship (Opposite Side)
    @OneToOne(mappedBy = "order")
    private Survey survey;
}