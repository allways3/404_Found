package com.multi.travel_404.model.dao;

import com.multi.travel_404.model.dto.TravelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface TravelMapper {
    @Select("SELECT * FROM travel WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<TravelDTO> findByName(@Param("name") String name);
}
