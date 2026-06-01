package com.example.edustream_ums_user_MS.exception;

public class UserServiceException extends UserApplicationException {
    public UserServiceException(String message, int statusCode) {
        super(message, statusCode);
    }

    public UserServiceException(String message, int statusCode, String downStreamMessage) {
        super(message, statusCode, downStreamMessage);
    }
}
