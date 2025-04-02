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
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDTO> selectList(int pageSize, int offset) {
        return boardMapper.selectListWithPaging(pageSize, offset);
    }

    public int getTotalCount() {
        return boardMapper.getTotalCount();
    }

    public BoardDTO selectBoard(int bno) {
        return boardMapper.selectBoard(bno);
    }

    public int insertBoard(BoardDTO newBoardDTO) {
        return boardMapper.insertBoard(newBoardDTO);
    }

    public int deleteBoard(int bno) {
        return boardMapper.deleteBoard(bno);
    }

    public int updateBoard(BoardDTO updBoardDTO) {
        return boardMapper.updateBoard(updBoardDTO);
    }
    
    @Transactional
    public void increaseViewCount(int no) {
        boardMapper.updateCount(no);
    }

    @Transactional(readOnly = true)
    public BoardDTO getBoard(int no) {
        return boardMapper.selectBoard(no);
    }
}
