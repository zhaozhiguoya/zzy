<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/user_list.css"  type="text/css" rel="styleSheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/table.js" charset="gb2312"></script> 
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<section>
<div class="dirbox">
	<span>菜单管理&nbsp;&nbsp;>&nbsp;&nbsp;查看菜单</span>
	</div>
	<div class="tablebox">
	<form action="MenuServlet?flag=findByName" method="post" class="findbox">
	<a href="MenuServlet?flag=findOnemenu" style="background-color: green;font-size: 22px;margin-left: 12px;float: left;">+&nbsp;增加</a>
    	<!-- <div class="btn-add">+&nbsp;新增</div> -->
      	<input type="text" name="title" placeholder="请输入你要查询的标题"/>
     	 <input type="submit" value=""/><br>
    </form><br>
	<table>
		<tr>
      		<td width="50"><input type="checkbox" name="check" id="checkAll"/></td>
			<td width="100">编号</td>
			<td width="100">标题</td>
			<td width="100">类型</td>
			<td width="100">上级菜单编号</td>
			<!-- <td width="100">上级菜单标题</td> -->
			<td width="200">操作</td>
		</tr>
		<c:forEach  items="${menu }" var="ul">
			<tr>
			<td><input type="checkbox" name="check" id="c${ul.id }"/></td>
				<td>${ul.id }</td>
				<td>${ul.title }</td>
				<td>${ul.type }</td>
				<td>${ul.mid }</td>
				 <td>
				 <div class="btn-delete"><a href="MenuServlet?flag=delete&id=${ul.id }">
      			 <img src="${pageContext.request.contextPath}/img/btn-delete.png"/>删除</a></div>
         		 <div class="btn-edit" id="${ul.id }"><a href="MenuServlet?flag=yupdate&id=${ul.id }">
         		 <img src="${pageContext.request.contextPath}/img/btn-edit.png"/>编辑</a></div>
          		 </td>
			</tr>
		</c:forEach>
	</table>
	${pager }
	</div>
	</section>
</body>
</html>