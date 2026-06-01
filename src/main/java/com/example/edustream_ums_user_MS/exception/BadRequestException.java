package com.example.edustream_ums_user_MS.exception;

public class BadRequestException extends UserApplicationException {
    public BadRequestException(String message) {
        super(message, 400);
    }
}
