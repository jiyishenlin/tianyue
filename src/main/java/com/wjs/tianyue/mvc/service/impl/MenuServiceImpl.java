package com.wjs.tianyue.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjs.tianyue.mvc.mapper.Tb_MenuMapper;
import com.wjs.tianyue.mvc.pojo.Tb_Menu;
import com.wjs.tianyue.mvc.service.MenuService;
import com.wjs.tianyue.utils.Message;
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private Tb_MenuMapper tb_MenuMapper;
	
	public Message getUrl(Tb_Menu tb_menu) {
		Message mes = new Message();
		String url = this.tb_MenuMapper.getUrl(tb_menu);
		if(url != null){
			mes.setSuccess(true);
			mes.setMessage(url);
		}
		return mes;
	}
}
