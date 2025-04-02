package com.beginners.sim.repair.model;

import com.beginners.sim.inventory.model.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "repair")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_id")
    private int repairId;

    @Column(name = "sent_quantity")
    private int sentQuantity;

    @Column(name = "sent_to_repair_on")
    private Date sentToRepairOn;

    @Column(name = "repair_location")
    private String repairLocation;

    // Repair (M) - Type (M) Relationship (Owner Side)
    @ManyToMany
    @JoinTable(
            name = "sent_type",
            joinColumns = @JoinColumn(name = "repair_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<Type> types = new HashSet<>();
}