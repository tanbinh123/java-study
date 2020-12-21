package com.jsl.mypjt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Mycont2 {
	@RequestMapping("/abc")
	public String abc() {
		return "qna";
	}
}
