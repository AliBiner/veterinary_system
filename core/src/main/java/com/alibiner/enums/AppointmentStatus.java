package com.alibiner.enums;


public enum AppointmentStatus {
    RESERVED(10),
    COMPLETED(20),
    CANCELED(30);

    private int code;

    AppointmentStatus(int code) {
        this.code = code;
    }

    public static AppointmentStatus getValue(int code) {
        switch (code) {
            case 10 -> {
                return RESERVED;
            }
            case 20 -> {
                return COMPLETED;
            }
            case 30 -> {
                return CANCELED;
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
