package com.ishostak.toursoverplanet.service;

import com.ishostak.toursoverplanet.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public void authenticateUser(String email, String password) {
        logger.info("Set authentication: {}", email);

        validateUser(email, password);

        setAuthentication(email);
    }

    private void validateUser(String email, String password) {

        final Optional<User> user = userService.readByEmail(email);

        if (user.isPresent()) {
            String passwordFromDb = user.get().getPassword().getPayload();
            logger.debug("User found: {}", email);

            boolean isValid = passwordEncoder.matches(password, passwordFromDb);

            if (isValid) {
                logger.debug("Password is valid for user {}", email);
            } else {
                logger.error("Invalid credentials: {}", email);
                throw new NoSuchElementException("Invalid email or password");
            }
        } else {
            logger.error("No such user: {}", email);
            throw new NoSuchElementException("No such user");
        }
    }

    private void setAuthentication(String email) {
        Collection<? extends GrantedAuthority> authorities = new ArrayList<>();

        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                email, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
}
