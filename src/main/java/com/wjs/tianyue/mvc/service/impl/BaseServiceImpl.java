package com.wjs.tianyue.mvc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjs.tianyue.mvc.mapper.Tb_UserMapper;
import com.wjs.tianyue.mvc.pojo.Tb_User;
import com.wjs.tianyue.mvc.service.BaseService;
import com.wjs.tianyue.utils.Message;
@Service
public class BaseServiceImpl implements BaseService {

	@Autowired
	private Tb_UserMapper tb_UserMapper;
	
	
	public Message login(Tb_User user,HttpSession session) {
		Message m = new Message();
		List<Tb_User> userList = this.tb_UserMapper.login(user);
		if(userList.size()>0){
			m.setSuccess(true);
			session.setAttribute("current_user", userList.get(0));
		}
		return m;
	}


}
