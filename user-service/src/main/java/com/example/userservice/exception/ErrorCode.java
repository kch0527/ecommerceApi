package com.example.userservice.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    DUPLICATED_EMAIL(HttpStatus.CONFLICT, "이미 사용중인 이메일입니다.");

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    private final HttpStatus status;
    private final String message;
}
