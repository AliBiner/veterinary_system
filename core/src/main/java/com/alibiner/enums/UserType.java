package com.alibiner.enums;


public enum UserType {
    CUSTOMER(10),
    DOCTOR(20);

    private int code;

    UserType(int code) {
        this.code = code;
    }

    public static UserType getValue(int code) {
        switch (code) {
            case 10 -> {
                return CUSTOMER;
            }
            case 20 -> {
                return DOCTOR;
            }
            default -> {
                return null;
            }
        }
    }

    public int getCode() {
        return code;
    }
}
