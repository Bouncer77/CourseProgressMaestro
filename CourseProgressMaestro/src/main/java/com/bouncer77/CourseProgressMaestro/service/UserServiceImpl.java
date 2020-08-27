package com.bouncer77.CourseProgressMaestro.service;

import com.bouncer77.CourseProgressMaestro.entity.Role;
import com.bouncer77.CourseProgressMaestro.entity.User;
import com.bouncer77.CourseProgressMaestro.repository.RoleRepository;
import com.bouncer77.CourseProgressMaestro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Имплементация интерфейса {@link UserService}
 *
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1)); // Student
        user.setRoles(roles);

        userRepository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
