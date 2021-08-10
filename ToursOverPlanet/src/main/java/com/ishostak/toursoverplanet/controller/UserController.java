package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.dto.UserUpdateDto;
import com.ishostak.toursoverplanet.entity.User;
import com.ishostak.toursoverplanet.entity.enums.Role;
import com.ishostak.toursoverplanet.exception.UserServiceException;
import com.ishostak.toursoverplanet.service.TourService;
import com.ishostak.toursoverplanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private TourService tourService;

    @Autowired
    public UserController(UserService userService, TourService tourService) {
        this.userService = userService;
        this.tourService = tourService;
    }

    @GetMapping
    public String showUsers(Model model) {
        List<User> users = userService.readAll();
        model.addAttribute("users",  users);

        return "user/users";
    }

    @GetMapping("/showFormAdd")
    public String showFormForAdd(Model model) {

        model.addAttribute("userData", new RegistrationDto());

        return "user/showFormAdd";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("userData") RegistrationDto user) throws UserServiceException {

        userService.create(user);

        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") long id) {
        userService.deleteById(id);

        return "redirect:/users";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") long id,
                                    Model model) {

        UserUpdateDto userData = convertToDto(userService.readById(id).get());

        model.addAttribute("userData", userData);

        return "user/showFormForUpdate";
    }


    @GetMapping("/update")
    public String update(@ModelAttribute UserUpdateDto dto) {

        User userFromDB = userService.readById(dto.getId()).get();

        updateUserData(userFromDB, dto);

        userService.updateUser(userFromDB);

        return "redirect:/users";
    }

    public static UserUpdateDto convertToDto(User user) {
        return UserUpdateDto.builder()
                .email(user.getEmail())
                .id(user.getUserId())
                .fullName(user.getFullName())
                .isAdmin(user.getRoles().contains(Role.ADMIN))
                .isManager(user.getRoles().contains(Role.MANAGER))
                .isBlocked(user.isBlocked())
                .build();
    }

    public static User updateUserData(User user, UserUpdateDto dto) {
        user.setBlocked(dto.isBlocked());
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());

        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);

        if (dto.isAdmin()) roles.add(Role.ADMIN);
        if (dto.isManager()) roles.add(Role.MANAGER);

        user.setRoles(roles);
        return user;
    }
//
//    @PutMapping("/{userId}")
//    public String updateUser(@PathVariable("userId") long id,
//                            @ModelAttribute("userData") User user) {
//
//        User user1 = userService.readById(id).get();
//
//        user1 = user;
//
//        userService.updateUser(user1);
//
//        return "redirect:/users";
//    }
}
