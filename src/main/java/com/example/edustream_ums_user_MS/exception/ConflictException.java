package com.example.edustream_ums_user_MS.exception;

public class ConflictException extends UserApplicationException {
    public ConflictException(String message) {
        super(message, 409);
    }
}
