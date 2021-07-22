package com.in.eskafka.exception;

public class EsReadException extends RuntimeException {
    public EsReadException() {
        super("Error while reading data from elastic search");
    }

}
