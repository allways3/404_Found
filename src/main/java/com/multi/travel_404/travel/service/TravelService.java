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

    //한세빈
    public TravelService(TravelMapper travelMapper) {
        this.travelMapper = travelMapper;
    }

    //한세빈
    public List<TravelDTO> searchTravels(String keyword) {
        return travelMapper.searchTravels(keyword);
    }

}
