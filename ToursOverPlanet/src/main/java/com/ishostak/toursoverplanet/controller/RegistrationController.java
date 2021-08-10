package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.exception.UserServiceException;
import com.ishostak.toursoverplanet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String userRegistration(@Valid RegistrationDto userData) throws UserServiceException, IOException {
         logger.info("Creating request for user registration: {}", userData.getEmail());

         userService.create(userData);

         return "redirect:/login";
    }

    @GetMapping("/registration")
    public String showRegistration(Model model) {
        model.addAttribute("userData", new RegistrationDto());
        return "registration";
    }
}
