<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/main.css"  type="text/css" rel="styleSheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/table.js" charset="gb2312"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/formcheck.js" charset="gb2312"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/supplier_check.js" charset="gb2312"></script>  
<style type="text/css">
/* 增加框 复写*/
 section .alertDiv-add{
	width:500px;
	height:600px;
	position:absolute;
    top:5%;
    left:30%; 
}

 section .alertCheck-add{
	width:450px;
	height:450px;
	position:absolute;
    top:5%;
    left:30%; 
} 
</style>
</head>
<body>
 
<jsp:include page="head.jsp"></jsp:include>
<section>
 <input type="hidden" value="supplier" id="hid"/>
<div class="dirbox">
    <span>供应商管理&nbsp;&nbsp;>&nbsp;&nbsp;供应商选择</span>
</div>
<div class="tablebox">
<form action="SupplierServlet?flag=findByName" method="post" class="findbox">
       <div class="btn-add">+&nbsp;新增</div>
       <div class="btn-delete">🗑&nbsp;删除</div>
       <div class="btn-export">🎞&nbsp;导出</div>
       <input type="text" placeholder="请输入要查询的供应商名称..." name="name"/>
       <div id="btn-find"></div>
 </form>
    <table>
   <tr>
      <td width="50"><input type="checkbox" name="check" id="checkAll"/></td>
     <td width="100" >编号</td>
      <td width="200">供应商名称</td>
      <td width="200">联系人</td>
      <td width="200">联系人电话</td>
      <td width="200">状态</td>
      <td width="300">操作</td>
   </tr>
   <c:forEach items="${supplist }" var="sl" begin="0" end="9">
         <tr>
      <td><input type="checkbox" name="check" id="c${sl.id }"/></td>
      <td>${sl.id }</td>
      <td>${sl.name }</td>
      <td>${sl.linkman}</td>
      <td>${sl.linkman_tel }</td>
      <td>${sl.status}</td>
      <td>
      <c:if test="${ischeck eq 'true' }">
       <div class="btn-check" id="${sl.id }"><a >
      <img src="${pageContext.request.contextPath}/img/btn-check.png"/>审核</a></div>
      </c:if>
      <div class="btn-delete"><a href="SupplierServlet?flag=deleteOne&id=${ul.id }">
      <img src="${pageContext.request.contextPath}/img/btn-delete.png"/>删除</a></div>
          <div class="btn-edit" id="${ul.id }"><a class="edit-data" >
          <img src="${pageContext.request.contextPath}/img/btn-edit.png"/>编辑</a></div></td>
   </tr> 
   </c:forEach>
   
   
   </table> 
   </div>
   <div class="inpage">分页预留位置</div>
   <footer>CopyRight &copy; 2018 创睿信教育集团 <br> <br>
   Powered by Teacher Lei版权所有
   </footer>
   
   <!-- 弹出层  -->
   
   <div class="alertDiv">
         <form action="SupplierServlet?flag=add" method="post" id="addform" class="alertDiv-add">
           <div class="hid">×</div>
           
           <input type="text" placeholder="名称" name="name" required/><br> 
           <input type="text" placeholder="地址" name="address" required /><br> 
           <input type="text" placeholder="电话" name="tel" required /><br> 
           <input type="email" placeholder="email" name="email"  /><br> 
           <input type="text" placeholder="传真" name="fax"  /><br> 
           <input type="text" placeholder="联系人" name="linkman"  /><br> 
           <input type="text" placeholder="联系人电话" name="linkman_tel"  /><br> 
           
           <input type="radio" name="status" value="未审核" checked disabled/><span class="rs">未审核</span>
           <input type="radio" name="status" value="审核中" disabled/><span class="rs">审核中</span>
           <input type="radio" name="status" value="审核未通过" disabled/><span class="rs">审核未通过</span>
           <input type="radio" name="status" value="已审核" disabled/><span class="rs">已审核</span>
			<br> 
			<input type="submit" value="增    加" class="btn" />
			<input type="reset" value="取     消" class="btn" />
            
         </form>
       </div>
       
          <div class="alertCheck">
         <form action="SupplierServlet?flag=add" method="post" id="addform" class="alertCheck-add">
           <div class="hid">×</div>
           
           
            供应商名称：<input type="text" placeholder="" name="name" value="${checkSup.name }" disabled="disabled"/><br /> 
          价格是否合理：     <input type="radio" name="price" value="偏高" checked="checked"/>偏高&nbsp;&nbsp;
          <input type="radio" name="price" value="适中"/>适中&nbsp;&nbsp;
          <input type="radio" name="price" value="偏低"/>偏低<br>
        样品是否合格：     <input type="radio" name="sample" value="合格"  checked="checked"/>合格&nbsp;&nbsp;
          <input type="radio" name="sample" value="不合格"/>不合格<br>
         各部门满意度：<input type="text" style="width:35px;" name="sat" placeholder="100"/>(*满分100分，不满意扣5分/部门)<br>
         交货能力评判：<input type="radio" name="delivery" value="逾期"  checked="checked"/>逾期&nbsp;&nbsp;
          <input type="radio" name="delivery" value="未逾期"/>未逾期<br>
      材料是否齐全：<input type="radio" name="f_data" value="齐全"  checked="checked"/>齐全&nbsp;&nbsp;
          <input type="radio" name="f_data" value="不齐全"/>不齐全<br>    
            质量是否达标：<input type="radio" name="quality" value="达标"  checked="checked"/>达标&nbsp;&nbsp;
          <input type="radio" name="quality" value="不达标"/>不达标<br>  
          <input type="submit" value="增    加" class="btn" />
			<input type="reset" value="取     消" class="btn" />
           </form>
           </div>
           
</section>
</body>
</html>