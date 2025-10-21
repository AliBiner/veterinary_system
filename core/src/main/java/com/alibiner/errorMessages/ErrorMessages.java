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
        public static final String POSITIVE_OR_ZERO = "must be positive or zero";

    }

    public static class NotFoundMessages {
        public static final String APPOINTMENT_NOT_FOUND = "appointment not found";
        public static final String VACCINE_NOT_FOUND = "vaccine not found";
        public static final String EXAMINATION_NOT_FOUND = "examination not found";
    }

    public static class AlreadyExistMessages {
        public static final String VACCINE = "vaccine already exists";
    }

    public static class NotAvailableMessages {
        public static final String EXAMINATION = "examination can not save. because vaccine cycle not available for " +
                "this animal";
        public static final String APPOINTMENT_CAN_NOT_PAST = "appointment date can not be past";
        public static final String APPOINTMENT_CANCELLED = "appointment is cancelled";
        public static final String VACCINE_NOT_ACTIVE = "vaccine is not active";
    }
}
