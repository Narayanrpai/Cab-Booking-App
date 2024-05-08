package com.example.cabBookingApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    private String driverName;
    private int[] source;
    private int[] destination;
}
