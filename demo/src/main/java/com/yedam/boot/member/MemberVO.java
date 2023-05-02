package com.yedam.boot.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails {
	String memberId;
	String memberPw;
	String memberName;
	String memberPhone;
	String memberAddr;
	String responsibility;
	String image;
	String memberRole;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(memberRole));		
		return list;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return memberPw;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return memberId;
	}
	@Override
	public boolean isAccountNonExpired() {
		// 비번 유효기간? 변경할 기간??
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// 시도횟수 초과 시 로그인 안 되게 잠그기
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// 휴먼계정 return에 loginyn.euq(1) 를 쓰면 ; 
		return true;
	}

}
