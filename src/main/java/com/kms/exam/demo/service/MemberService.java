package com.kms.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kms.exam.demo.repository.MemberRepository;
import com.kms.exam.demo.util.Ut;
import com.kms.exam.demo.vo.Member;
import com.kms.exam.demo.vo.ResultData;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public ResultData join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		// 아이디 중복 체크
		Member oldMember = getMemberByLoginId(loginId);

		if (oldMember != null) {
			return ResultData.from("F-7", Ut.f("해당 로그인아이디(%s)는 이미 사용중입니다.", loginId));
		}

		// 이름 중복 체크
		oldMember = getMemberByNameAndEmail(name, email);

		if (oldMember != null) {
			return ResultData.from("F-8", Ut.f("해당 이름(%s)과 이메일(%s)은 이미 사용중입니다.", name,email));
		}

		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		int id = memberRepository.getLastInsertId();
		return ResultData.from("S-1", "회원가입되었습니다.", id);
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
