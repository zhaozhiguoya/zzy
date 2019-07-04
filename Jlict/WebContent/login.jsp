<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<div id="title">
	信息与控制工程学院后台管理系统登录页面
</div>
	<form action="UserServlet?flag=login" method="post">
	  <input type="text" placeholder="用户名" name="username" /><br><br>
	  <input type="password" placeholder="密码" name="password" /><br><br>
	  <div id="mess">${mess }</div>
	  <input type="submit" value="登  录" class="btn" />
	</form>
</body>
</html>