package com.wjs.tianyue.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.tianyue.mvc.pojo.Tb_Menu;
import com.wjs.tianyue.mvc.service.MenuService;
import com.wjs.tianyue.utils.Message;

@Controller
public class MenuControl {
	
	@Autowired
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping("/getUrl")
	public Message getUrl(Tb_Menu tb_menu){
		return this.menuService.getUrl(tb_menu);
	}
}
