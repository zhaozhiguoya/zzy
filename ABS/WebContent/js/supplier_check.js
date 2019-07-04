/**
 * 
 */
  $(function(){
	   var choose="";//增加或修改
	   var isOK=true;
	    $(".btn-edit").click(function(){
	    	choose='edit';
		   $.ajax({
 			    url:"SupplierServlet?flag=yupdate",
 			    type:"post",
 			    async:true,
 			    dataType:'json',
 			    data:{"id":$(this).attr('id')},
 			    success:function(data){
 			    	var str =JSON.stringify(data);
 			    	var sup=eval("("+str+")");
 			    	$(".alertDiv-add").slideDown(1000,function(){
 			    		  $(".alertDiv").show();
 			    	  });
 			    	$(".alertDiv input[name=name]").val(sup.name);
			    	$(".alertDiv input[name=address]").val(sup.address);
			    	$(".alertDiv input[name=tel]").val(sup.tel);
			    	$(".alertDiv input[name=email]").val(sup.email);
			    	$(".alertDiv input[name=fax]").val(sup.fax);
			    	$(".alertDiv input[name=linkman]").val(sup.linkman);
			    	$(".alertDiv input[name=link_tel]").val(sup.link_tel);
			    	$(".alertDiv input[name=status]").attr("disabled",false);
			    
			    	  //设置修改时 单选按钮的值
			    /*	$.each($(".alertDiv input[name=status]"),function(i,n){
			    		alert(n.attr('value'));
			    	});*/
			 
 			        $(".alertDiv input[type=submit]").val("修     改");
 			    } 
 		   });
	   });
	   
	    $("section .alertDiv form").submit(function(){
			if(choose == 'edit'){
				$("section .alertDiv form").attr('action','SupplierServlet?flag=update'); 
			}
	    });
	    
	    //删除多个选取的复选框
		$(".btn-delete").click(function(){
			var checks = $("input[name=check]");
			var str="";
			 $.each(checks,function(index,value){
				 if(value.checked && index!=0){
					str+=$(this).attr('id').substr(1)+',';
				 }
			});
			$(".findbox").attr('action','SupplierServlet?flag=deledeSome&ids='+str); 
			$(".findbox").submit();
		});
		//添加框 关闭事件
	       $("section  .alertCheck-add .hid").click(function(){
	    	   $(".alertCheck-add").slideUp(500,function(){
	    		   $(".alertCheck").hide();
	    	   });
	       });
		//单击审查按钮
		$(".btn-check").click(function(){
			 $.ajax({
	 			    url:"SupplierServlet?flag=ycheck",
	 			    type:"post",
	 			    async:true,
	 			    dataType:'json',
	 			    data:{"id":$(this).attr('id')},
	 			    success:function(data){
	 			    
	 			    	var str =JSON.stringify(data);
	 			    	var sup=eval("("+str+")");
	 			    	$(".alertCheck-add").slideDown(1000,function(){
	 			    		  $(".alertCheck").show();
	 			    	  });
	 			    	$(".alertCheck input[name=name]").val(sup.name);
//				    	$(".alertDiv input[name=address]").val(sup.address);
//				    	$(".alertDiv input[name=tel]").val(sup.tel);
//				    	$(".alertDiv input[name=email]").val(sup.email);
//				    	$(".alertDiv input[name=fax]").val(sup.fax);
//				    	$(".alertDiv input[name=linkman]").val(sup.linkman);
//				    	$(".alertDiv input[name=link_tel]").val(sup.link_tel);
//				    	$(".alertDiv input[name=status]").attr("disabled",false);
				    
				    	  //设置修改时 单选按钮的值
				    /*	$.each($(".alertDiv input[name=status]"),function(i,n){
				    		alert(n.attr('value'));
				    	});*/
				 
	 			      //  $(".alertDiv input[type=submit]").val("修     改");
	 			    } 
	 		   });
		});
   });