/**
 * 
 */
$(function(){
	
	//设置初始表格样式  表头及单双行
	var trs=$("section table tr");
	var i=0;
	$.each(trs,function(){
		if(i==0){
			$(this).addClass("tabletitle");
		}else{
			if(i%2==0){
				$(this).addClass("tablesingle");
			}else{
				$(this).removeClass("tablesingle");
			}
		}
		i++;
	});
	
	//设置鼠标移入 
	$("section table tr").hover(function(){
		$(this).css("background-color","#DCDCDC");
		if($(this).index()==0){
			$(this).css("background","#EAEAEA");
		}
	},function(){
		if($(this).index()%2==0){
			if($(this).index()==0){
				$(this).css("background","#EAEAEA");
			}else{
				$(this).css("background-color","#F7F7F7");
			}
		}else{
			$(this).css("background-color","");
		}
	});
	
      //添加框 关闭事件
       $(".hid").click(function(){
    	   $(".alertDiv-add").slideUp(500,function(){
    		   $(".alertDiv").hide();
    	   });
       });
       
     
      //全选
        $("table #checkAll").click(function(){
        	if(this.checked) {
                $("input[name='check']").attr('checked',true);
            }else {
                $("input[name='check']").attr('checked',false);
            }
        	
        });
       
      
       
       
});