package com.ishostak.toursoverplanet.service;

import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.entity.User;
import com.ishostak.toursoverplanet.entity.enums.Role;
import com.ishostak.toursoverplanet.exception.PasswordServiceException;
import com.ishostak.toursoverplanet.exception.UserServiceException;
import com.ishostak.toursoverplanet.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordService passwordService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordService service, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordService = service;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User create(RegistrationDto dto) throws UserServiceException {
        logger.info("User registration: email = {}", dto.getEmail());

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            logger.error("User already exists in DB: email = {}", dto.getEmail());
            throw new UserServiceException("User already exists");
        }

        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);

        /**
         * for creating admin
         */
        if (dto.getFullName().equals("admin")) {
            roles.add(Role.ADMIN);
            roles.add(Role.MANAGER);
        }

        if (dto.isManager()) {
            logger.info("this user is manager {}", dto.getEmail());
            roles.add(Role.MANAGER);
        }

        final User actualUser = userRepository.saveAndFlush(new User(dto.getFullName(), dto.getEmail(), roles));

//        final User actualUser = userRepository.saveAndFlush(new User(dto.getFullName(), dto.getEmail(), Role.USER));

        try {
            passwordService.create(actualUser.getEmail(), passwordEncoder.encode(dto.getPassword()));
        } catch (PasswordServiceException ex) {
            logger.error("Error while register user", ex);
            throw new UserServiceException("Error creating user");
        }

        return actualUser;
    }

    public Optional<User> readByEmail(String email) {
        logger.info("Read user from db email = {}", email);

        final Optional<User> userFromDb = userRepository.findByEmail(email);

        if (! userFromDb.isPresent()) {
            logger.error("No user with this email {}", email);
            throw new NoSuchElementException("No such user");
        }

        return userFromDb;
    }

    public List<User> readAll() {
        logger.info("Reading all users from db");

        final List<User> usersFromDb = userRepository.findAll();

        return usersFromDb;
    }


    public void deleteById(long id) {
        logger.info("Deleting user with id {} from db", id);
        userRepository.deleteById(id);
    }

    public Optional<User> readById(long theId) {
        logger.info("Read user from db id = {}", theId);

        final Optional<User> userFromDb = userRepository.findUserByUserId(theId);

        if (! userFromDb.isPresent()) {
            logger.error("No user with this id {}", theId);
            throw new NoSuchElementException("No such user");
        }

        return userFromDb;
    }

    public User updateUser(User newUser) {

        User userFromDb = userRepository.findById(newUser.getUserId())
                .orElseThrow(()->new NoSuchElementException("No such user"));

        userFromDb.setPassword(newUser.getPassword());
        userFromDb.setFullName(newUser.getFullName());
        userFromDb.setEmail(newUser.getEmail());
        userFromDb.setRoles(newUser.getRoles());
        userFromDb.setBlocked(newUser.isBlocked());

        return userRepository.saveAndFlush(userFromDb);
    }
}
