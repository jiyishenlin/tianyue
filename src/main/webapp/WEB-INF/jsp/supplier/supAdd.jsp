<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

</head>
<body>
<div id="add_form_div" style="width:300px;height:300px;margin: 30px auto;">
<form id="add_form" method="post">
	<table>
			<tr>
				<th></th>
				<td><input id="id" class="easyui-textbox" type="hidden" name="id" value="${sup.id }" data-options="" /></td>
			</tr>
			<tr>
				<th><label for="supname">供应商公司名称:</label></th>
				<td><input class="easyui-textbox" type="text" name="supname" value="${sup.supname }" data-options="" /></td>
			</tr>
			<tr>
				<th><label for="supaddr">供应商公司地址:</label></th>
				<td><input class="easyui-textbox" type="text" name="supaddr" value="${sup.supaddr }"  data-options="" /></td>
			</tr>
			<tr>
				<th><label for="name">联系人名称:</label></th>
				<td><input class="easyui-textbox" type="text" name="name" value="${sup.name }" data-options="" /></td>
			</tr>
			<tr>
				<th><label for="emil">联系人邮箱:</label></th>
				<td><input class="easyui-textbox" type="text" name="emil" value="${sup.name }" data-options="" /></td>
			</tr>
			<tr>
				<th><label for="tel">联系人电话:</label></th>
				<td><input class="easyui-textbox" type="text" name="tel" value="${sup.tel }" data-options="" /></td>
			</tr>
			<tr>
				<th><label for="oth_tel">其他联系方式:</label></th>
				<td><input class="easyui-textbox" type="text" name="oth_tel" value="${sup.tel }" data-options="" /></td>
			</tr>
			<tr>
				<td></td><td></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:void(0)" onclick="saveform();" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保 存</a></td>
			</tr>
	</table>
</form>
</div>

</body>
</html>