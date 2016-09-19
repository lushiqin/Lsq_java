/*严格模式
"use strict";
 */
new Vue({
	el : "body",
	data : {
		msg : 'message'
	},
	methods : {
		addTest : function() {
			layer.open({
				type : 2, // page层
				area : [ '500px', '300px' ],
				title : '新增会员' + $("#addTest").text(),
				skin : 'layui-layer-rim', // 样式类名
				closeBtn : 0, // 不显示关闭按钮
				shade : 0.3, // 遮罩透明度
				shadeClose : true, // 开启遮罩关闭
				moveType : 1, // 拖拽风格，0是默认，1是传统拖动
				shift : 1, // 0-6的动画形式，-1不开启
				content : 'addTest',
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
						$
								.post("addTests", body.find("#memberinfo")
										.serialize());
						layer.close(index);
						layer.msg("注册成功！", {
							time : 1000
						});
					}
					;
				},
				btn2 : function(index, layero) {
					layer.close(index);
					layer.msg("已取消", {
						time : 1000
					});
				}
			});
		},
		delTest : function() {
			layer.open({
				type : 2, // page层
				area : [ '500px', '300px' ],
				title : '你好，layer。',
				skin : 'layui-layer-rim', // 样式类名
				closeBtn : 0, // 不显示关闭按钮
				shade : 0.3, // 遮罩透明度
				shadeClose : true, // 开启遮罩关闭
				moveType : 1, // 拖拽风格，0是默认，1是传统拖动
				shift : 2, // 0-6的动画形式，-1不开启
				content : 'delTest',
				btn : [ '确定', '取消' ],
				success : function(msg) {
					$.each(msg, function(i, n) {
						alert(i + "--" + n.username);
					});
				},
				yes : function(index, layero) {
					layer.close(index);
					layer.msg('成功了！');
				},
				btn2 : function(index, layero) {
					layer.close(index);
					layer.msg('取消了！');
				}
			});
		},
		setTest : function() {
			layer.open({
				type : 2, // page层
				area : [ '500px', '300px' ],
				title : '你好，layer。',
				skin : 'layui-layer-rim', // 样式类名
				closeBtn : 0, // 不显示关闭按钮
				shade : 0.3, // 遮罩透明度
				shadeClose : true, // 开启遮罩关闭
				moveType : 1, // 拖拽风格，0是默认，1是传统拖动
				shift : 3, // 0-6的动画形式，-1不开启
				content : 'setTest',
				btn : [ '确定', '取消' ],
				yes : function(index, layero) {
					layer.close(index);
					layer.msg('成功了！');
				},
				btn2 : function(index, layero) {
					layer.close(index);
					layer.msg('取消了！');
				}
			});
		},
		serTest : function() {
			layer.open({
				type : 2, // page层
				area : [ '500px', '300px' ],
				title : '你好，layer。',
				content : 'serTest',
				skin : 'layui-layer-rim', // 样式类名
				closeBtn : 0, // 不显示关闭按钮
				shade : 0.3, // 遮罩透明度
				shadeClose : true, // 开启遮罩关闭
				moveType : 1, // 拖拽风格，0是默认，1是传统拖动
				shift : 4, // 0-6的动画形式，-1不开启
				btn : [ '确定', '取消' ],
				yes : function(index, layero) {
					layer.close(index);
					layer.msg('成功了！');
				},
				btn2 : function(index, layero) {
					layer.close(index);
					layer.msg('取消了！');
				}
			});
		},
		funny : function() {
			layer.tab({
				area : [ '600px', '600px' ],
				tab : [ {
					title : '第一页',
					content : 'login1'
				}, {
					title : '第二页',
					content : 'login2'
				}, {
					title : '第三页',
					content : 'login3'
				} ]
			});
		}
	}

});