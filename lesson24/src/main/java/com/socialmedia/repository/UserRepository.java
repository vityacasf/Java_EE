package com.socialmedia.repository;

import java.util.List;

import com.socialmedia.model.User;

public interface UserRepository {

        boolean isUserExists(String login, String password);

        boolean isUserExists(String login);

        boolean insertUser(String login, String password);

        List<User> getAllUsers();

        List<User> getAllUsers(String parameter);
    }
