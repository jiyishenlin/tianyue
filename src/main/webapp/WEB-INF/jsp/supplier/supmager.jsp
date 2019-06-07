<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERP管理系统界面</title>
<link rel="stylesheet" type="text/css" href="/tool/easyui-1.7/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="/tool/easyui-1.7/themes/icon.css">
<script type="text/javascript" src="/tool/easyui-1.7/jquery.min.js"></script>
<script type="text/javascript" src="/tool/easyui-1.7/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/tool/easyui-1.7/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
$(function(){
	$('#sup_table').datagrid({
		checkOnSelect:true,
		striped:true,
		emptyMsg:"您查询的数据为空",
		toolbar: [{
			iconCls: 'icon-edit',
			handler: function(){alert('edit')}
		},'-',{
			iconCls: 'icon-help',
			handler: function(){alert('help')}
		},'-',{
			iconCls: 'icon-add',
			handler: function(){alert('help')}
		}]
	});
});
function getDataGrid(){
	var supname = $("#supname").val();
	
	$('#sup_table').datagrid({
		url:'/getDataGrid?supname='+supname,
	});
}
</script>
</head>
<body>
<div style="height:50px;width:100%;">
    <div style="height:49px;width:500px;margin-left: 100px;">
        <label for="name">供应商名称:</label>
        <input id="supname" class="easyui-textbox" name="supname"  style="width:300px;margin-left: 100px">
        <a id="btn" href="javascript:void(0)" onclick="getDataGrid();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查 询</a>
    </div>
</div>
<table id="sup_table" class="easyui-datagrid" style="width:100%;height:430px"
        data-options="pageNumber:1,pageSize:10,pageList:[10,20,30,40],pagination:true,fitColumns:true,singleSelect:true,rownumbers:true">
    <thead>
        <tr>
            <th data-options="field:'supname',width:200">供应商公司名称</th>
            <th data-options="field:'supaddr',width:200">供应商公司地址</th>
            <th data-options="field:'name',width:150">联系人名称</th>
            <th data-options="field:'tel',width:150">联系人电话</th>
            <th data-options="field:'des',width:150">详情</th>
        </tr>
    </thead>
</table>
</body>
</html>