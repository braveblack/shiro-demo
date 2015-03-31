<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组织机构管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/themes/icon.css">
</head>
<body>
<div id="tb">
	<div>
		<shiro:hasAnyRoles name="超级管理员,用户管理员">
			<a href="javascript:accountSave()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:accountUpdate()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:accountDel()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</shiro:hasAnyRoles>
	</div>
</div>
<table id="datagrid" ></table> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		$("#datagrid").datagrid({
			fit:true,
			loadMsg: '数据正在努力加载...',
			url:"${pageContext.request.contextPath}/company/listCompany",
		    idField:'id',    
		    iconCls:"icon-userManage",
			pagination:true,
			pageSize:10,
			rownumbers:true,
	 		fitColumns:true,
			nowrap:false,
			broder:true,
			autoRowHeight:true,
			toolbar: '#tb',
			columns:[[
			 {field:'ck',checkbox:true},
			 {title:"名字",  field:"name", width:40}
			 ]]
		});
	})
</script>
</body>

</html>