package com.beginners.sim.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

    private long supplierId;
    private String supplierName;
    private String supplierAddress;
    private int supplierContactNo;
    private Date supplierAddedOn;
}
