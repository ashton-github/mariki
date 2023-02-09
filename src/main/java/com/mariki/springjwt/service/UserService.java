package com.mariki.springjwt.service;

import com.mariki.springjwt.models.User;

import java.util.List;

public interface UserService {

//  User creatUser (User user);

    List<User> getAllUsers ();

    User modifyUser (Long id, User user);

    User getUserById (Long id);

    String deleteUser(Long id);
}
