package com.begginers.sim.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short supplyId;
    private byte typeId;
    private byte supplierId;
}
