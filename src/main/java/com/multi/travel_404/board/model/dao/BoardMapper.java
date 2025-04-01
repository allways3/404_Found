package com.multi.travel_404.board.model.dao;

import com.multi.travel_404.board.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {
    ArrayList<BoardDTO> selectList();

    BoardDTO selectBoard(int bno);

    int insertBoard(BoardDTO newBoardDTO);

    int deleteBoard(int bno);

    int updateBoard(BoardDTO updBoardDTO);
}
