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

    public CustomUser(MemberDTO member, Collection<? extends GrantedAuthority> authorities) {
        this.id = member.getId();
        this.pw = member.getPw();
        this.memberEmail = member.getMemberEmail();
        this.authorities = authorities;
        this.memberDTO = member;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
