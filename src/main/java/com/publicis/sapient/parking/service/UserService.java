package com.publicis.sapient.parking.service;

import com.publicis.sapient.parking.model.User;

/**
 * aditya created on 19/12/21
 */
public interface UserService {
    User createUser(User user, String role);

    // User login(String userName);
}
