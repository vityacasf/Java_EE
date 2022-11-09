package com.socialMedia.repository;

import java.util.List;

import com.socialMedia.model.User;

public interface UserRepository {

        boolean isUserExists(String login, String password);

        boolean findUserByName(String login);

        boolean insertNewUser(String login, String password);

        List<User> getAllUsers();

        List<User> getAllUsers(String parameter);
    }
