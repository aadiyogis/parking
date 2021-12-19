package com.publicis.sapient.parking.service.impl;

import com.publicis.sapient.parking.model.Role;
import com.publicis.sapient.parking.model.User;
import com.publicis.sapient.parking.repository.UserRepository;
import com.publicis.sapient.parking.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * aditya created on 19/12/21
 */
@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User createUser(User user, String role) {
        return userRepository.saveAndFlush(user);
    }
}
