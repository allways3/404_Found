package com.multi.travel_404.travel.controller;

import com.multi.travel_404.travel.model.dto.TravelDTO;
import com.multi.travel_404.travel.service.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/travel")
public class TravelController {
    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    // 한세빈
    @GetMapping("/search")
    public String searchTravels(@RequestParam("keyword") String keyword, Model model) {

        List<TravelDTO> travels = travelService.searchTravels(keyword);
        model.addAttribute("travels", travels);

        return "travel/search";
    }
}
