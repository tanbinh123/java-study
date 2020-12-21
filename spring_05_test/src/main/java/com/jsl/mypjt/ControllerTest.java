package com.jsl.mypjt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.News_dto;

@Controller
public class ControllerTest {
	
	@RequestMapping("/Notice")
	public String notice(HttpServletRequest request, Model model) {
		request.setAttribute("t_name", "홍길동");
		model.addAttribute("t_age", "24");
		News_dto dto = new News_dto("N001", "제목이다", "내용이다", "담당자", "2020-12-21");
		model.addAttribute("t_dto", dto);
		return "notice";
	}
	@RequestMapping("/Qna")
	public String qna() {
		return "qna";
	}
	@RequestMapping("/News")
	public String news() {
		return "/News/news";
	}
}
