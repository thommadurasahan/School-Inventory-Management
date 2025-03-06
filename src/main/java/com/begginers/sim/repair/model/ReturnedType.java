package com.begginers.sim.repair.model;

public class ReturnedType {
    private int returnedTypeId;
    private int returnId;
    private String typeName;

    // Constructors
    public ReturnedType() {}

    public ReturnedType(int returnedTypeId, int returnId, String typeName) {
        this.returnedTypeId = returnedTypeId;
        this.returnId = returnId;
        this.typeName = typeName;
    }

    // Getters and Setters
    public int getReturnedTypeId() { return returnedTypeId; }
    public void setReturnedTypeId(int returnedTypeId) { this.returnedTypeId = returnedTypeId; }

    public int getReturnId() { return returnId; }
    public void setReturnId(int returnId) { this.returnId = returnId; }

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
}
