package com.example.cabBookingApp;

import com.example.cabBookingApp.dto.DriverDTO;
import com.example.cabBookingApp.dto.RideDTO;
import com.example.cabBookingApp.dto.UserDTO;
import com.example.cabBookingApp.exceptions.RideNotFoundException;
import com.example.cabBookingApp.models.Driver;
import com.example.cabBookingApp.models.Ride;
import com.example.cabBookingApp.models.User;
import com.example.cabBookingApp.repository.RideRepository;
import com.example.cabBookingApp.repository.UserRepository;
import com.example.cabBookingApp.services.RideService;
import com.example.cabBookingApp.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CabBookingAppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CabBookingAppApplication.class, args);
		//Scanner scanner = new Scanner(System.in);
		UserService userService = new UserService(new UserRepository());
		RideService rideService = new RideService(new RideRepository());

		// Take input from user using the console
		/*
		while(true) {
			String input = scanner.nextLine();
			input = input.trim();
			String[] inputArray = input.split(" ");
			try {
				switch (inputArray[0]) {
					case "add_user": {
						userService.addUser(new UserDTO(
								inputArray[1], inputArray[2].charAt(0),
								Integer.parseInt(inputArray[3])));
					}
					break;
					case "add_driver": {
						rideService.addDriver(new DriverDTO(
								inputArray[1], inputArray[2].charAt(0),
								Integer.parseInt(inputArray[3]), inputArray[4],
								new int[]{Integer.parseInt(inputArray[5]), Integer.parseInt(inputArray[6])}, true)
						);
					}
					break;
					case "find_ride": {
						List<Ride> rides = rideService.findRide(inputArray[1],
								new int[]{Integer.parseInt(inputArray[2]), Integer.parseInt(inputArray[3])},
								new int[]{Integer.parseInt(inputArray[4]), Integer.parseInt(inputArray[5])}
						);
						System.out.println(rides);
					}
					break;
					case "choose_ride": {
						rideService.chooseRide(
								inputArray[1], inputArray[2]);
					}
					break;
					default:
						System.out.println("Invalid Command");
				}
			}
			catch (RideNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		 */

		try {
			userService.addUser(new UserDTO("Abhishek", 'M',23));
			userService.addUser(new UserDTO("Rahul", 'M',29));
			userService.addUser(new UserDTO("Nandini", 'F',22));
		} catch (Exception e) {
			System.out.println("Error occurred while registering users " + e.getMessage());
		}

		try {
			rideService.addDriver(new DriverDTO("Driver1", 'M', 22, "Swift, KA-01-12345",new int[]{10, 1},true));
			rideService.addDriver(new DriverDTO("Driver2", 'M', 29, "Swift, KA-01-12345",new int[]{11, 10},true));
			rideService.addDriver(new DriverDTO("Driver3", 'M', 24, "Swift, KA-01-12345",new int[]{5, 3},true));
		} catch (Exception e) {
			System.out.println("Error occurred while onboarding driver partners " + e.getMessage());
		}

		//Test cases
		List<Ride> ride;
		try{
			ride = rideService.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1});
			System.out.println(ride);
		}
		catch (RideNotFoundException e) {
			System.out.println(e);
		}

		try{
			ride = rideService.findRide("Rahul", new int[]{10, 0}, new int[]{15, 3});
			System.out.println(ride);
		}
		catch (RideNotFoundException e) {
			System.out.println(e);
		}

		try{
			rideService.chooseRide("Abhishek", "Driver1");
			System.out.println("Ride booked successfully!");
		}
		catch (RideNotFoundException e) {
			System.out.println(e);
		}

		try{
			ride = rideService.findRide("Nandini", new int[]{15, 6}, new int[]{20, 4});
			System.out.println(ride);
		}
		catch (RideNotFoundException e) {
			System.out.println(e);
		}
	}
}
