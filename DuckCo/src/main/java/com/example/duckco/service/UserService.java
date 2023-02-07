package com.example.duckco.service;

import com.example.duckco.model.AuthDetails;
import com.example.duckco.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public AuthDetails getUser(String username, String password) {
        return userRepository.getUser(username, password);
    }

}
