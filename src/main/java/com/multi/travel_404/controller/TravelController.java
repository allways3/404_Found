package com.multi.travel_404.controller;

import com.multi.travel_404.model.dto.TravelDTO;
import com.multi.travel_404.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/list")
    public String getTravelList(@RequestParam(defaultValue = "1") int page, Model model) {
        List<TravelDTO> travelList = travelService.getTravelList(page);
        int totalPages = travelService.getTotalPages();

        model.addAttribute("travels", travelList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "travel_list";
    }


}
