package com.multi.travel_404.service;

import com.multi.travel_404.model.dao.TravelMapper;
import com.multi.travel_404.model.dto.TravelDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TravelService {

    private final TravelMapper travelMapper;
    private static final int PAGE_SIZE = 10;  // 한 페이지당 10개씩

    public TravelService(TravelMapper travelMapper) {
        this.travelMapper = travelMapper;
    }

    public List<TravelDTO> getTravelList(int page) {
        int PAGE_SIZE = 10;
        int offset = (page - 1) * PAGE_SIZE;  // page 1: offset=0, page 2: offset=10, ...
        return travelMapper.getAllTravels(offset, PAGE_SIZE);
    }

    public int getTotalPages() {
        int totalCount = travelMapper.getTotalCount();
        return (int) Math.ceil(totalCount / (double) PAGE_SIZE);
    }
}
