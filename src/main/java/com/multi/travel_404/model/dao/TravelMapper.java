package com.multi.travel_404.model.dao;

import com.multi.travel_404.model.dto.TravelDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelMapper {
    List<TravelDTO> searchTravels(String keyword);
}
