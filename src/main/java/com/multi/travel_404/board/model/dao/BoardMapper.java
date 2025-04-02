package com.multi.travel_404.board.model.dao;

import com.multi.travel_404.board.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    int getTotalCount(); // 전체 게시글 개수 조회

    List<BoardDTO> selectListWithPaging(@Param("pageSize") int pageSize, @Param("offset") int offset);

    BoardDTO selectBoard(int bno);

    int insertBoard(BoardDTO newBoardDTO);

    int deleteBoard(int bno);

    int updateBoard(BoardDTO updBoardDTO);

    void updateCount(int no);
}
