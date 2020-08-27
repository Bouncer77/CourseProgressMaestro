package com.bouncer77.CourseProgressMaestro.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Имплементация {@link SecurityService}
 * Менеджер аутентификации
 *
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 27.08.2020
 * @version 1.0
 */

@Service
public class SecurityServiceImpl implements SecurityService {

    // private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Qualifier("inMemoryUserDetailsManager")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedInLogin() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autoLogin(String login, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(authenticationToken);

        // Если токен авторизован
        if (authenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            // logger.debug(String.format("Successfully %s auto logged in.", login));
        }
    }
}
