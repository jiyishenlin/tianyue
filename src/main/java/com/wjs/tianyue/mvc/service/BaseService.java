package com.wjs.tianyue.mvc.service;

import javax.servlet.http.HttpSession;

import com.wjs.tianyue.mvc.pojo.Tb_User;
import com.wjs.tianyue.utils.Message;

public interface BaseService {

	Message login(Tb_User user, HttpSession session);

	

}
