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
<table id="mater_table" class="easyui-datagrid" style="width:100%;height:430px"
        data-options="url:'${contextpath }/getlogs',pageNumber:1,pageSize:10,pageList:[10,20,30,40],pagination:true,fitColumns:true,singleSelect:true,rownumbers:true">
    <thead>
        <tr>
            <th data-options="field:'id',hidden:true"></th>
            <th data-options="field:'username',width:200">用户名</th>
            <th data-options="field:'type',width:200">类型</th>
            <th data-options="field:'ip',width:150">ip</th>
            <th data-options="field:'remark',width:150">备注</th>
            <th data-options="field:'status',width:150">状态</th>
            <th data-options="field:'operation',width:150">操作</th>
        </tr>
    </thead>
</table>
</body>
</html>