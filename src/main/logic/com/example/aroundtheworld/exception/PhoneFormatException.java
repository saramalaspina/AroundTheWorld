package com.example.aroundtheworld.exception;

public class PhoneFormatException extends Exception{
    public PhoneFormatException(String phone) {
        super("'" + phone +"' phone number not valid, please insert a new phone number");
    }
}
