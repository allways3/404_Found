package com.multi.travel_404.travel.controller;

import com.multi.travel_404.travel.model.dto.TravelDTO;
import com.multi.travel_404.travel.service.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // 관광지 검색하기 - 한세빈
    @GetMapping("/search")
    public String searchTravels(@RequestParam("keyword") String keyword, Model model) {

        List<TravelDTO> travels = travelService.searchTravels(keyword);
        model.addAttribute("travels", travels);

        return "travel/search";
    }

    // 주변 관광지 보기 - 김민호
    @GetMapping("/travels/{title}")
    public String getNearbyTravels(@PathVariable String title, Model model) {
        model.addAttribute("title", title);
        return "travel/nearbyTravels"; // nearbyTravels.html 뷰를 반환
    }

    // 관광지 목록 - 정승호
    @GetMapping("/list")
    public String getTravelList(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
        List<TravelDTO> travelList = travelService.getTravelList(page);
        int totalPages = travelService.getTotalPages();

        model.addAttribute("travels", travelList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "travel/travel_list";
    }

    // 카카오맵으로 관광지 표시 - 안태희
//    @GetMapping("/kakaosearch")
//    public List<TravelDTO> searchPlace(@RequestParam String name) {
//        return travelService.findByName(name);
//    }

}
