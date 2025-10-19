package com.alibiner.exceptions;


public class UserNotDoctor extends RuntimeException {
    public UserNotDoctor() {
        super("user not a doctor");
    }
}
