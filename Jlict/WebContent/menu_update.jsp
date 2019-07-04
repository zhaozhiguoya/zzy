<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/selectFilter.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/table.js" charset="gb2312"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>
<style type="text/css">
	form{float: left;margin-left: 18px;margin-top: 15px;}
	
</style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<section>
<div class="dirbox">
	<span>菜单管理&nbsp;&nbsp;>&nbsp;&nbsp;修改菜单</span>
	</div>
 <form action="MenuServlet?flag=update&id=${smenu.id }" method="post" id="addform" class="alertDiv-add">
           <input type="text" placeholder="${smenu.title }" name="title" required id="title" style="width: 240px;height: 35px;"/><br/><br/> 
           	<label>是否有上级菜单</label><br><br>
           	<select id="s_menu" name="select">
           		<option value="0">无</option>
           		<c:forEach items="${menu }" var="m" >
           		<option value="${m.id }">${m.title }</option>
           		</c:forEach>
           	</select>

           	<br><br>
			<input type="submit" value="修    改" class="btn" id="btn"/>
			<input type="reset" value="取     消" class="btn" />
</form>
</section>
</body>
</html>