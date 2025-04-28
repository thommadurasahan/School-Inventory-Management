package com.beginners.sim.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Temporal(TemporalType.DATE)
    @Column(name = "received_on")
    private Date receivedOn;

    // Item (M) - Type (1) Relationship (Owner Side)
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    // Item (M) - Supplier (1) Relationship (Owner Side)
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}