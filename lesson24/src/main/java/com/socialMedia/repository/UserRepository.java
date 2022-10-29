package com.socialMedia.repository;

import java.util.List;

import com.socialMedia.model.User;

public interface UserRepository {

    List<User> findUsers();

}
