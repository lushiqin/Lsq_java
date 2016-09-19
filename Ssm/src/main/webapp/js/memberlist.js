/*严格模式
"use strict";
 */
$(document).ready(function() {
	var ss = {
		"name" : "lsq",
		"mobi" : "15012931651"
	};

	$.ajax({
		type : "post",
		url : "memberlist",
		data : ss,
		dataType : "text",
		success : function(data) {
			alert("success:"+data);
		},
		error : function(data) {
			alert("error:"+data);
		}

	});
});