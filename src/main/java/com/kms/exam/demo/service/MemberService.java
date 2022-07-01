package com.kms.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kms.exam.demo.repository.MemberRepository;
import com.kms.exam.demo.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public int join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		// 아이디 중복 체크
		Member oldMember = getMemberByLoginId(loginId);

		if (oldMember != null) {
			return -1;
		}

		// 이름 중복 체크
		oldMember = getMemberByNameAndEmail(name, email);

		if (oldMember != null) {
			return -2;
		}

		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		return memberRepository.getLastInsertId();
	}

	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	private Member getMemberByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		// TODO Auto-generated method stub
		return memberRepository.getMemberById(id);
	}

}
