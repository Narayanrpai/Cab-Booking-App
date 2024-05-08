package com.example.cabBookingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private String driverName;
    private char gender;
    private int age;
    private String vehicleDetails;
    private int[] currentLocation;
    private boolean available;
}
