package com.ishostak.toursoverplanet.controller;

import com.ishostak.toursoverplanet.dto.UserUpdateDto;
import com.ishostak.toursoverplanet.entity.Tour;
import com.ishostak.toursoverplanet.exception.TourServiceException;
import com.ishostak.toursoverplanet.service.TourService;
import com.ishostak.toursoverplanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tours")
public class TouController {

    private UserService userService;
    private TourService tourService;

    @Autowired
    public TouController(UserService userService, TourService tourService) {
        this.userService = userService;
        this.tourService = tourService;
    }

    @GetMapping
    public String showTours(Model model) {
        List<Tour> tours = tourService.getAllTours();

        model.addAttribute("tours",  tours);

        return "tour/tours";
    }

    @GetMapping("/showFormAdd")
    public String showFormForAdd(Model model) {

        model.addAttribute("tourData", new Tour());

        return "tour/showFormAdd";
    }

    @PostMapping
    public String saveTour(@ModelAttribute("tourData") Tour tour) throws TourServiceException {

        tourService.createTour(tour);

        return "redirect:/tours";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("tourId") long id) {
        tourService.deleteById(id);

        return "redirect:/tours";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") long id,
                                    Model model) {

        return "tour/showFormForUpdate";
    }


    @GetMapping("/update")
    public String update(@ModelAttribute UserUpdateDto dto) {

        return "redirect:/tours";
    }
}
