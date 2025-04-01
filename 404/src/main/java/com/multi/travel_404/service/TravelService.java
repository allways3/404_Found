package com.multi.travel_404.service;

import com.multi.travel_404.model.dao.TravelMapper;
import com.multi.travel_404.model.dto.TravelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class TravelService {
    private final TravelMapper travelMapper;

    public TravelService(TravelMapper travelMapper) {
        this.travelMapper = travelMapper;
    }

    public List<TravelDTO> findByName(String name) {
        return travelMapper.findByName(name);
    }
}
