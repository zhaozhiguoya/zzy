/*$(function () {
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
	*/
	function ShowTabs(ID) { 
		for (i = 0; i < 17; i++) {
			if (i == ID) {
				document.getElementById("TabTitle" + i).className = "titlemouseover";
				document.getElementById("Tab" + i).style.display = "";
			}else {
				document.getElementById("TabTitle" + i).className = "tabtitle";
				document.getElementById("Tab" + i).style.display = "none";}}}

	function ShowTabs1(ID) {
		for (j = 0; j < 17; i++) {
			if (j == ID) {
				document.getElementById("TabTitle" + j).className = "titlemouseover";
				document.getElementById("Tab" + j).style.display = "";
			}else {
				document.getElementById("TabTitle" + j).className = "tabtitle";
				document.getElementById("Tab" + j).style.display = "none";}}}