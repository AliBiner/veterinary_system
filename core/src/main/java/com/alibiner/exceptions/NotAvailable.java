package com.alibiner.exceptions;


public class NotAvailable extends RuntimeException {
    public static final String DOCTOR = "Doctor not available";

    public NotAvailable(String message) {
        super(message);
    }
}
