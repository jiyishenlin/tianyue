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

</head>
<body>
<div style="height:50px;width:100%; line-height: 50px;">
    <div style="height:49px;width:100%;">
        <label for="name">供应商名称:</label>
        <input id="supname" class="easyui-textbox" name="supname"  style="width:200px;">
        <label for="name">订单时间:</label>
        <input id="order_time_s" type="text" class="easyui-datebox" > --
        <input id="order_time_e" type="text" class="easyui-datebox" >
        <a id="btn" href="javascript:void(0)" onclick="getMaterGrid();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查 询</a>
    </div>
</div>
<table id="mater_table" class="easyui-datagrid" style="width:100%;height:430px"
        data-options="pageNumber:1,pageSize:10,pageList:[10,20,30,40],pagination:true,fitColumns:true,singleSelect:true,rownumbers:true">
    <thead>
        <tr>
            <th data-options="field:'ok',checkbox:true"></th>
            <th data-options="field:'id',hidden:true"></th>
            <th data-options="field:'supname',width:200">名称</th>
            <th data-options="field:'supaddr',width:200">编码</th>
            <th data-options="field:'order_name',width:150">参数</th>
            <th data-options="field:'order_time',width:150">数量</th>
            <th data-options="field:'delivery_time',width:150">预计收货时间</th>
            <th data-options="field:'remarks',width:150">备注</th>
            <th data-options="field:'status',width:150">状态</th>
        </tr>
    </thead>
</table>
</body>
</html>