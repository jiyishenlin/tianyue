package com.wjs.tianyue.mvc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wjs.tianyue.mvc.pojo.Tb_Supliter;
import com.wjs.tianyue.utils.DataGrid;
import com.wjs.tianyue.utils.Message;

public interface SupliterService {

	

	DataGrid getDataGrid(Tb_Supliter sup, int page, int rows);
	
	Tb_Supliter selectByPrimaryKey(Integer integer);

	Message insertSupliter(Tb_Supliter sup);

	Message updataSupliterById(Tb_Supliter sup);

	Message deleteSupliterById(Integer id);

	List<Tb_Supliter> getSupliterList(int start, int size);

	Message export(HttpServletRequest request, HttpServletResponse response);
}
