package com.in.eskafka.stream.entities;

import java.io.Serializable;

public class AbstractKafkaEvent<T> implements Serializable {

    private EventHeader header;
    private T data;

    public AbstractKafkaEvent() {
        super();
    }

    public EventHeader getHeader() {
        return header;
    }

    public void setHeader(EventHeader header) {
        this.header = header;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AbstractEventMessage{" +
            "header=" + header +
            ", data=" + data +
            '}';
    }
}
