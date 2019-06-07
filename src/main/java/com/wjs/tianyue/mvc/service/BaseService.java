package com.wjs.tianyue.mvc.service;

import javax.servlet.http.HttpSession;

import com.wjs.tianyue.mvc.pojo.Tb_Menu;
import com.wjs.tianyue.mvc.pojo.Tb_Supliter;
import com.wjs.tianyue.mvc.pojo.Tb_User;
import com.wjs.tianyue.utils.DataGrid;
import com.wjs.tianyue.utils.Message;

public interface BaseService {

	Message login(Tb_User user, HttpSession session);

	Message getUrl(Tb_Menu tb_menu);

	DataGrid getDataGrid(Tb_Supliter sup, int page, int rows);

}
