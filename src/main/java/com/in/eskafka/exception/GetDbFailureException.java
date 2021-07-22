package com.in.eskafka.exception;

public class GetDbFailureException extends RuntimeException {
    public GetDbFailureException() {
        super("Error while getting data into DB");
    }

}
