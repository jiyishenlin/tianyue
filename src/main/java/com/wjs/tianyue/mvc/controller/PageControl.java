package com.wjs.tianyue.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjs.tianyue.mvc.pojo.Tb_Supliter;
import com.wjs.tianyue.mvc.service.SupliterService;

@Controller
public class PageControl {
	
	
	@Autowired
	private SupliterService supliterService;

	@RequestMapping("/")
	public String firstPage(){
		return "/WEB-INF/jsp/base/first.jsp";
	}
	@RequestMapping("/base/index")
	public String index(){
		return "/WEB-INF/jsp/base/index.jsp";
	}
	
	@RequestMapping("/base/{path}")
	public String base(@PathVariable String path){
		return "/WEB-INF/jsp/base/"+path+".jsp";
	}
	@RequestMapping("/buy/{path}")
	public String buy(@PathVariable String path){
		return "/WEB-INF/jsp/buy/"+path+".jsp";
	}
	@RequestMapping("/cust/{path}")
	public String cust(@PathVariable String path){
		return "/WEB-INF/jsp/cust/"+path+".jsp";
	}
	@RequestMapping("/sup/{path}")
	public String supplier(@PathVariable String path,String id,HttpServletRequest request){
		if(id != null && !"".equals(id)){
			Tb_Supliter sup = this.supliterService.selectByPrimaryKey(Integer.valueOf(id));
			request.setAttribute("sup", sup);
		}
		return "/WEB-INF/jsp/supplier/"+path+".jsp";
	}
	@RequestMapping("/finance/{path}")
	public String finance(@PathVariable String path){
		return "/WEB-INF/jsp/finance/"+path+".jsp";
	}
	@RequestMapping("/mater/{path}")
	public String mater(@PathVariable String path){
		return "/WEB-INF/jsp/mater/"+path+".jsp";
	}
	@RequestMapping("/sell/{path}")
	public String sell(@PathVariable String path){
		return "/WEB-INF/jsp/sell/"+path+".jsp";
	}
	@RequestMapping("/stock/{path}")
	public String stock(@PathVariable String path){
		return "/WEB-INF/jsp/stock/"+path+".jsp";
	}
	@RequestMapping("/bom/{path}")
	public String bom(@PathVariable String path){
		return "/WEB-INF/jsp/bom/"+path+".jsp";
	}
	@RequestMapping("/report/{path}")
	public String report(@PathVariable String path){
		return "/WEB-INF/jsp/report/"+path+".jsp";
	}
	@RequestMapping("/game/{path}")
	public String game(@PathVariable String path){
		return "/WEB-INF/jsp/game/"+path+".jsp";
	}
}
