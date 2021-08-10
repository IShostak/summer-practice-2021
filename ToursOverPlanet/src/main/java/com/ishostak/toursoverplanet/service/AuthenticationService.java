package com.ishostak.toursoverplanet.service;

import com.ishostak.toursoverplanet.entity.User;
import com.ishostak.toursoverplanet.entity.enums.Role;
import com.ishostak.toursoverplanet.exception.AuthenticationServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    private UserService userService;
    private PasswordService passwordService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserService userService, PasswordService passwordService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordService = passwordService;
        this.passwordEncoder = passwordEncoder;
    }

    public void authenticateUser(String email, String password) throws AuthenticationServiceException {
        logger.info("Set authentication: {}", email);

        Set<Role> roles = validateUserAndGetRoles(email, password);

        setAuthentication(email, roles);
    }

    private Set<Role> validateUserAndGetRoles(String email, String password) throws AuthenticationServiceException {

        logger.info("Authorization attempt for user: {}", email);

        final User user = userService.readByEmail(email).
                orElseThrow(()->
                        new NoSuchElementException("No such user"));

        if (user.isBlocked()) throw new AuthenticationServiceException(
                "User is blocked. Contact admin for further details");

            String passwordFromDb = user.getPassword().getPayload();

            logger.debug("User found: {}", email);

            if (passwordEncoder.matches(password, passwordFromDb)) {
                logger.debug("Password is valid for user {}", email);
                return user.getRoles();
            } else {
                logger.error("Invalid credentials: {}", email);
                throw new NoSuchElementException("Invalid email or password");
            }
    }

    private void setAuthentication(String email , Set<Role> roles) {

        Collection<GrantedAuthority> authorities = roles.stream()
                .map(x-> new SimpleGrantedAuthority(x.name()))
                .collect(Collectors.toSet());

        logger.debug("User authorities : {}", authorities);

        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                email, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
}
