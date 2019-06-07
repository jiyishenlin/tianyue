package com.wjs.tianyue.mvc.mapper;

import java.util.List;

import com.wjs.tianyue.mvc.pojo.Tb_User;

public interface Tb_UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tb_User record);

    int insertSelective(Tb_User record);

    Tb_User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tb_User record);

    int updateByPrimaryKey(Tb_User record);
//////////////////////////////////////////////////
	List<Tb_User> login(Tb_User user);
}