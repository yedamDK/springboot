package com.yedam.boot.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.boot.member.MemberVO;
import com.yedam.boot.member.mapper.MemberMapper;
import com.yedam.boot.member.service.MemberSerivce;

@Service
public class MemberServiceImpl implements MemberSerivce, UserDetailsService {
	
	@Autowired MemberMapper memberMapper;

	@Override
	public MemberVO getMember(String id) {
		// TODO Auto-generated method stub
		return memberMapper.getMember(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = memberMapper.getMember(username);
		if(memberVO == null) {
			throw new UsernameNotFoundException("no userid");
		}
		return memberVO;
	}



	

}
