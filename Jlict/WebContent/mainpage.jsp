<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息与控制工程学院</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/mainpage.css" />
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<style type="text/css">
@IMPORT url("css/mainpage.css");
</style>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/selectFilter.js" charset="gb2312"></script>
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
				<li class="l"><a href="IndexServlet?flag=findFirst&id=${n.id }">${n.title }</a>
					<ul>
						<c:forEach items="${menu }" var="m" varStatus="mm">
						  <c:if test="${n.id eq m.mid }">
							<li class="ll"><a href="IndexServlet?flag=findSecond&id=${m.id }">${m.title }</a></li>
						  </c:if>
						</c:forEach>
					</ul>
				</li>
				</c:forEach>
			</ul>
		</nav>
		<article>
			<aside>
				<div id="a">
					<ul>
					<li style="font-size: 20px;background-color: #0E7AC3;text-align: center;color: white;width: 215px;"><a>学院概况</a><li>
					<li><a href="">学院简介</a><li>
					<li><a href="">现任领导</a><li>
					<li><a href="">组织结构</a><li>
					<li><a href="">师资队伍</a><li>
					<li><a href="">专业设置</a><li>
					<li><a href="">培养方案</a><li>
					<li><a href="">办学特色</a><li>
					<li><a href="">联系我们</a><li>
					</ul>
				</div>
				
				<div id="b">
					<ul>
						<li style="font-size: 20px;background-color: #0E7AC3;text-align: center;color: white;width: 205px;"><a>大学计算机基础教学</a></li>
						<li><a href="">大学计算机基础课后题答案</a><span>11-27</span></li>
						<li><a href="">计算机基础例题下载</a><span>11-27</span></li>
						<li><a href="">计算机省二考试笔试试题汇</a><span>11-27</span></li>
						<li><a href="">计算机省二考试上机试题汇</a><span>11-27</span></li>
						<li><a href="">C语言程序设计题</a><span>11-27</span></li>
						<li><a href="">C语言程序改错题</a><span>11-27</span></li>
						<li><a href="">C语言程序设计II教学大纲</a><span>11-27</span></li>
						<li><a href="">C语言程序设计I教学大纲</a><span>11-27</span></li>
						<li><a href="">大学计算机基础习题汇编</a><span>11-27</span></li>
						<li><a href="">大学计算机基础教学大纲</a><span>11-27</span></li>
					</ul>
				</div>
				
				<div id="c">
				<ul>
				<li style="font-size: 20px;background-color: #0E7AC3;text-align: center;color: white;width: 215px;"><a>学术活动</a></li>
				</ul>
					<div id="c1">
					<div id="c2">
					<a href="">张景萍教授报告会</a>
					</div>
					<table id="c_table">
					<tr><td style="font-size: 12px;padding-left: 10px;">&nbsp; 报告人：张景萍 教授</td></tr>
					<tr><td style="font-size: 12px;padding-left: 10px;">&nbsp; 报告时间：9月23日9:00</td></tr>
					<tr><td style="font-size: 12px;padding-left: 10px;">&nbsp; 报告地点：图书馆报告厅</td></tr>
					</table>
					<div id="c3">
					<a href="" style="float: right;padding-right:30px;font-size: 15px;">[查看全文]</a>
					</div>
					</div><br>
					<div id="c1">
					<div id="c2">
					<a href="">高喜文专题报告会</a>
					</div>
					<table>
					<tr><td style="font-size: 12px;padding-left: 10px;">&nbsp; 报告人：高喜文 教授</td></tr>
					<tr><td style="font-size: 12px;padding-left: 10px;">&nbsp; 报告时间：11月9日晚6:00</td></tr>
					<tr><td style="font-size: 12px;padding-left: 10px;">&nbsp; 报告地点：二教学术报告厅</td></tr>
					</table>
					<div id="c3">
					<a href="" style="float: right;padding-right:30px;font-size: 15px;">[查看全文]</a>
					</div>
					</div><br>
				</div>
				
				<div id="d">
				<ul>
				<li style="font-size: 20px;
				background-color: #0E7AC3;
				text-align: center;color: white;
				width: 215px;"><a>课件下载</a></li>
				<li><a href="">计算机操作系统第十章课件</a><span>11-28</span></li>
				<li><a href="">计算机操作系统第九章课件</a><span>11-28</span></li>
				<li><a href="">计算机操作系统第八章课件</a><span>11-28</span></li>
				<li><a href="">计算机操作系统第七章课件</a><span>11-28</span></li>
				<li><a href="">计算机操作系统第六章课件</a><span>11-28</span></li>
				<li><a href="">计算机操作系统第五章课件</a><span>11-28</span></li>
				<li><a href="">计算机操作系统第四章课件</a><span>11-27</span></li>
				<li><a href="">计算机操作系统第三章课件</a><span>11-27</span></li>
				<li><a href="">计算机操作系统第二章课件</a><span>11-27</span></li>
				<li><a href="">计算机操作系统第一章课件</a><span>04-06</span></li>
				</ul>
				</div>
				
				<div id="e">
				<ul>
				<li style="font-size: 20px;
				background-color: #0E7AC3;
				text-align: center;color: white;
				width: 215px;"><a>校内资源</a></li>
				<li><a href="">化工学院教务处</a></li>
				<li><a href="">化工学院50年校庆专题网</a></li>
				<li><a href="">化工学院心理健康教育中心</a></li>
				<li><a href="">化工学院共青团</a></li>
				<li><a href="">学术期刊数据库</a></li>
				<li><a href="">化工学院图书馆</a></li>
				<li><a href="">化工学院学报</a></li>
				<li><a href="">化工学院第五季校园文化网</a></li>
				<li><a href="">化工学院校园一卡通</a></li>
				<li><a href="">吉林市公交线路查询</a></li>
				<li><a href="">10ms高速资源网</a></li>
				</ul>
				</div>
			</aside>
			<aside style="margin:0px 18px;width: 46%;">
				<div id="f">
				<div style="background-color: #0E7AC3;width: 495px;height: 24px;">
				<span style="color: white;text-align: center;
				padding-top: 1px;font-size:17.5px;border-top: 1px #97D1F3 solid;">学院新闻</span>
				</div>
				<ul>
				<li><span>03-22</span><a href="">【党课】2019年信控学院入党积极分子培训班开班仪式</a></li>
				<li><span>01-20</span><a href="">信控学院召开《第十四届长通杯电子设计大赛暨信控学院学科竞赛总结座谈会》</a></li>
				<li><span>10-17</span><a href="">追寻红色足迹，传承英烈遗志</a></li>
				<li><span>10-15</span><a href="">信控学院|辅导员 班主任工作研讨会</a></li>
				<li><span>09-19</span><a href="">[推荐]18级全体新生专业教育大会</a></li>
				<li><span>09-18</span><a href="">勿忘国耻 吾辈自强</a></li>
				<li><span>09-13</span><a href="">学习新思想 共筑中国梦</a></li>
				<li><span>09-11</span><a href="">信控学院召开新生家长见面会</a></li>
				</ul>
				</div>
				<div id="TabTitle" style="background-color: #0E7AC3;width: 495px;height: 24px;">
				   <div class="titlemouseover" id="TabTitle0" onmouseover="ShowTabs(0)" style=" display:inline">
						 <span style="color: white;text-align: center;padding-top: 1px;font-size: 18px;background-color: #0E7AC3;">教务管理</span>
          		  </div>
		          <div class="tabtitle" id="TabTitle1" onmouseover="ShowTabs(1)" style=" display:inline">
		     		     <span style="color: white;text-align: center;padding-top: 1px;font-size: 18px;background-color: #0E7AC3;">考务管理</span>  
		          </div>
		          <div class="tabtitle" id="TabTitle2" onmouseover="ShowTabs(2)" style=" display:inline">
		               	 <span style="color: white;text-align: center;padding-top: 1px;font-size: 18px;background-color: #0E7AC3;">文件下载</span>
           	 	  </div>
				
				</div>
				
			<div id="Tab0">
         	 <div id="g">
              <ul>
				<li><span>06-17</span><a href="">教学检查相关表格</a></li>
				<li><span>02-27</span><a href="">信控学院关于进行2011-2012（2）期初教学检查的通知</a></li>
				<li><span>02-26</span><a href="">信控学院关于进行2011-2012（2）期初教学检查的通知</a></li>
				<li><span>11-28</span><a href="">关于开展2010-2011学年第二学期期中教学检查工作的通知</a></li>
				<li><span>11-28</span><a href="">关于进一步加强高等学校本科教学工作的若干意见</a></li>
				<li><span>11-28</span><a href="">教育部关于进一步深化本科教学改革全面提高教学质量的若干意见</a></li>
				<li><span>11-28</span><a href="">教育部关于启动高等学校教学质量与教学改革工程精品课程建设工作的通知</a></li>
				<li><span>11-28</span><a href="">教育部办公厅关于加强普通高等学校毕业设计（论文）工作的通知</a></li>
				</ul>
               <div class="more"><a href="">--&gt;&gt;更多</a></div>
             </div>
           </div>
           <div id="Tab1" class="pic_new" style="display: none;">
           <div id="h">
            <ul>
			<li><span>11-28</span><a href="">关于考生查询大学外语四、六级报名信息的通知</a></li>
			<li><span>11-28</span><a href="">致参加全国大学外语四六级考试考生的一封信</a></li>
			</ul>
            <div class=more><a href="">--&gt;&gt;更多</a></div>
            </div>
           </div>
            
          <div id="Tab2" class="article_new" style="display: none;">
           <div id="i">
              <ul>
				<li><span>09-12</span><a href="">2016校历</a></li>
				<li><span>06-17</span><a href="">课题研究报告格式</a></li>
				<li><span>06-17</span><a href="">自编教材使用审批</a></li>
				<li><span>06-17</span><a href="">学籍证明模板</a></li>
				<li><span>06-17</span><a href="">教师领书单</a></li>
				<li><span>06-17</span><a href="">教材征（补）订单</a></li>
				<li><span>11-28</span><a href="">吉林化工学院教师课堂教学质量评价统计表</a></li>
				<li><span>11-28</span><a href="">任课教师调（停）代课情况统计表</a></li>
			  </ul>
               <div class=more><a href="">--&gt;&gt;更多</a></div>
            </div>
          </div>
            
            
            <div class="center"><img src="${pageContext.request.contextPath}/img/main-center.jpg"/></div>
            
            <div id="j">
            <div style="background-color: #0E7AC3;width: 495px;height: 24px;">
				<span style="color: white;text-align: center;
				padding-top: 1px;font-size:17.5px;border-top: 1px #97D1F3 solid;">实践教学</span>
			</div>
            <ul>
			<li><span>09-26</span><a href="">信控学院校外实习（第七学期）实习办理手续流程20180926</a></li>
			<li><span>05-07</span><a href="">2018届毕业设计相关资料 (学生用)</a></li>
			<li><span>03-27</span><a href="">信控学院学生毕业设计期间外出请假单</a></li>
			<li><span>01-18</span><a href="">毕业设计期间校外实习相关资料（2018版）</a></li>
			<li><span>12-22</span><a href="">2017届毕业设计材料模板和相关要求等资料</a></li>
			<li><span >09-02</span><a href="">吉林省大学生电子竞赛紧张进行中</a></li>
			<li><span>12-23</span><a href="">信息与控制工程学院和北京高校学习交流</a></li>
			<li><span>12-23</span><a href="">工程师讲座进行时</a></li>
			</ul>
            <div class="more"><a href="">--&gt;&gt;更多</a></div><br>
            </div>
            
			<div id="k">
            <div style="background-color: #0E7AC3;width: 495px;height: 24px;">
				<span style="color: white;text-align: center;
				padding-top: 1px;font-size:17.5px;border-top: 1px #97D1F3 solid;">学团工作</span>
			</div>
            <ul>
			<li><span>06-29</span><a href="">不忘初心  牢记使命</a></li>
			<li><span>05-23</span><a href="">树立理想，让青春在拼搏中闪光</a></li>
			<li><span>03-13</span><a href="">信控学院学院召开新学期学生安全工作会</a></li>
			<li><span>03-05</span><a href="">学习雷锋好榜样，传递青春正能量</a></li>
			<li><span>04-08</span><a href="">信控学院寝室防火大排查</a></li>
			<li><span>03-26</span><a href="">信控学院进行寝室大排查</a></li>
			<li><span>03-23</span><a href="">信控学院召开学生干部大会</a></li>
			<li><span>03-16</span><a href="">信控学院年级大会暨学习报告会</a></li>
			</ul>
            <div class="more"><a href="">--&gt;&gt;更多</a></div><br>
            </div>	
				
			<div id="l">
            <div style="background-color: #0E7AC3;width: 495px;height: 24px;">
				<span style="color: white;text-align: center;
				padding-top: 1px;font-size:17.5px;border-top: 1px #97D1F3 solid;">党建工作</span>
			</div>
            <ul>
			<li><span>10-12</span><a href="">学院教工党支部举办“党员树旗帜 喜迎十九大”主题党日活动</a></li>
			<li><span>09-13</span><a href="">学院召开巡视整改落实班子专题民主生活会</a></li>
			<li><span>04-13</span><a href="">学院党委组织教工学习习总书记讲话 传达全国高校思政会议精神</a></li>
			<li><span>08-29</span><a href="">学生党支部组织开展迎接新学期 服务新生同学党日活动</a></li>
			<li><span>07-02</span><a href="">不忘初心   砥砺前行  ——信息与控制工程学院党委工作纪实</a></li>
			<li><span>06-12</span><a href="">我院党组织换届选举工作结束</a></li><li><span>04-26</span><a href="">学院启动“两学一做”学习教育</a></li>
			<li><span>06-18</span><a href="">信控学院举办“三严三实”教育专题党课</a></li>
			</ul>
            <div class="more"><a href="">--&gt;&gt;更多</a></div>
            </div>	
				
			</aside>
			<aside style="float: right;">
				<div id="A">
				<ul>
				<li style="font-size: 18px;
				background-color: #0E7AC3;
				text-align: center;color: white;
				width: 230px;height:20px;float: right;"><a>快捷导航</a></li>
				<li><a href="">本周工作</a></li>
				<li><a href="">校历查询</a></li>
				<li><a href="">成绩录入与查询</a></li>
				<li><a href="">教学质量监控</a></li>
				<li><a href="">电子邮局</a></li>
				</ul>
				</div>
				<div id="B">
				<ul>
				<li style="font-size: 18px;
				background-color: #0E7AC3;
				text-align: center;color: white;
				width: 230px;height:20px;float: right;"><a>常用软件</a></li>
				<li><a href="">Microsoft Visual C++6.0简体中文版</a></li>
				<li><a href="">网页制作Dreamweaver CS6中文版</a></li>
				<li><a href="">图像处理PhotoshopCS6绿色中文版</a></li>
				<li><a href="">多资源超线程迅雷下载软件</a></li>
				<li><a href="">永久免费杀毒软件</a></li>
				<li><a href="">Microsoft Office 2010简体中文版</a></li>
				<li><a href="">驱动程序智能检测自动安装工具</a></li>
				<li><a href="">PDF等期刊浏览编辑工具CAJViewer</a></li>
				<li><a href="">数学软件MATLAB</a></li>
				<li><a href="">腾讯通企业通讯平台</a></li>
				</ul>
				</div>
				
				<div id="C">
				  <ul>
					<li style="font-size: 18px;
					background-color: #0E7AC3;
					text-align: center;color: white;
					width: 230px;height:20px;float: right;"><a>友情链接</a></li>
					<li><a href="">吉林化工学院</a></li>
					<li><a href="">化工与材料工程学院</a></li>
					<li><a href="">机电工程学院</a></li>
					<li><a href="">化学与制药工程学院</a></li>
					<li><a href="">经济管理学院</a></li>
					<li><a href="">外国语学院</a></li>
					<li><a href="">环境与生物工程学院</a></li>
					<li><a href="">理学院</a></li>
					<li><a href="">人文社会科学部</a></li>
					<li><a href="">体育教学部</a></li>
					<li><a href="">分析测试中心</a></li>
					<li><a href="">成人教育学院</a></li>
					</ul>
				</div>
			</aside>
		</article>
	</section>
	<div style="background-color: #004A9F;width: 1025px;height: 100px;margin:0px auto;">
	<div class="inpage">Copyright &copy;&nbsp;信息与控制工程学院 . All Rights Reserved.<br/>
		地址：吉林省吉林市承德街45号 邮 编：132022 |
		 <a href="http://www.miibeian.gov.cn/">吉ICP备05009250号 </a></div>
	</div>
	
</body>
</html>