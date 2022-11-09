package com.socialMedia.service;

import java.util.List;

import com.socialMedia.model.User;
import com.socialMedia.repository.UserRepository;

public class UserService {


    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authentication(String username, String password) {
        return isExists(username, password);
    }

    public boolean registration(String username, String password) {

        if (findUserByName(username)) {
            return true;
        } else {
            registerUser(username, password);
            return false;
        }
    }

    public boolean isExists(String username, String password) {
        return userRepository.isUserExists(username, password);
    }

    public boolean findUserByName(String username) {
        return userRepository.findUserByName(username);
    }

    public boolean registerUser(String username, String password) {
        return userRepository.insertNewUser(username, password);
    }

}
