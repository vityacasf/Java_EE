package com.socialMedia.service;

import com.socialMedia.model.User;
import com.socialMedia.repository.UserRepository;

import java.util.List;

public class OutputService {
    private final UserRepository userRepository;

    public OutputService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(String queryParameter) {
        if (queryParameter != null) {
            return userRepository.getAllUsers(queryParameter);
        } else {
            return userRepository.getAllUsers();
        }
    }

}
