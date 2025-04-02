package com.multi.travel_404.board.controller;

import com.multi.travel_404.authenication.dto.CustomUser;
import com.multi.travel_404.board.model.dto.BoardDTO;
import com.multi.travel_404.board.service.BoardService;
import com.multi.travel_404.member.model.dto.MemberDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String listBoards(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
        int pageSize = 10; // 한 페이지에 보여줄 게시글 수
        int offset = (page - 1) * pageSize;

        List<BoardDTO> boardDTOList = boardService.selectList(pageSize, offset);
        int totalCount = boardService.getTotalCount(); // 전체 게시글 개수
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        model.addAttribute("list", boardDTOList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "board/board_list";
    }

    @GetMapping("/selectone")
    public String findBoardDetail(@RequestParam("no") int pid, Model model) {
        try {
            boardService.increaseViewCount(pid);
            BoardDTO boardDTO = boardService.getBoard(pid);

            if (boardDTO != null) {
                model.addAttribute("b", boardDTO);
                return "board/board_detail"; // 상세 페이지로 이동
            } else {
                model.addAttribute("msg", "해당 게시글이 존재하지 않습니다.");
                return "common/errorPage";
            }
        } catch (Exception e) {
            model.addAttribute("msg", "게시글 상세 조회 실패");
            return "common/errorPage";
        }
    }

    @GetMapping("/insert")
    public String getInsertForm() {
        return "board/insertform";
    }

    @PostMapping("/insert")
    public String insertBoard(@RequestParam("title") String title,
                              @RequestParam("content") String content,
                              Authentication authentication,
                              Model model) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setContent(content);

        // Spring Security Authentication 객체에서 CustomUser 정보 추출
        if (authentication == null || !authentication.isAuthenticated()) {
            model.addAttribute("msg", "로그인이 필요합니다.");
            return "common/errorPage";
        }

        // CustomUser에서 MemberDTO 정보를 추출
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        MemberDTO memberDTO = customUser.getMemberDTO(); // getMemberDTO() 메소드가 있어야 함.

        if (memberDTO == null) {
            model.addAttribute("msg", "사용자 정보가 올바르지 않습니다.");
            return "common/errorPage";
        }

        boardDTO.setWriter(memberDTO.getId()); // MemberDTO의 id를 사용

        int result = boardService.insertBoard(boardDTO);

        if (result > 0) {
            return "redirect:/board/list"; // 게시글 목록 페이지로 리다이렉트
        } else {
            model.addAttribute("msg", "게시글 등록 실패");
            return "common/errorPage";
        }
    }


    @GetMapping("/update")
    public String updateForm(@RequestParam("no") int bno, Model model) {
        try {
            BoardDTO boardDTO = boardService.selectBoard(bno); // 기존 게시글 정보 가져오기
            model.addAttribute("b", boardDTO);
            return "board/updateform";
        } catch (Exception e) {
            model.addAttribute("msg", "수정 화면 불러오기 실패");
            return "common/errorPage";
        }
    }

    @PostMapping("/update")
    public String updateBoard(@RequestParam("no") int no,
                              @RequestParam("title") String title,
                              @RequestParam("content") String content,
                              Model model) {
        try {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setNo(no);
            boardDTO.setTitle(title);
            boardDTO.setContent(content);

            int result = boardService.updateBoard(boardDTO);
            if (result > 0) {
                return "redirect:/board/selectone?no=" + boardDTO.getNo();
            } else {
                model.addAttribute("msg", "게시글 수정 실패");
                return "common/errorPage";
            }
        } catch (Exception e) {
            model.addAttribute("msg", "게시글 수정 중 오류 발생");
            return "common/errorPage";
        }
    }

    @GetMapping("/delete")
    public String deleteBoard(@RequestParam("no") int bno, Model model) {
        try {
            int result = boardService.deleteBoard(bno);
            if (result > 0) {
                return "redirect:/board/list";
            } else {
                model.addAttribute("msg", "게시글 삭제 실패");
                return "common/errorPage";
            }
        } catch (Exception e) {
            model.addAttribute("msg", "게시글 삭제 중 오류 발생");
            return "common/errorPage";
        }
    }

    @GetMapping("/view")
    public String viewBoard(@RequestParam("no") int no, Model model) {
        BoardDTO board = boardService.getBoard(no);  // ✅ 수정된 서비스 호출
        model.addAttribute("board", board);
        return "board/view";
    }


}
