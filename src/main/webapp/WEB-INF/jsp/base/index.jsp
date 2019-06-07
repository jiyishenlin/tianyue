<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERP管理系统界面</title>
<link rel="stylesheet" type="text/css" href="/tool/easyui-1.7/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="/tool/easyui-1.7/themes/icon.css">
<script type="text/javascript" src="/tool/easyui-1.7/jquery.min.js"></script>
<script type="text/javascript" src="/tool/easyui-1.7/jquery.easyui.min.js"></script>
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}

body {
	padding: 0px;
}

#west>div>div {
	overflow: auto;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#west div div ul li").on("click", function() {
			var id = $(this).find("div").attr("id");
			var title = $(this).find("span[class='tree-title']").text();
			var flag = $('#center_tab').tabs('exists', title);
			if (!flag) {
				$.ajax({
					url : "/getUrl",
					data : "title=" + id,
					type : "post",
					//async : false,
					success : function(data) {
						if (data.success) {
							url = data.message;
							console.log(url);
						} else {
							title = "err";
						}
						$('#center_tab').tabs('add', {
							title : title,
							content:createFrame(url),
							closable : true
						});
					}
				});
			} else {
				$('#center_tab').tabs('select', title);
			}
		});
	});
	function createFrame(url) {
		var s = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';
		return s;
	}
</script>
</head>
<body>
	<div id="main" class="easyui-layout" style="width: 100%; height: 610px;">
		<div id="north" data-options="region:'north'" style="height: 50px"></div>
		<div id="west" data-options="region:'west',split:true" title="菜单导航" style="width: 200px;">
			<div class="easyui-accordion" style="width: 190px; height: 100%">
				<div title="采购管理" data-options="iconCls:'icon-ok'">
					<ul class="easyui-tree">
						<li class="list_li" name="buymager">采购管理</li>
					</ul>
				</div>
				<div title="原料管理" data-options="iconCls:'icon-help'">
					<ul class="easyui-tree">
						<li class="list_li" name="matermager">原料管理</li>
					</ul>
				</div>
				<div title="销售管理" data-options="iconCls:'icon-help'">
					<ul class="easyui-tree">
						<li class="list_li" name="sellmager">销售管理</li>
					</ul>
				</div>
				<div title="库存管理" data-options="iconCls:'icon-help'">
					<ul class="easyui-tree">
						<li class="list_li" name="stockmater">库存原料</li>
						<li class="list_li" name="stockproduct">合格产品</li>
						<li class="list_li" name="stockrepair">不合格产品</li>
					</ul>
				</div>
				<div title="报表管理" data-options="iconCls:'icon-help'">
					<ul class="easyui-tree">
						<li class="list_li" name="report">报表管理</li>
					</ul>
				</div>
				<div title="财务管理" data-options="">
					<ul class="easyui-tree">
						<li class="list_li" name="finance">财务管理</li>
					</ul>
				</div>
				<div title="BOM管理" data-options="iconCls:'icon-search'">
					<ul class="easyui-tree">
						<li class="list_li" name="bommager">BOM管理</li>
					</ul>
				</div>
				<div title="供应商管理" data-options="iconCls:'icon-search'">
					<ul class="easyui-tree">
						<li class="list_li" name="supmager">供应商管理</li>
					</ul>
				</div>
				<div title="客户管理" data-options="iconCls:'icon-help'">
					<ul class="easyui-tree">
						<li class="list_li" name="jzmdisp">青岛吉之美</li>
						<li class="list_li" name="tcldisp">即墨TCL</li>
					</ul>
				</div>
				<div title="基础管理" data-options="iconCls:'icon-help'">
					<ul class="easyui-tree">
						<li class="list_li" name="usermager">用户管理</li>
						<li class="list_li" name="powerset">权限设置</li>
						<li class="list_li" name="rolemager">角色管理</li>
						<li class="list_li" name="logmager">日志管理</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="center" data-options="region:'center'">
			<div id="center_tab" class="easyui-tabs" style="width: 100%; height: 100%">
				<div title="首页" style="padding: 10px"></div>
				<div title="Help" data-options="iconCls:'icon-help',closable:true" style="padding: 10px">This is the help
					content.</div>
			</div>
		</div>
	</div>

</body>
</html>