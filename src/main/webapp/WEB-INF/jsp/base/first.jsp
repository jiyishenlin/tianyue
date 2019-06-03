<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="tool/easyui-1.7/themes/black/easyui.css">
<link rel="stylesheet" type="text/css" href="tool/easyui-1.7/themes/icon.css">
<script type="text/javascript" src="tool/easyui-1.7/jquery.min.js"></script>
<script type="text/javascript" src="tool/easyui-1.7/jquery.easyui.min.js"></script>
<style type="text/css">
body{text-align:center} 
#login-form{
width:450px;
height:400px;
margin:  auto;
margin-top:10%;
}
</style>
</head>
<body>
<div id="login-form">
	<div  class="easyui-panel" title="登 录" style="width: 400px; max-width: 400px; padding: 30px 60px;">
		<form id="login" method="post">
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" prompt="用户名" iconWidth="28" style="width: 100%; height: 34px; padding: 10px;">
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-passwordbox" prompt="密码" iconWidth="28" style="width: 100%; height: 34px; padding: 10px">
			</div>
		</form>
		<div style="text-align: center; padding: 5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 100%">登录</a> 
		</div>
	</div>
	</div>
</body>
</html>