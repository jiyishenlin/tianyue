package com.wjs.tianyue.mvc.mapper;

import com.wjs.tianyue.mvc.pojo.Tb_Menu;

public interface Tb_MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tb_Menu record);

    int insertSelective(Tb_Menu record);

    Tb_Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tb_Menu record);

    int updateByPrimaryKey(Tb_Menu record);

    String getUrl(Tb_Menu tb_menu);
}