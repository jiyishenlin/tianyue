package com.wjs.tianyue.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjs.tianyue.mvc.mapper.Tb_OrderMapper;
import com.wjs.tianyue.mvc.pojo.Tb_Order;
import com.wjs.tianyue.mvc.pojo.Tb_Supliter;
import com.wjs.tianyue.mvc.service.OrderService;
import com.wjs.tianyue.utils.DataGrid;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private Tb_OrderMapper tb_OrderMapper;
	
	public DataGrid getOrderList(Tb_Order tb_order, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<Tb_Supliter> list = this.tb_OrderMapper.getOrderList(tb_order);
		
		PageInfo<Tb_Supliter> info = new PageInfo<Tb_Supliter>(list);
		long total = info.getTotal();
		List<Tb_Supliter> list2 = info.getList();
		DataGrid dg = new DataGrid();
		dg.setTotal(total);
		dg.setRows(list2);
		return dg;
	}

}
