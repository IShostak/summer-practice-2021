package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.LoginDto;
import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.entity.Tour;
import com.ishostak.toursoverplanet.entity.User;
import com.ishostak.toursoverplanet.service.TourService;
import com.ishostak.toursoverplanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    private UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        String userEmail = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User thisUser = userService.readByEmail(userEmail).get();
        model.addAttribute("user",  thisUser);

        return "profile";
    }
}
