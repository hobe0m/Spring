package org.choongang.commons;

import org.springframework.http.HttpStatus;

public class BadRequestException extends org.choongang.commons.CommonException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
