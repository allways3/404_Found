package com.multi.travel_404.authenication.service;

import com.multi.travel_404.authenication.dto.CustomUser;
import com.multi.travel_404.member.model.dao.MemberMapper;
import com.multi.travel_404.member.model.dto.MemberDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final MemberMapper memberMapper;

    public CustomUserDetailService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("username : " + username);

        MemberDTO memberDto = memberMapper.findMemberById(username);

        if (memberDto == null) {
            throw new UsernameNotFoundException("회원정보가 존재하지 않습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(memberDto.getMemberRole()));

        return new CustomUser(memberDto, authorities);
    }

    public Map<String, List<String>> getPermitListMap() {

        Map<String, List<String>> permitListMap = new HashMap<>();
        List<String> adminPermitList = new ArrayList<>(); // 권한별로 접근가능한 url리스트를 담을 리스트를만듬
        List<String> memberPermitList = new ArrayList<>();

        adminPermitList.add("/board/insertform");
        adminPermitList.add("/board/updateform");

        memberPermitList.add("/board/board_list");
        memberPermitList.add("/board/board_detail");

        permitListMap.put("adminPermitList", adminPermitList);
        permitListMap.put("memberPermitList", memberPermitList);

        return permitListMap;
    }
}
