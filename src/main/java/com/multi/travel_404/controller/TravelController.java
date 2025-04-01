package com.multi.travel_404.controller;

import com.multi.travel_404.model.dto.TravelDTO;
import com.multi.travel_404.service.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/search")
    public String searchTravels(@RequestParam("keyword") String keyword, Model model) {

        List<TravelDTO> travels = travelService.searchTravels(keyword);
        model.addAttribute("travels", travels);

        return "travel/search";
    }
}
