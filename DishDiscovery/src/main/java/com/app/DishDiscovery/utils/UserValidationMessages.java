package com.app.DishDiscovery.utils;

public class UserValidationMessages {
    public static final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{8,}$";

    public static final String USERNAME_NOT_BLANK_MESSAGE = "Username is required!";

    public static final String USERNAME_SIZE_MESSAGE = "Username must be at least 8 characters long!";

    public static final String USERNAME_PATTERN_MESSAGE = "Username must include at least an uppercase letter and one digit!";

    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public static final String PASSWORD_NOT_BLANK_MESSAGE = "Password is required!";

    public static final String PASSWORD_SIZE_MESSAGE = "Password must be at least 8 characters long!";

    public static final String PASSWORD_PATTERN_MESSAGE = "Password must include at least an uppercase letter, one digit and one symbol!";

    public static final String CONFIRM_PASSWORD_NOT_BLANK_MESSAGE = "Confirm Password is required!";

    public static final String CONFIRM_PASSWORD_SIZE_MESSAGE = "Confirm Password must be at least 8 characters long!";

    public static final String FULL_NAME_NOT_BLANK_MESSAGE = "Full Name is required!";

    public static final String FULL_NAME_PATTERN = "^[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*$";

    public static final String FULL_NAME_PATTERN_MESSAGE = "Full Name must consist of three words separated by spaces, each starting with an uppercase letter";

    public static final String EMAIL_NOT_BLANK_MESSAGE = "Email is required!";

    public static final String EMAIL_PATTERN_MESSAGE = "Invalid email format!";
}
