package com.alibiner.veterinary_management_system.result;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class Result<T> {
    private int status;
    private String message;
    private T data;

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "Success", data);
    }

    public static <T> Result<Page<T>> ok(Page<T> data) {
        return new Result<>(200, "Success", data);
    }

    public static Result<Void> ok() {
        return new Result<>(200, "Success", null);
    }


    public static <T> Result<T> validation(T errors) {
        return new Result<>(400, "Validation Error", errors);
    }

    public static Result<Void> unexcepted() {
        return new Result<>(500, "Unexcepted Error", null);
    }

    public static Result<Void> badRequest(String message) {
        return new Result<>(400, message, null);
    }

    public static Result<Void> conflict(String message) {
        return new Result<>(409, message, null);
    }
}
