package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.entity.User;
import com.ishostak.toursoverplanet.exception.UserServiceException;
import com.ishostak.toursoverplanet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public User userRegistration(@RequestBody @Valid RegistrationDto userData) throws UserServiceException {
         logger.info("Creating request for user registration: {}", userData);

         return userService.create(userData);
    }
}
