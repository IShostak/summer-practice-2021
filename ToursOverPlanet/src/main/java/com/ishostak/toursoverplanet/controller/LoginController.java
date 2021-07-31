package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.LoginDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/login")
    public void login(@RequestBody @Valid LoginDto dto) {

    }
}
