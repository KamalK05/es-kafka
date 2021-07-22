package com.in.eskafka.exception;

public class GetRecordFailureException extends RuntimeException {
    public GetRecordFailureException() {
        super("No data exist with given organization id");
    }
}
