package com.multi.travel_404.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private long no;
    private String title;
    private String content;
    private int count;
    private LocalDateTime createdDate;  // 시간 정보까지 포함
    private String status;
    private String writer;
}