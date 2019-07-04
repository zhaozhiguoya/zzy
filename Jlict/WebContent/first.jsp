<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/mainpage.css" />
</head>
<body>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		$(".l").mouseover(function(){
			$(this).children("ul").children("li").show();
		});
		$(".ll").mouseover(function(){
			$(this).show();
		}).mouseout(function(){
			$(this).siblings().hide();
			$(this).hide();
		});
	});
</script>
</head>
<body style="background-color: #DEEBF3;">
	<header>
		<img src="${pageContext.request.contextPath }/img/main_logo.jpg"/>
	</header>
	<section>
		<nav>
			<ul>
				<li style="border: none;"><a href="mainpage.jsp">首页</a></li>
				<c:forEach items="${navs }" var="n">
				<li class="l"><a href="first.jsp">${n.title }</a>
					<ul>
						<c:forEach items="${menu }" var="m" varStatus="mm">
						  <c:if test="${n.id eq m.mid }">
							<li class="ll"><a href="#">${m.title }</a></li>
						  </c:if>
						</c:forEach>
					</ul>
				</li>
				</c:forEach>
			</ul>
		</nav>
		<div>
		<ul>
			<c:forEach items="${submenu }" var="s">
					<li><a href="">${s.title }</a></li>
					<li><span>日期：</span>${s.time }</li>
					<a href="" style="float: right;padding-right:30px;font-size: 15px;">[查看全文]</a>
			</c:forEach>
		</ul>
		</div>
	</section>
</body>
</html>