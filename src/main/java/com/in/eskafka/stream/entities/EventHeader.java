package com.in.eskafka.stream.entities;

public class EventHeader {
    private String version;
    private Long timestamp;

    public String getVersion() {
        return version;
    }

    public EventHeader setVersion(String version) {
        this.version = version;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "EventHeader{" +
            "version='" + version + '\'' +
            ", timestamp=" + timestamp +
            '}';
    }
}