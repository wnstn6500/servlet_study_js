package com.gn.service;


import java.util.List;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MemberService {
	
	private MemberDao dao = new MemberDao();
	
	public int insertMember(String id, String pw) {
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		return dao.insertMember(member);
	}

}
