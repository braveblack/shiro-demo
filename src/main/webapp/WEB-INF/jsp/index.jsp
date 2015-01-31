<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/themes/icon.css">
</head>
<body  class="easyui-layout">
<div region="north" style="height: 70px;">
<div style="padding: 0px;margin: 0px;background-color: #E0ECFF;">
<table>
	<tr>
		<td><img src="${pageContext.request.contextPath}/static/images/mainlogo.png"/></td>
		<td valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎[<shiro:principal/>]学习Shiro综合案例&nbsp;</td>
	</tr>
</table>
</div>
</div>
<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div title="首页" data-options="iconCls:'icon-home'">
			<div align="center" style="padding-top: 1px;"><img  src="${pageContext.request.contextPath}/static/images/bg.jpg" width="600" height="460"></div>
		</div>
	</div>
</div>
<div region="west" style="width: 160px;padding: 5px;" title="导航菜单" split="true">
<ul id="tree" class="easyui-tree"></ul>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js">
</script>
<script type="text/javascript">
$(function(){
	$("#tree").tree({
		lines:true,
		url:'${pageContext.request.contextPath}/menu/listMenu',
		onLoadSuccess:function(){
			$("#tree").tree('expandAll');
		},
		onClick:function(node){
			 if(node.attributes.authPath){
				openTab(node);
			}
		}
	});
	function openTab(node){
		if($("#tabs").tabs("exists",node.text)){
			$("#tabs").tabs("select",node.text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src=${pageContext.request.contextPath}"+node.attributes.authPath+"></iframe>"
			$("#tabs").tabs("add",{
				title:node.text,
				iconCls:node.iconCls,
				closable:true,
				content:content
			});
		}
	}
})
	
</script>
</body>
</html>