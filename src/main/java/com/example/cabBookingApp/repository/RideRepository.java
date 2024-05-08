package com.example.cabBookingApp.repository;

import com.example.cabBookingApp.dto.RideDTO;
import com.example.cabBookingApp.models.Driver;
import com.example.cabBookingApp.models.Ride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    private List<Ride> rides = new ArrayList<>();
    public Map<String, Driver> riderMap = new HashMap<String, Driver>();
    public void addRide(Ride ride, Driver driver) {
        rides.add(ride);
        riderMap.put(driver.getDriverName(), driver);
    }
    public List<Ride> getRides() {
        return rides;
    }
    public Driver getDriver(String driverName) {
        return riderMap.get(driverName);
    }
}






