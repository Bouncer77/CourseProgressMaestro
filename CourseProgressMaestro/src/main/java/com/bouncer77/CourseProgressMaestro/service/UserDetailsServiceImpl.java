package com.bouncer77.CourseProgressMaestro.service;

import com.bouncer77.CourseProgressMaestro.entity.Role;
import com.bouncer77.CourseProgressMaestro.entity.User;
import com.bouncer77.CourseProgressMaestro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Имплементация интерфейса {@link org.springframework.security.core.userdetails.UserDetailsService}
 * Выдает пользователю разрешения из БД
 *
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 * @version 1.0
 */

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userRepository.findByLogin(login);

        // Множество разрешений
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        // Добавить в разрешения для данного польхователя все роли, которые у него есть в бд
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }
}
