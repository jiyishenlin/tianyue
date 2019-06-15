package com.wjs.tianyue.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjs.tianyue.mvc.mapper.Tb_SupliterMapper;
import com.wjs.tianyue.mvc.pojo.Tb_Supliter;
import com.wjs.tianyue.mvc.service.SupliterService;
import com.wjs.tianyue.utils.DataGrid;
import com.wjs.tianyue.utils.ExportExcel;
import com.wjs.tianyue.utils.Message;
@Service
public class SupliterServiceImpl implements SupliterService {

	@Autowired
	private Tb_SupliterMapper tb_SupliterMapper;
	

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

	public Tb_Supliter selectByPrimaryKey(Integer id) {
		
		return this.tb_SupliterMapper.selectByPrimaryKey(id);
	}

	public Message insertSupliter(Tb_Supliter sup) {
		Message mg = new Message();
		int row = this.tb_SupliterMapper.insertSelective(sup);
		if(row > 0){
			mg.setSuccess(true);
			mg.setMessage("新增成功！");
		}else{
			mg.setSuccess(false);
			mg.setMessage("新增失败！");
		}
		return mg;
	}

	public Message updataSupliterById(Tb_Supliter sup) {
		Message mg = new Message();
		int row = this.tb_SupliterMapper.updateByPrimaryKey(sup);
		if(row > 0){
			mg.setSuccess(true);
			mg.setMessage("修改成功！");
		}else{
			mg.setSuccess(false);
			mg.setMessage("修改失败！");
		}
		return mg;
	}

	public Message deleteSupliterById(Integer id) {
		
		Message mg = new Message();
		int row = this.tb_SupliterMapper.deleteByPrimaryKey(id);
		if(row > 0){
			mg.setSuccess(true);
			mg.setMessage("删除成功！");
		}else{
			mg.setSuccess(false);
			mg.setMessage("删除失败！");
		}
		return mg;
	}

	public List<Tb_Supliter> getSupliterList(int start, int size) {
		
		return this.tb_SupliterMapper.getSupliterList(start,size);
	}

	public Message export(HttpServletRequest request, HttpServletResponse response) {
		Message ms = new Message();
		List<Tb_Supliter> list = this.tb_SupliterMapper.getSupliterList(0, 100);
		
        List<List<String>> all = new ArrayList<List<String>>();
        for(int i = 0; i<list.size();i++){
        	List<String> title = new ArrayList<String>();
        	title.add(list.get(i).getId().toString());
        	title.add(list.get(i).getSupname());
        	title.add(list.get(i).getSupaddr());
        	title.add(list.get(i).getName());
        	title.add(list.get(i).getTel());
        	all.add(title);
        }
    	String[] cell = {"序号","供应商公司名称","供应商公司地址","联系人名称","联系人电话"};
        String succ = ExportExcel.ExprotExcelXLSX("供应商名单", cell, all);
        if("succ".equals(succ)){
        	ms.setSuccess(true);
        	ms.setMessage("导出成功！");
        }else{
        	ms.setSuccess(false);
        	ms.setMessage(succ);
        }
        return ms;
	}

}
