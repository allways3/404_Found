package com.multi.travel_404.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private long no;    // 게시글 번호
    private String title;   // 게시글 제목
    private String content; // 게시글 내용
    private int count;  // 조회수
    private LocalDateTime createdDate;  // 생성 날짜
    private String status;  // 게시글 상태
    private String writer;  // 작성자
}