package com.wjs.tianyue.mvc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjs.tianyue.mvc.mapper.Tb_MenuMapper;
import com.wjs.tianyue.mvc.mapper.Tb_SupliterMapper;
import com.wjs.tianyue.mvc.mapper.Tb_UserMapper;
import com.wjs.tianyue.mvc.pojo.Tb_Menu;
import com.wjs.tianyue.mvc.pojo.Tb_Supliter;
import com.wjs.tianyue.mvc.pojo.Tb_User;
import com.wjs.tianyue.mvc.service.BaseService;
import com.wjs.tianyue.utils.DataGrid;
import com.wjs.tianyue.utils.Message;
@Service
public class BaseServiceImpl implements BaseService {

	@Autowired
	private Tb_UserMapper tb_UserMapper;
	@Autowired
	private Tb_MenuMapper tb_MenuMapper;
	@Autowired
	private Tb_SupliterMapper tb_SupliterMapper;
	public Message login(Tb_User user,HttpSession session) {
		Message m = new Message();
		List<Tb_User> userList = this.tb_UserMapper.login(user);
		if(userList.size()>0){
			m.setSuccess(true);
			session.setAttribute("current_user", userList.get(0));
		}
		return m;
	}
	public Message getUrl(Tb_Menu tb_menu) {
		System.out.println(tb_menu.getTitle());
		Message mes = new Message();
		String url = this.tb_MenuMapper.getUrl(tb_menu);
		if(url != null){
			mes.setSuccess(true);
			mes.setMessage(url);
		}
		return mes;
	}
	public DataGrid getDataGrid(Tb_Supliter sup, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<Tb_Supliter> list = this.tb_SupliterMapper.getDataGrid(sup);
		PageInfo<Tb_Supliter> info = new PageInfo<Tb_Supliter>(list);
		long total = info.getTotal();
		List<Tb_Supliter> list2 = info.getList();
		DataGrid dg = new DataGrid();
		dg.setTotal(total);
		dg.setRows(list2);
		return dg;
	}

}
