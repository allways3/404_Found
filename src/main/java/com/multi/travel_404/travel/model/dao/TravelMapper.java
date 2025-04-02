package com.multi.travel_404.travel.model.dao;

import com.multi.travel_404.travel.model.dto.TravelDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelMapper {
    // 한세빈
    List<TravelDTO> searchTravels(String keyword);
}
