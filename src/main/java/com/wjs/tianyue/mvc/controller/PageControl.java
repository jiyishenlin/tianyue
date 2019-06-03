package com.wjs.tianyue.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControl {

	@RequestMapping("/")
	public String firstPage(){
		return "/WEB-INF/jsp/base/first.jsp";
	}
}
