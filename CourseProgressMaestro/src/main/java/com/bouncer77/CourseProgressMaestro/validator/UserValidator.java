package com.bouncer77.CourseProgressMaestro.validator;

import com.bouncer77.CourseProgressMaestro.entity.User;
import com.bouncer77.CourseProgressMaestro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Валидатор для класса {@link com.bouncer77.CourseProgressMaestro.entity.User}
 * Имплементирует {@link Validator}
 *
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 * @version 1.0
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass); // Подтверждаем что это экземпляр нужного нам класса
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required"); // username

        if (user.getLogin().length() < 6 || user.getLogin().length() > 32) {
            errors.rejectValue("login","Size.userForm.login");
        }

        // Есть ли в бд пользователь с таким же логином?
        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        // Если ничего не ввели - то сообщение что данное поле является обязательным
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
     }
}
