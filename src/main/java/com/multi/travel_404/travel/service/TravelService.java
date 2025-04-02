package com.multi.travel_404.travel.service;

import com.multi.travel_404.travel.model.dao.TravelMapper;
import com.multi.travel_404.travel.model.dto.TravelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TravelService {
    private final TravelMapper travelMapper;

    private static final int PAGE_SIZE = 10;  // 한 페이지당 10개씩 - 정승호

    public TravelService(TravelMapper travelMapper) {
        this.travelMapper = travelMapper;
    }

    // 한세빈
    public List<TravelDTO> searchTravels(String keyword) {
        return travelMapper.searchTravels(keyword);
    }

    // 정승호
    public List<TravelDTO> getTravelList(int page) {
        int PAGE_SIZE = 10;
        int offset = (page - 1) * PAGE_SIZE;  // page 1: offset=0, page 2: offset=10, ...
        return travelMapper.getAllTravels(offset, PAGE_SIZE);
    }

    // 정승호
    public int getTotalPages() {
        int totalCount = travelMapper.getTotalCount();
        return (int) Math.ceil(totalCount / (double) PAGE_SIZE);
    }

    // 안태희
    public List<TravelDTO> findByName(String name) {
        return travelMapper.findByName(name);
    }

    // 김민호
    public List<TravelDTO> getNearTouristSpots(String district) {
        return travelMapper.getNearTravel(district);
    }
}
