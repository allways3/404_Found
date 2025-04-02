package com.multi.travel_404.member.model.dao;

import com.multi.travel_404.member.model.dto.MemberDTO;

public interface MemberMapper {

    MemberDTO findMemberById(String memberId);

    int registMember(MemberDTO memberDTO);

    MemberDTO findMemberByEmail(String email);

}
