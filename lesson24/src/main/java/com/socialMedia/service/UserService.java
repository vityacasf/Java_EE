package com.socialMedia.service;

import java.util.List;

import com.socialMedia.model.User;
import com.socialMedia.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers() {
        return userRepository.findUsers();
    }

}
