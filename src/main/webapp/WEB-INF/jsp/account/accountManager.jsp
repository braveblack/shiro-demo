<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>账号管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/themes/icon.css">

</head>
<body style="margin: 1px;">
	
<div id="tb">
	<div>
		<a href="javascript:shootingAdd()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
		<a href="javascript:shootingUpdate()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
		<a href="javascript:deleteShooting()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	</div>
	<div>
		 &nbsp;拍摄计划：&nbsp;<input type="text" name="s_shootingTitle" id="s_shootingTitle" size="10"/>
		  &nbsp;上线时间：&nbsp;<input type="text" name="s_onlineDate" id="s_onlineDate" size="10"/>
		 &nbsp;主讲教师：&nbsp;<input type="text" name="s_teacherName" id="s_teacherName" size="10"/>
		<a href="javascript:reloadGrid()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
	</div>
</div>
	<table id="datagrid" ></table> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js">
</script>
<script type="text/javascript">
$(function(){
	$("#datagrid").datagrid({
		loadMsg: '数据正在努力加载...',
		url:"${pageContext.request.contextPath}/account/listAccount",
	    idField:'id',    
	    iconCls:"icon-userManage",
		pagination:true,
		pageSize:20,
		rownumbers:true,
 		fitColumns:true,
		nowrap:false,
		broder:true,
		autoRowHeight:true,
		toolbar: '#tb',
		columns:[[
		 {field:'ck',checkbox:true},
		 {title:"名字",  field:"username", width:40},
		 {title:"所属公司",  field:"organizationId", width:40},
		 {title:"角色",field:"roleIds",width:40}
		 ]]
	});
	$('#datagrid').datagrid({
		toolbar: '#tb'
	});	
});
</script>
</body>
</html>