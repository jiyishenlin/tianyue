package com.wjs.tianyue.mvc.mapper;

import java.util.List;

import com.wjs.tianyue.mvc.pojo.Tb_Log;

public interface Tb_LogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tb_Log record);

    int insertSelective(Tb_Log record);

    Tb_Log selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tb_Log record);

    int updateByPrimaryKey(Tb_Log record);
    List<Tb_Log> getlog();
}