package com.wjs.tianyue.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.tianyue.mvc.pojo.Tb_Supliter;
import com.wjs.tianyue.mvc.service.SupliterService;
import com.wjs.tianyue.utils.DataGrid;
import com.wjs.tianyue.utils.Message;

@Controller
public class SupliterControl {

	@Autowired
	private SupliterService supliterService;

	@ResponseBody
	@RequestMapping("/getDataGrid")
	public DataGrid getDataGrid(Tb_Supliter sup, int page, int rows){
		return this.supliterService.getDataGrid(sup,page,rows);
	}
	
	@ResponseBody
	@RequestMapping("/insert/sup")
	public Message insert(Tb_Supliter sup){
		return this.supliterService.insertSupliter(sup);
	}
	
	@ResponseBody
	@RequestMapping("/updata/sup")
	public Message updata(Tb_Supliter sup){
		return this.supliterService.updataSupliterById(sup);
	}
	@ResponseBody
	@RequestMapping("/delete/sup")
	public Message delete(Integer id){
		return this.supliterService.deleteSupliterById(id);
	}
	@ResponseBody
	@RequestMapping("/export/sup")
	public Message export(HttpServletRequest request,HttpServletResponse response){
		return this.supliterService.export(request, response);
	}
	

}
