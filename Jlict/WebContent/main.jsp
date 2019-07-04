<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tree.js"></script>
</head>
<body>
	<div id="header">
		<img id="header_logo" src="${pageContext.request.contextPath }/img/logo.png" />
		<div id="header_title">信息与控制工程学院后台管理系统</div>
		<div id="header_title_E">College of Information and Control Engineering Background Management System</div>
		<img id="header_img" src="${pageContext.request.contextPath }/img/timg.png" />
		<span id="header_name">${user.username }</span>
	</div>
	<div id="inner">
		<div id="inner_left">
			<ul>
			<li><a href="UserServlet?flag=findAll">用户管理</a></li>
			<li><a href="MenuServlet?flag=findAll">菜单管理</a></li>
			<li><a href="SubmenuServlet?flag=findAll">子菜单管理</a></li>
			
			<!-- <li><a class="ina"><span>菜单管理</span></a>
				<ul style="display: none">
					<li><a href="MenuServlet?flag=findAll">查看菜单</a></li>				
					<li><a href="menu_add.jsp">添加菜单</a></li>				
				</ul> 
			</li>
			<li><a class="ina"><span>子菜单管理</span></a>
				<ul style="display: none">
					<li><a href="SubmenuServlet?flag=findAll">查看菜单</a></li>				
					<li><a href="menu_add.jsp">添加菜单</a></li>				
				</ul> 
			</li> -->
			</ul>
		</div>
		<div id="inner_right"></div>
	</div>
</body>
</html>