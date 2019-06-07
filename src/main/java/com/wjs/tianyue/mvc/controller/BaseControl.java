package com.wjs.tianyue.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.tianyue.mvc.pojo.Tb_Menu;
import com.wjs.tianyue.mvc.pojo.Tb_Supliter;
import com.wjs.tianyue.mvc.pojo.Tb_User;
import com.wjs.tianyue.mvc.service.BaseService;
import com.wjs.tianyue.utils.DataGrid;
import com.wjs.tianyue.utils.Message;

@Controller
public class BaseControl {

	@Autowired
	private BaseService baseService;
	@ResponseBody
	@RequestMapping("/login")
	public Message login(Tb_User user,HttpSession session){
		return this.baseService.login(user,session);
	}
	
	@ResponseBody
	@RequestMapping("/getUrl")
	public Message getUrl(Tb_Menu tb_menu){
		return this.baseService.getUrl(tb_menu);
	}
	@ResponseBody
	@RequestMapping("/getDataGrid")
	public DataGrid getDataGrid(Tb_Supliter sup, int page, int rows){
		return this.baseService.getDataGrid(sup,page,rows);
	}
}
