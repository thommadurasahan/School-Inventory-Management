package com.beginners.sim.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "voucher_no")
    private String voucherNo;

    @Column(name = "quantity")
    private long quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "received_on")
    private Date receivedOn;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}