<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
	
		<shiro:hasPermission name="user:*">  
			<a href="javascript:accountSave()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
<%-- 		<shiro:hasAnyRoles name="超级管理员,用户管理员"> --%>
			<a href="javascript:accountUpdate()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:accountDel()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
<%-- 		</shiro:hasAnyRoles> --%>
	</shiro:hasPermission> 
	</div>
	<div>
		 &nbsp;账号：&nbsp;<input type="text" name="s_shootingTitle" id="s_shootingTitle" size="10"/>
		  &nbsp;公司：&nbsp;<input type="text" name="s_onlineDate" id="s_onlineDate" size="10"/>
		 &nbsp;角色：&nbsp;<input type="text" name="s_teacherName" id="s_teacherName" size="10"/>
		<a href="javascript:reloadGrid()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
	</div>
</div>
	<table id="datagrid" ></table> 
<!-- data-options="onBeforeClose:function(){ resetValue();}" -->
	<div id="dlg" class="easyui-dialog" style="width: 770px;height: 450px;padding: 10px 30px"
  			closed="true" buttons="#dlg-buttons" data-options="onBeforeClose:function(){ resetValue();}">
  		<form action="" id="accountForm">
	  		用 户 名：<input type="text" id="username"name="username" class="easyui-validatebox"  required="true" missingMessage="不能为空"><br/><br/>
	  		密&nbsp;&nbsp;&nbsp;&nbsp;码：<input  type="password" id="pwd" style="display:none" name="password" class="easyui-validatebox"  required="true" validtype="length[8,20]" invalidMessage="有效长度8-20" ><br/><br/>
	  		所属公司：<select id="company" name="organizationId" class="easyui-combobox"  name="dept" style="width:200px;">
					</select><br/><br/>
			分配角色：<select id="role" name="roleId" class="easyui-combobox" name="dept" data-options="multiple:true,panelHeight:'auto'" style="width:200px;">
					</select><br/>
			<p id="errorMsg"></p>
			<button type="submit" id="accountCommit">提交</button>
			<button type="button" id="accountColse">关闭</button>
  		</form>
  	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	$("#datagrid").datagrid({
		fit:true,
		loadMsg: '数据正在努力加载...',
		url:"${pageContext.request.contextPath}/account/listAccount",
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
		 {title:"名字",  field:"username", width:40},
		 {title:"所属公司",  field:"organizationName", width:40},
		 {title:"角色",field:"listRole",width:40,
			 formatter:function(value,row,index){
				 var s="";
				 for (var i=0;i<value.length;i++) {
					s=s+value[i].role+";";
				 }
				 return s;
			 }
		 }]]
	});
	$("#company").combobox({
		 url:"${pageContext.request.contextPath}/company/listCompany", 
		 valueField:'id',   
	     textField:'name',
	     value:"请选择..."  //默认选中value指定的选项
	});	
	$("#role").combobox({
		 url:"${pageContext.request.contextPath}/role/listRole", 
		 valueField:'id',   
	     textField:'role',
// 	     value:"请选择..."  //默认选中value指定的选项
	});
	function mySubmit(flag){  
	    return flag;  
	}  
	$("#accountCommit").click(function(){
		$("#accountForm").submit(function(){
		    if(checkCombobox()&&$("#accountForm").form('validate')){  
		        return mySubmit(true);  
		    }else{  
		        return mySubmit(false);  
		    } 
		});
	});
	$("#accountColse").click(function(){
		resetValue();		
		$('#dlg').window('close');
	})
	
});	
	function accountSave(){
		$("#dlg").dialog("open").dialog("setTitle","添加账号信息");
		$("#pwd").show();
		$("#accountForm").attr("action","${pageContext.request.contextPath}/user/userSave");
	}
	function accountUpdate(){
		$("#pwd").hide();
		var selectedRows=$("#datagrid").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert('系统提示','请选择1条数据');
			return;
		}
		$("#dlg").dialog("open").dialog("setTitle","修改账号信息");
		var row=selectedRows[0];
		$("#username").val(row.username);
		$("#pwd").val("xxxxxxxxx");
 		$("#company").combobox("setValue",row.organizationId);
 		var strIds=[];
 		for(var i=0;i<row.listRole.length;i++){
 			strIds.push(row.listRole[i].id);
 		}
 		$("#role").combobox("setValues",strIds);
 		$("#accountForm").attr("action","${pageContext.request.contextPath}/user/userUpdate");
	}
	function checkCombobox(){
		var c=$('#company').combobox('getValue');
		var r=$('#role').combobox('getValue');
		if(c=="请选择..."||typeof(c)=="undifined"||r=="请选择..."||typeof(r)=="undifined"){
			$("#errorMsg").text("请勾选下拉框内容");
			return false;
		}
		return true;
	}
	function resetValue(){
		$("#username").val('');
		$("#pwd").val('');
		$("#company").combobox("setValue",'');
		$("#role").combobox("setValues",'');
		$("#accountForm").form('load','');
	}
</script>
</body>
</html>