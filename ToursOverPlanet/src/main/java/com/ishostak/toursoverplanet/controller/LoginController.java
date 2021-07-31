package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.LoginDto;
import com.ishostak.toursoverplanet.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginDto dto) {
        logger.info("Started authentication for user: {}", dto.getEmail());

        authenticationService.authenticateUser(dto.getEmail(), dto.getPassword());

        return "done";
    }
}
