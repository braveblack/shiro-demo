<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<style type="text/css">.error{color:red;}</style>
</head>
<body>
	<div class="error">${error} </div>
	<form action="" method="post">
		帐号：<input type="text" name="username" value=""><br/>
		密码：<input type="password" name="password"><br/>
		<input type="submit" value="登录">
	</form>
</body>
</html>