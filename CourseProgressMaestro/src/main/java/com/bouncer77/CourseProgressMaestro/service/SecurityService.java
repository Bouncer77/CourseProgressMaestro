package com.bouncer77.CourseProgressMaestro.service;

/**
 * Сервис по безопасности
 *
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 * @version 1.0
 */

public interface SecurityService {

    // Искать залогиненых пользователей
    String findLoggedInLogin();

    void autoLogin(String login, String password);
}
