package com.example.cabBookingApp.models;

import ch.qos.logback.core.joran.sanity.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    private String driverName;
    private char gender;
    private int age;
    private String vehicleDetails;
    private int[] location;
    private boolean available;
}
