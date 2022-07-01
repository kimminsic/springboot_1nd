package com.kms.exam.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kms.exam.demo.service.MemberService;
import com.kms.exam.demo.vo.Article;
import com.kms.exam.demo.vo.Member;

@Controller
public class UsrMemberController {
	@Autowired
	private MemberService memberService;
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Member doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		Member member = memberService.getMemberById(id);
		
		return member;
	}
}
