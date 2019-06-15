package com.wjs.tianyue.mvc.mapper;

import java.util.List;

import com.wjs.tianyue.mvc.pojo.Tb_Supliter;

public interface Tb_SupliterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tb_Supliter record);



    int updateByPrimaryKeySelective(Tb_Supliter record);

/////////////////////////////////////////////////////////////////
    int insertSelective(Tb_Supliter record);
    int updateByPrimaryKey(Tb_Supliter record);
	List<Tb_Supliter> getDataGrid(Tb_Supliter sup);

	Tb_Supliter selectByPrimaryKey(Integer id);

	List<Tb_Supliter> getSupliterList(int start, int size);
}