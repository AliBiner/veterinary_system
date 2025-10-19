package com.alibiner.errorMessages;


public class ErrorMessages {

    public static class ValidationMessages {
        public static final String NOT_NULL = "can not be null";
        public static final String NOT_BLANK = "can not be blank";
        public static final String INVALID_EMAIL_FORMAT = "invalid email format";
        public static final String INVALID_PHONE_FORMAT = "must be 10 character";
        public static final String MIN_DATE_MUST_FUTURE = "min-date must be future or present";
        public static final String MAX_DATE_MUST_FUTURE = "max-date must be future or present";
        public static final String MIN_DATE_GREATER_MAX_DATE = "must be max-date greater than min-date";
        public static final String DATE_MUST_FUTURE = "date must be future or present";

    }
}
