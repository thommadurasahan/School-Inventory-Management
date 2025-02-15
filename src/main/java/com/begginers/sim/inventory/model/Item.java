package com.begginers.sim.inventory.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Item {

    private short itemId;
    private byte typeId;
    private String voucherNo;
    private short quantity;
    private byte supplierId;
    private Date insertedDate;
    private String insertedBy;
}
