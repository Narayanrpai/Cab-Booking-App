package com.example.cabBookingApp.services;

import com.example.cabBookingApp.dto.DriverDTO;
import com.example.cabBookingApp.exceptions.RideNotFoundException;
import com.example.cabBookingApp.models.Driver;
import com.example.cabBookingApp.models.Ride;
import com.example.cabBookingApp.repository.RideRepository;

import java.util.*;

public class RideService {
    private RideRepository rideRepository;
    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }
    public void addDriver(DriverDTO driverDTO) {
        Driver driver = new Driver(driverDTO.getDriverName(), driverDTO.getGender(), driverDTO.getAge(),
                driverDTO.getVehicleDetails(), driverDTO.getCurrentLocation(), true
                );
        rideRepository.addRide(new Ride(driver.getDriverName(), driver.getLocation(),null), driver);
    }

    public List<Ride> findRide(String username, int[] source, int[] destination) throws RideNotFoundException {
        List<Ride> availableRides = new ArrayList<>();
        for(Ride ride : rideRepository.getRides()) {
            String driverName = ride.getDriverName();
            Driver driver = rideRepository.getDriver(driverName);
            if(driver.isAvailable() && isWithinRange(driver.getLocation(), source)) {
                availableRides.add(ride);
            }
        }
        if(availableRides.isEmpty()) {
            throw new RideNotFoundException("No ride found");
        }
        return availableRides;
    }

    public Ride chooseRide(String username, String driverName) throws RideNotFoundException {
        for(Ride ride : rideRepository.getRides()) {
            Driver driver = rideRepository.getDriver(driverName);
            if (driver.getDriverName().equals(driverName) && driver.isAvailable()) {
                driver.setAvailable(false);
                return ride;
            }
        }
        throw new RideNotFoundException("Ride with driver " + driverName + " not available");
    }

    private boolean isWithinRange(int[] driverLocation, int[] source) {
        //distance between two points
        int x1 = driverLocation[0], y1 = driverLocation[1];
        int x2 = source[0], y2 = source[1];
        double distance = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        return distance < 5;
    }
}
