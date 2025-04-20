package com.beginners.sim.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDTO {

    private long typeId;
    private String typeName;
    private Date typeAddedOn;
}
