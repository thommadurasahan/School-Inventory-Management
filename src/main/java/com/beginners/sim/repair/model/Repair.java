package com.beginners.sim.repair.model;

import com.beginners.sim.inventory.model.Type;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_id")
    private int repairId;

    @Column(name = "sent_quantity")
    private int sentQuantity;

    @Temporal(TemporalType.DATE)
    @Column(name = "sent_to_repair_on")
    private Date sentToRepairOn;

    @Column(name = "repair_location")
    private String repairLocation;

    @ManyToMany
    @JoinTable(
            name = "sent_type",
            joinColumns = @JoinColumn(name = "repair_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<Type> types = new HashSet<>();

    // Getters and Setters
    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public int getSentQuantity() {
        return sentQuantity;
    }

    public void setSentQuantity(int sentQuantity) {
        this.sentQuantity = sentQuantity;
    }

    public Date getSentToRepairOn() {
        return sentToRepairOn;
    }

    public void setSentToRepairOn(Date sentToRepairOn) {
        this.sentToRepairOn = sentToRepairOn;
    }

    public String getRepairLocation() {
        return repairLocation;
    }

    public void setRepairLocation(String repairLocation) {
        this.repairLocation = repairLocation;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }
}