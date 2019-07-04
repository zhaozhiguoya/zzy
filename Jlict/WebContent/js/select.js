	var menu1 = new Array('请选择','首页','学院概况','学院新闻','机构设置','专业建设','师资队伍','教研科研','教学管理','实践教学','党建工作','学团工作','课件下载');
	var menu2 = new Array('请选择','专业设置','培养方案','课程建设','教材建设','办学特色','师资概况','教师风采','教书育人'
			,'科研动态','科研成果','教研项目','教务管理','毕业设计');

	var menu=new Object();
	menu['5']=new Array('--选择子类--','12','13','14','15','16');
	menu['6']=new Array('--选择子类--','17','18','19');
	menu['7']=new Array('--选择子类--','20','21','22');
	menu['8']=new Array('--选择子类--','23');
	menu['9']=new Array('--选择子类--','24');
	var result="";
	function mm()
	{
		
		var sltp=document.getElementById("one_menu");
		var slsb=document.getElementById("two_menu");
		var sva=sltp.value;
		slsb.options.length=1;
		for(var i=0;i<menu[sva].length;i++){
			
			if(i==17){
				continue;
			}
			if(i!=0){
			 slsb.options[i]=new Option(menu2[Number(menu[sva][i])-11],menu[sva][i]);
			}
			else{
			 slsb.options[i]=new Option(menu2[0],'0');
			}
		}
	}
function mm2()
{
	var m2=document.getElementById("two_menu");
	if(m2.value!="--选择子类--")
	{
		result=m2.value;
	}
}
function show()
{
	//alert("您选择的商品为"+menu2[Number(result)-11]+",商品的编号为"+result);	
	$("section form").attr('action','MenuServlet?flag=add');
}