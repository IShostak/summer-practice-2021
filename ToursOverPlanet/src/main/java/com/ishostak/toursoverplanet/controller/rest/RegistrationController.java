package com.ishostak.toursoverplanet.controller.rest;

import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.exception.UserServiceException;
import com.ishostak.toursoverplanet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public void userRegistration(@Valid RegistrationDto userData, HttpServletResponse response) throws UserServiceException, IOException {
         logger.info("Creating request for user registration: {}", userData);

         userService.create(userData);

         response.sendRedirect("/login");
    }
}
