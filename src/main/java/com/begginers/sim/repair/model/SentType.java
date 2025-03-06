package com.begginers.sim.repair.model;

public class SentType {
    private int sentTypeId;
    private String typeName;

    // Constructors
    public SentType() {}

    public SentType(int sentTypeId, String typeName) {
        this.sentTypeId = sentTypeId;
        this.typeName = typeName;
    }

    // Getters and Setters
    public int getSentTypeId() { return sentTypeId; }
    public void setSentTypeId(int sentTypeId) { this.sentTypeId = sentTypeId; }

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
}
