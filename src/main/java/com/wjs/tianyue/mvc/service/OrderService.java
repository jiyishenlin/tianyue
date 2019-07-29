package com.wjs.tianyue.mvc.service;

import com.wjs.tianyue.mvc.pojo.Tb_Order;
import com.wjs.tianyue.utils.DataGrid;

public interface OrderService {

	DataGrid getOrderList(Tb_Order tb_order, int page, int rows);

}
