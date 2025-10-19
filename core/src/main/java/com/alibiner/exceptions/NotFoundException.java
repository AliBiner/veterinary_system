package com.alibiner.exceptions;

public class NotFoundException extends RuntimeException {
    public static final String HAVE_NOT_OWN = "The animal have not an owner";
    public NotFoundException(String message) {
        super(message);
    }
}
