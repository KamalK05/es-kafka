package com.in.eskafka.exception;

public class EsWriteException extends RuntimeException {
    public EsWriteException() {
        super("Error while adding data into elastic search");
    }

}
