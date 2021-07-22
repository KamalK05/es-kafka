package com.in.eskafka.exception;

public class AddDbFailureException extends RuntimeException {
    public AddDbFailureException() {
        super("Error while adding data into DB");
    }

}
