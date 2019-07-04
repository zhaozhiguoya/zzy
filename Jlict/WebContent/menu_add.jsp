<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/selectFilter.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<style type="text/css">
	form{float: left;margin-left: 18px;margin-top: 15px;}
	select{width: 240px;height: 35px;}
</style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<section>
<div class="dirbox">
	<span>菜单管理&nbsp;&nbsp;>&nbsp;&nbsp;添加菜单</span>
	</div>
 <form action="MenuServlet?flag=add" method="post" id="addform" class="alertDiv-add">
           <input type="text" placeholder="标题" name="title" required id="title" style="width: 240px;height: 35px;"/><br/><br/> 
           	<label>是否有上级菜单</label><br><br>
           	<select id="s_menu" name="select">
           		<option value="0">无</option>
           		<c:forEach items="${menu }" var="m" >
           		<option value="${m.id }">${m.title }</option>
           		</c:forEach>
           	</select>

           	<br><br>
			<input type="submit" value="增    加" class="btn" id="btn"/>
			<input type="reset" value="取     消" class="btn" />
</form>
</section>
</body>
</html>