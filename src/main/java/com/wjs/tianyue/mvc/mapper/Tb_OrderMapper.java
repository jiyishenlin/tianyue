package com.wjs.tianyue.mvc.mapper;

import java.util.List;

import com.wjs.tianyue.mvc.pojo.Tb_Order;
import com.wjs.tianyue.mvc.pojo.Tb_Supliter;

public interface Tb_OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tb_Order record);

    int insertSelective(Tb_Order record);

    Tb_Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tb_Order record);

    int updateByPrimaryKey(Tb_Order record);

	List<Tb_Supliter> getOrderList(Tb_Order tb_order);
}