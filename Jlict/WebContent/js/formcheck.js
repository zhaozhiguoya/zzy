$(function(){

     $(".btn-add").click(function(){
   	  $(".alertDiv-add").slideDown(1000,function(){
   		  $(".alertDiv").show();
   	  });
     });
    

});
/**
 * 
 */
  $(function(){
	   var choose="";//增加或修改
	   var isOK=true;
	    $(".btn-edit").click(function(){
	    	choose='edit';
		   $.ajax({
 			    url:"UserServlet?flag=yupdate",
 			    type:"post",
 			    async:true,
 			    dataType:'json',
 			    data:{"id":$(this).attr('id')},
 			    success:function(data){
 			    	var str =JSON.stringify(data);
 			    	var user=eval("("+str+")");
 			    	$(".alertDiv-add").slideDown(1000,function(){
 			    		  $(".alertDiv").show();
 			    	  });
 			    	$(".alertDiv #username").val(user.username);
 			    	$(".alertDiv #password").val(user.password);
 			        $(".alertDiv input[type=submit]").val("修     改");
 			    } 
 		   });
	   });
	    $("section .alertDiv form").submit(function(){
			if(choose == 'edit'){
				$("section .alertDiv form").attr('action','UserServlet?flag=update'); 
			}
	    });
	    
	    
	
   });