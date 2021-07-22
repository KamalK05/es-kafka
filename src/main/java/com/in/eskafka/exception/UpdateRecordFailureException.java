package com.in.eskafka.exception;

public class UpdateRecordFailureException extends RuntimeException {
    public UpdateRecordFailureException() {
        super("Error while updating data into DB");
    }

}
