$("#submit1").on("click", function() {
	var name = $("#name").val();
	var pass = $("#pass").val();

	if (name == null || name == "") {
		alert("用户名为空");
	} else if (pass == null || pass == "") {
		alert("密码为空");
	} else {
		$.ajax({
			type : 'POST',
			url : 'member',
			dataType : 'json',
			cache : false,
			data : {
				"name" : name,
				"pass" : pass
			},
			success : function(data) {
				if (data == 200) {
					window.location.href="membercenter";
				} else {
					alert("登陆失败"+data);
				}
			},
			error : function(data) {
				alert("error");
			}
		});
	}

});