package com.example.cabBookingApp.services;

import com.example.cabBookingApp.dto.UserDTO;
import com.example.cabBookingApp.models.User;
import com.example.cabBookingApp.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserName(), userDTO.getGender(),userDTO.getAge());
    }
}
