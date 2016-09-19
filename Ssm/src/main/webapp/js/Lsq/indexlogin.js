/*严格模式
"use strict";
 */
function login() {

	$.ajax({
		url : "logincheck",
		type : "post",
		data : $("#loginform").serialize(),
		dataType : "json",
		success : function(data) {
			if (data[1] == "200") {
				location.href = "lusqmain";
			} else {
				layer.msg("用户名或密码错误");
			}
		}
	});
};

function register() {
	layer.open({
		type : 2, // page层
		area : [ '500px', '300px' ],
		title : '用户注册',
		content : 'meminfo',
		skin : 'layui-layer-rim', // 样式类名
		closeBtn : 0, // 不显示关闭按钮
		shade : 0.3, // 遮罩透明度
		shadeClose : true, // 开启遮罩关闭
		moveType : 1, // 拖拽风格，0是默认，1是传统拖动
		shift : 2, // 0-6的动画形式，-1不开启
		btn : [ '确定', '取消' ],
		yes : function(index, layero) {
			var body = layer.getChildFrame('body', index);
			var username = body.find("#username").val();
			var usermobi = body.find("#usermobi").val();
			var useradde = body.find("#useradde").val();
			if (username == null || username == "") {
				layer.msg("用户名为空", {
					time : 1000
				});
			} else if (usermobi == null || usermobi == "") {
				layer.msg("手机号码为空", {
					time : 1000
				});
			} else if (useradde == null || useradde == "") {
				layer.msg("地址为空", {
					time : 1000
				});
			} else {
				$.post("register", body.find("#memberinfo").serialize());
				layer.close(index);
				layer.msg("注册成功！", {
					time : 1000
				});
			}
			;
		},
		btn2 : function(index, layero) {
			layer.close(index);
			layer.msg('取消了！');
		}
	});
};