<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/user_list.css"  type="text/css" rel="styleSheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/table.js" charset="gb2312"></script> 
<style type="text/css">
	form{float: left;margin-left: 25px;margin-top: 20px;}
	select{width: 240px;height: 35px;}
}
</style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<section>
<div class="dirbox">
	<span>子菜单管理&nbsp;&nbsp;>&nbsp;&nbsp;添加菜单</span>
</div>
		<form action="SubmenuServlet?flag=add" method="post">
		<input type="text" placeholder="标题" name="title" required id="title" style="width: 240px;height: 35px;"/><br/><br/> 
			<select id="s_menu" name="select">
           		<c:forEach items="${menu1 }" var="m" >
           		<option value="${m.id }">${m.title }</option>
           		</c:forEach>
           		<c:forEach items="${menu2 }" var="m" >
           		<option value="${m.id }">${m.title }</option>
           		</c:forEach>
           		<c:forEach items="${menu3 }" var="m" >
           		<option value="${m.id }">${m.title }</option>
           		</c:forEach>
           	</select>
           	<br><br>
           	<textarea id="content" name="content" style="width: 700px;height: 200px;"></textarea>
           	<br><br>
			<input type="submit" value="增    加" class="btn" id="btn"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取     消" class="btn" />
		</form>
		<script charset="utf_8" src="${pageContext.request.contextPath }/editor/kindeditor-all-min.js"></script>
		<script charset="utf_8" src="${pageContext.request.contextPath }/editor/lang/zh-Cn.js"></script>
		<script type="text/javascript">
			KindEditor.ready(function(K){
				window.editor = K.create('#content');
			});
		</script>
</section>
</body>
</html>