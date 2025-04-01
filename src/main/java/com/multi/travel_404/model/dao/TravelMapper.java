package com.multi.travel_404.model.dao;

import com.multi.travel_404.model.dto.TravelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelMapper {
    int getTotalCount();  // 전체 데이터 개수 조회

    List<TravelDTO> getAllTravels(@Param("offset") int offset, @Param("limit") int limit);

}
