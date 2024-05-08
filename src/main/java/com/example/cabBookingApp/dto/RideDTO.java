package com.example.cabBookingApp.dto;

import com.example.cabBookingApp.models.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDTO {

    private String driver;
    private int[] source;
    private int[] destination;

}
