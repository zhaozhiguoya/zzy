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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/formcheck.js" charset="gb2312"></script> 
</head>
<body>
<jsp:include page="main.jsp"></jsp:include>
<section>
	<div class="dirbox">
	<span>用户管理</span>
	</div>
	<div class="tablebox">
    <form action="UserServlet?flag=findByName" method="post" class="findbox">
    	<div class="btn-add">+&nbsp;新增</div>
      	<input type="text" name="username" placeholder="请输入你要查询的用户名"/>
     	 <input type="submit" value=""/><br>
    </form><br>
	<table>
		<tr>
      		<td width="50"><input type="checkbox" name="check" id="checkAll"/></td>
			<td width="100">编号</td>
			<td width="100">用户名</td>
			<td width="100">密码</td>
			<td width="200">操作</td>
		</tr>
		<c:forEach  items="${userlist }" var="ul">
			<tr>
			<td><input type="checkbox" name="check" id="c${ul.id }"/></td>
				<td>${ul.id }</td>
				<td>${ul.username }</td>
				<td>${ul.password }</td>
				 <td>
				 <div class="btn-delete"><a href="UserServlet?flag=deleteOne&id=${ul.id }">
      			 <img src="${pageContext.request.contextPath}/img/btn-delete.png"/>删除</a></div>
         		 <div class="btn-edit" id="${ul.id }"><a class="edit-data" >
         		 <img src="${pageContext.request.contextPath}/img/btn-edit.png"/>编辑</a></div>
          		 </td>
			</tr>
		</c:forEach>
	</table>
	${pager }
	</div>
	 <!-- 弹出层  -->
   
   <div class="alertDiv">
         <form action="UserServlet?flag=add" method="post" id="addform" class="alertDiv-add">
           <div class="hid">×</div>
           
           <input type="text" placeholder="用户名" name="username" required id="username" /><br /> 
		   <input type="password" placeholder="密码"  name="password" required  id="password" /><br /> 
			<input type="submit" value="增    加" class="btn" />
			<input type="reset" value="取     消" class="btn" />
            
         </form>
       </div>
</section>
</body>
</html>