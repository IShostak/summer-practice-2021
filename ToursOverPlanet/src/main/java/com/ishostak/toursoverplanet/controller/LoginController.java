package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.LoginDto;
import com.ishostak.toursoverplanet.exception.AuthenticationServiceException;
import com.ishostak.toursoverplanet.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@Valid LoginDto dto) throws AuthenticationServiceException {
        logger.info("Started authentication for user: {}", dto.getEmail());

        authenticationService.authenticateUser(dto.getEmail(), dto.getPassword());

        return "redirect:/profile";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("dto", new LoginDto());
        return "login";
    }
}
