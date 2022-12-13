package com.socialmedia.repository;

import java.util.List;
import java.util.Optional;

import com.socialmedia.model.User;

public interface UserRepository {

        List<User> findUsers();

        Optional<User> getUser(String login);

        void createUser(String login, String password);

        List<User> findUsersStartWith(String login);
}
