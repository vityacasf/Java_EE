package com.socialmedia.service;

import com.socialmedia.model.User;
import com.socialmedia.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findUsers() {
    return userRepository.findUsers();
  }

  public boolean createUser(String login, String password) {
    if (isExists(login)) {
      return false;
    } else {
      userRepository.createUser(login, password);
      return true;
    }
  }

  public Optional<User> getUser(String login) {
    return userRepository.getUser(login);
  }
  public List<User> findUsersStartWith(String login) {
    return userRepository.findUsersStartWith(login);
  }

  public boolean isExists(String login) {
    return userRepository.isExists(login);
  }
}

