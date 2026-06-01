package com.example.edustream_ums_user_MS.exception;


public class NotFoundException extends UserApplicationException {
    public NotFoundException(String message) {
        super(message, 404);
    }
}
