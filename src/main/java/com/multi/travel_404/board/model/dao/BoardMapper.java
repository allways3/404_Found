package com.multi.travel_404.board.model.dao;

import com.multi.travel_404.board.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 전체 게시글 개수 조회
    int getTotalCount();

    // 페이징 적용, 게시글 목록 조회
    List<BoardDTO> selectListWithPaging(@Param("pageSize") int pageSize, @Param("offset") int offset);

    // 게시글 번호로 특정 글 조회
    BoardDTO selectBoard(int bno);

    // 새로운 게시글 추가
    int insertBoard(BoardDTO newBoardDTO);

    // 특정 게시글 삭제
    int deleteBoard(int bno);

    // 게시글 수정
    int updateBoard(BoardDTO updBoardDTO);

    // 게시글 조회수 증가
    void updateCount(int no);
}
