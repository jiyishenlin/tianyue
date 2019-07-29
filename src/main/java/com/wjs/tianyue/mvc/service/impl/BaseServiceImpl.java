package com.wjs.tianyue.mvc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjs.tianyue.mvc.mapper.Tb_LogMapper;
import com.wjs.tianyue.mvc.mapper.Tb_UserMapper;
import com.wjs.tianyue.mvc.pojo.Tb_Log;
import com.wjs.tianyue.mvc.pojo.Tb_User;
import com.wjs.tianyue.mvc.service.BaseService;
import com.wjs.tianyue.utils.DataGrid;
import com.wjs.tianyue.utils.Message;
@Service
public class BaseServiceImpl implements BaseService {

	@Autowired
	private Tb_UserMapper tb_UserMapper;
	@Autowired
	private Tb_LogMapper tb_LogMapper;
	
	public Message login(Tb_User user,HttpSession session,HttpServletRequest request) {
		Message m = new Message();
		List<Tb_User> userList = this.tb_UserMapper.login(user);
		if(userList.size()>0){
			m.setSuccess(true);
			session.setAttribute("current_user", userList.get(0));
			String ip = request.getHeader("Host");
			Tb_Log log  = new Tb_Log();
			log.setIp(ip);
			log.setTime(date2String(new Date()));
			log.setUsername(userList.get(0).getUsername());
			tb_LogMapper.insertSelective(log);
		}else{
			m.setSuccess(false);
		}
		return m;
	}


	public DataGrid getlog(int page, int rows) {
		DataGrid dg = new DataGrid();
		PageHelper.startPage(page, rows);
		List<Tb_Log> list = this.tb_LogMapper.getlog();
		PageInfo<Tb_Log> info = new PageInfo<Tb_Log>(list);
		info.getTotal();
		dg.setTotal(info.getTotal());
		dg.setRows(info.getList());
		return dg;
	}
	private String date2String(Date date){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String format = f.format(date);
		return format;
	}

}
