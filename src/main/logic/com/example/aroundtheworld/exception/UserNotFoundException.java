package com.example.aroundtheworld.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("\nLogin Error:\n User not found.");
    }
}
