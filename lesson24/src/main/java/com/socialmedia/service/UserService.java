package com.socialmedia.service;

import com.socialmedia.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authentication(String login, String password) {
        return isExists(login, password);
    }

    public boolean registration(String login, String password) {

        if (findUserByLogin(login)) {
            return false;
        } else {
            registerUser(login, password);
            return true;
        }
    }

    public boolean isExists(String login, String password) {
        return userRepository.isUserExists(login, password);
    }

    public boolean findUserByLogin(String login) {
        return userRepository.isUserExists(login);
    }

    public boolean registerUser(String login, String password) {
        return userRepository.insertUser(login, password);
    }

}
