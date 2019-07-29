<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextpath }/tool/easyui-1.7/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="${contextpath }/tool/easyui-1.7/themes/icon.css">
<script type="text/javascript" src="${contextpath }/tool/easyui-1.7/jquery.min.js"></script>
<script type="text/javascript" src="${contextpath }/tool/easyui-1.7/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${contextpath }/tool/easyui-1.7/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	$('#order_table').datagrid({
		checkOnSelect:true,
		striped:true,
		toolbar: [{
			iconCls: 'icon-add',
			handler: function(){
				$('#addwin').window({
					title:"新增供应商信息",
				});
				$('#addwin').window('refresh', '${contextpath }/sup/supAdd');
				$('#addwin').window('open');
			}
		},'-',{
			iconCls: 'icon-edit',
			handler: function(){
				var obj = $('#sup_table').datagrid('getSelected');
				if(obj == null){
					$.messager.alert('警告','请先选择一行进行修改');
				}else{
					var id = obj.id;
					$('#addwin').window({
						title:"修改供应商信息",
					});
					$('#addwin').window('refresh', '${contextpath }/sup/supAdd?id='+id);
					$('#addwin').window('open');
				}
			}
		},'-',{
			iconCls: 'icon-cut',
			handler: function(){
				var obj = $('#sup_table').datagrid('getSelected');
				if(obj == null){
					$.messager.alert('警告','请先选择一行进行删除');
				}else{
					var id = obj.id;
					$.messager.confirm('警告','您确定要删除吗?',function(r){
					    if (r){
					        $.ajax({
					        	url:'${contextpath }/delete/sup?id='+id,
					        	success:function(data){
					        		$.messager.alert('信息',data.message);
					        		$('#sup_table').datagrid('reload'); 
					        	}
					        });
					    }
					});
				}
			}
		},'-',{
			iconCls: 'icon-excel',
			handler: function(){
				$.messager.confirm('确认对话框', '将要导出100条 ！', function(r){
					if (r){
						$.ajax({
							url:'${contextpath }/export/sup',
							success:function(data){
								if(data.success){
									$.messager.alert('信息',data.message);
								}else{
									$.messager.alert('信息',data.message);
								}
							}
						});
					}
				});
			}
		}]
	});
});
function getOrderGrid(){
	
	var supname = $("#supname").val();
	var orderTime_s = $("#orderTime_s").val();
	var orderTime_e = $("#orderTime_e").val();
	var param = "?supname="+supname+"&orderTime_s="+orderTime_s+"&orderTime_e="+orderTime_e;
	$('#order_table').datagrid({
		url:'${contextpath }/getOrderGrid?'+$("#Order_form").serialize(),
	});
}
</script>
</head>
<body>
<div style="height:50px;width:100%; line-height: 50px;">
    <div style="height:49px;width:100%;">
    <form id="Order_form">
        <label for="name">供应商名称:</label>
        <input id="supname" class="easyui-textbox" name="supname"  style="width:200px;">
        <label for="name">订单时间:</label>
        <input id="orderTime_s" type="text" class="easyui-datebox" name="orderTime_s"> --
        <input id="orderTime_e" type="text" class="easyui-datebox" name="orderTime_e">
        <a id="btn" href="javascript:void(0)" onclick="getOrderGrid();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查 询</a>
    </form>
    </div>
</div>
<table id="order_table" class="easyui-datagrid" style="width:100%;height:430px"
        data-options="pageNumber:1,pageSize:10,pageList:[10,20,30,40],pagination:true,fitColumns:true,singleSelect:true,rownumbers:true">
    <thead>
        <tr>
            <th data-options="field:'ok',checkbox:true"></th>
            <th data-options="field:'id',hidden:true"></th>
            <th data-options="field:'supname',width:200">供应商公司名称</th>
            <th data-options="field:'supaddr',width:200">供应商公司地址</th>
            <th data-options="field:'order_name',width:150">订单名称</th>
            <th data-options="field:'order_time',width:150">下订单时间</th>
            <th data-options="field:'delivery_time',width:150">预计收货时间</th>
            <th data-options="field:'remarks',width:150">备注</th>
            <th data-options="field:'status',width:150">状态</th>
        </tr>
    </thead>
</table>
</body>
</html>