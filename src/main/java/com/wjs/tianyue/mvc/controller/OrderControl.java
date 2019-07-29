package com.wjs.tianyue.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjs.tianyue.mvc.pojo.Tb_Order;
import com.wjs.tianyue.mvc.service.OrderService;
import com.wjs.tianyue.utils.DataGrid;

@Controller
public class OrderControl {

	@Autowired
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping("/getOrderGrid")
	public DataGrid getOrderList(Tb_Order tb_order, int page, int rows){
		return this.orderService.getOrderList(tb_order,page,rows);
	}
}
