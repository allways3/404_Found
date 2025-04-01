package com.multi.travel_404.controller;

import com.multi.travel_404.model.dto.TravelDTO;
import com.multi.travel_404.service.TravelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelController {
    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/search")
    public List<TravelDTO> searchPlace(@RequestParam String name) {
        return travelService.findByName(name);
    }
}
