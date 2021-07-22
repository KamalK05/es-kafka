package com.in.eskafka.stream.entities;

import java.io.Serializable;

public class OrganizationEvent implements Serializable {
    private long uniqueId;
    private String name;
    private int type;
    private String establishedDate;
    private int status;
    private boolean isDeleted;

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = establishedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "OrganizationEvent{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", establishedDate='" + establishedDate + '\'' +
                ", status='" + status + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
