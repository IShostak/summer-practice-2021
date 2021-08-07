package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.LoginDto;
import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.entity.User;
import com.ishostak.toursoverplanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showRegistration(Model model) {
        model.addAttribute("userData", new RegistrationDto());
        return "registration";
    }

    @GetMapping("/login")
    public String showIndex(Model model) {
        model.addAttribute("dto", new LoginDto());
        return "login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        String userEmail = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User thisUser = userService.readByEmail(userEmail).get();
        model.addAttribute("user",  thisUser);

        return "profile";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userService.readAll();
        model.addAttribute("users",  users);

        return "users";
    }
}
