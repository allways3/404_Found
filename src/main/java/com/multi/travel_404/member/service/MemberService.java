package com.multi.travel_404.member.service;

import com.multi.travel_404.member.model.dao.MemberMapper;
import com.multi.travel_404.member.model.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;

    public MemberService(BCryptPasswordEncoder passwordEncoder, MemberMapper memberMapper) {
        this.passwordEncoder = passwordEncoder;
        this.memberMapper = memberMapper;
    }

    public void registMember(MemberDTO memberDTO) {

        String encodePwd = passwordEncoder.encode(memberDTO.getPw());
        memberDTO.setPw(encodePwd);

        int result = memberMapper.registMember(memberDTO);
        if (result <= 0) {
            throw new RuntimeException("registMember failed : count = 0");
        } else
            log.info("회원가입 성공");
    }
}
