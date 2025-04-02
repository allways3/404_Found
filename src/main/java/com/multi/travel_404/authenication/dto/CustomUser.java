package com.multi.travel_404.authenication.dto;

import com.multi.travel_404.member.model.dto.MemberDTO;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Setter
@ToString(exclude = "pw")
public class CustomUser implements UserDetails {

    private String id;
    private String pw;
    private String memberEmail;
    private Collection<? extends GrantedAuthority> authorities;

    private MemberDTO memberDTO;

    // 생성자에서 memberDTO 초기화
    public CustomUser(MemberDTO member, Collection<? extends GrantedAuthority> authorities) {
        this.id = member.getId();
        this.pw = member.getPw();
        this.memberEmail = member.getMemberEmail();
        this.authorities = authorities;
        this.memberDTO = member;  // memberDTO를 초기화
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return pw;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 만료되지 않음
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정이 잠기지 않음
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호가 만료되지 않음
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정이 활성화됨
    }
//
//    public MemberDTO getMemberDTO() {
//        return memberDTO;  // 정상적으로 memberDTO를 반환
//    }
}
