package com.kms.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdmHomeController {
	@RequestMapping("adm/home/main")
	@ResponseBody
	public String showMain() {
		return "어어";
	}
}
