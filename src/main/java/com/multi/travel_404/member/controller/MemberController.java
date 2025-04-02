package com.multi.travel_404.member.controller;

import com.multi.travel_404.member.model.dto.MemberDTO;
import com.multi.travel_404.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public void memberLogin() {
    }

    @GetMapping("/regist")
    public void memberRegist() {
    }

    @PostMapping("/regist")
    public String registMember(MemberDTO memberDTO) {
        memberService.registMember(memberDTO);
        return "redirect:/member/login";
    }
}
