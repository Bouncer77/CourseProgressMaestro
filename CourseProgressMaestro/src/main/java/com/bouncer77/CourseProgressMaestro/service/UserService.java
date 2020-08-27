package com.bouncer77.CourseProgressMaestro.service;

import com.bouncer77.CourseProgressMaestro.entity.User;

/**
 * Сервис интрефейс для {@link com.bouncer77.CourseProgressMaestro.entity.User}
 *
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByLogin(String login);
    User findByEmail(String email);
}
