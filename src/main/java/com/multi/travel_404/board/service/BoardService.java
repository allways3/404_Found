package com.multi.travel_404.board.service;

import com.multi.travel_404.board.model.dao.BoardMapper;
import com.multi.travel_404.board.model.dto.BoardDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class BoardService {
    // 의존성 주입
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // 페이징 적용, 게시글 목록 조회
    public List<BoardDTO> selectList(int pageSize, int offset) {
        return boardMapper.selectListWithPaging(pageSize, offset);
    }

    // 총 게시글 수 조회
    public int getTotalCount() {
        return boardMapper.getTotalCount();
    }

    // 특정 게시글 조회
    public BoardDTO selectBoard(int bno) {
        return boardMapper.selectBoard(bno);
    }

    // 게시글 등록
    public int insertBoard(BoardDTO newBoardDTO) {
        return boardMapper.insertBoard(newBoardDTO);
    }

    // 게시글 삭제
    public int deleteBoard(int bno) {
        return boardMapper.deleteBoard(bno);
    }

    // 게시글 수정
    public int updateBoard(BoardDTO updBoardDTO) {
        return boardMapper.updateBoard(updBoardDTO);
    }

    // 게시글 조회수 증가
    @Transactional  // 데이터 일관성 유지
    public void increaseViewCount(int no) {
        boardMapper.updateCount(no);
    }

    // 특정 게시글 가져오기
    @Transactional(readOnly = true) // 읽기 전용 트랜잭션
    public BoardDTO getBoard(int no) {
        return boardMapper.selectBoard(no);
    }
}
