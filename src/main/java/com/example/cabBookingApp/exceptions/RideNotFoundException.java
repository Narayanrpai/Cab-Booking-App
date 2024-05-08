package com.example.cabBookingApp.exceptions;


public class RideNotFoundException extends Throwable {
    public RideNotFoundException(String message) {
        super(message);
    }
}
