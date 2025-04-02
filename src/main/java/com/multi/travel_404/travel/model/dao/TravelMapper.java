package com.multi.travel_404.travel.model.dao;

import com.multi.travel_404.travel.model.dto.TravelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelMapper {
    int getTotalCount();  // 전체 데이터 개수 조회 - 정승호

    // 정승호
    List<TravelDTO> getAllTravels(@Param("offset") int offset, @Param("limit") int limit);


    // 한세빈
    List<TravelDTO> searchTravels(String keyword);

    //안태희
//    @Select("SELECT * FROM travel WHERE name LIKE CONCAT('%', #{name}, '%')")
//    List<TravelDTO> findByName(@Param("name") String name);
}
