/*严格模式
"use strict";
 */

/**
 * 查找用户列表
 */
function userser() {
	var userid = $("#sertext").val();
	if (userid == "" || userid == null) {
		$.ajax({
			url : 'userser',
			type : 'post',
			data : '',
			dataType : 'json',
			success : function(data) {
				var str = '';
				$.each(data, function(i, n) {
					str += '<tr>';
					str += '<td>' + n.id + '</td>';
					str += '<td>' + n.username + '</td>';
					str += '<td>' + n.usermobi + '</td>';
					str += '<td>' + n.useradde + '</td>';
					str += '</tr>';
				});
				$("#tbody").html(str);
			},
			error : function() {
				layer.msg("暂无数据");
			}
		});

	} else {
		$.ajax({
			url : 'userIdser',
			type : 'post',
			data : {
				userid : userid
			},
			dataType : 'json',
			success : function(data) {
				var str = '';
				str += '<tr>';
				str += '<td>' + data.id + '</td>';
				str += '<td>' + data.username + '</td>';
				str += '<td>' + data.usermobi + '</td>';
				str += '<td>' + data.useradde + '</td>';
				str += '</tr>';
				$("#tbody").html(str);
			},
			error : function(data) {
				layer.msg("暂无内容");
			}
		});
	}
};



/**
 * 修改用户信息
 */
function userupd() {
	layer.open({
		type : 2, // page层
		area : [ '500px', '300px' ],
		title : '修改',
		skin : 'layui-layer-rim', // 样式类名
		closeBtn : 0, // 不显示关闭按钮
		shade : 0.3, // 遮罩透明度
		shadeClose : true, // 开启遮罩关闭
		moveType : 1, // 拖拽风格，0是默认，1是传统拖动
		shift : 1, // 0-6的动画形式，-1不开启
		content : 'meminfo',
		btn : [ '确定', '取消' ],
		success : function(layero, index) {
			var body = layer.getChildFrame('body', index);
			$.ajax({
				url : 'userIdser',
				data : {
					userid : $("#sertext").val(),
				},
				type : 'post',
				dataType : 'json',
				success : function(data) {
					body.find("#usern").before("<div style = 'margin-bottom: 2%'><label>编号:</label><input type = 'text' id = 'userid' name = 'id' readonly='readonly' /></div>");
					body.find("#userid").val(data.id);
					body.find("#username").val(data.username);
					body.find("#usermobi").val(data.usermobi);
					body.find("#useradde").val(data.useradde);
				},
				error:function(data){
					layer.msg("没有数据");
				}
			});
		},
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
				$.post("userUpd", body.find("#memberinfo").serialize());
				layer.close(index);
				layer.msg("修改成功！", {
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

};


/**
 * 删除用户信息
 */
function userdel() {
	layer.open({
		type : 2, // page层
		area : [ '500px', '300px' ],
		title : '删除',
		skin : 'layui-layer-rim', // 样式类名
		closeBtn : 0, // 不显示关闭按钮
		shade : 0.3, // 遮罩透明度
		shadeClose : true, // 开启遮罩关闭
		moveType : 1, // 拖拽风格，0是默认，1是传统拖动
		shift : 1, // 0-6的动画形式，-1不开启
		content : 'meminfo',
		success : function(layero, index) {
			var body = layer.getChildFrame('body', index);
			$.ajax({
				url : 'userIdser',
				data : {
					userid : $("#sertext").val(),
				},
				type : 'post',
				dataType : 'json',
				success : function(data) {
					body.find("#usern").before("<div style = 'margin-bottom: 2%'><label>编号:</label><input type = 'text' id = 'userid' name = 'id' readonly='readonly' /></div>");
					body.find("#userid").val(data.id);
					body.find("#username").val(data.username);
					body.find("#usermobi").val(data.usermobi);
					body.find("#useradde").val(data.useradde);
				},
				error:function(data){
					layer.msg("没有数据");
				}
			});
		},
		btn : [ '确定', '取消' ],
		yes : function(index, layero) {
			var body = layer.getChildFrame('body', index);
			$.ajax({
				url:'userDel',
				data:{
					userid:body.find("#userid").val()
				},
				type:'post',
				dataType:'json',
				success:function(data){
					layer.msg("删除成功");
				},
				error:function(data){
					layer.msg("删除失败");
				}
			});
			
			layer.close(index);
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}

	});
};


/**
 * 新增用户信息
 */
function userIns(){
	layer.open({
		type : 2, // page层
		area : [ '500px', '300px' ],
		title : '新增',
		skin : 'layui-layer-rim', // 样式类名
		closeBtn : 0, // 不显示关闭按钮
		shade : 0.3, // 遮罩透明度
		shadeClose : true, // 开启遮罩关闭
		moveType : 1, // 拖拽风格，0是默认，1是传统拖动
		shift : 1, // 0-6的动画形式，-1不开启
		content : 'meminfo',
		success : function(layero, index) {

		},
		btn : [ '确定', '取消' ],
		yes : function(index, layero) {
			var body = layer.getChildFrame('body', index);
			$.ajax({
				url:'userIns',
				type:'post',
				dataType:'json',
				data:body.find("#memberinfo").serialize(),
				success:function(data){
					layer.msg("新增成功");
				},
				error:function(data){
					layer.msg("新增失败");
				}
			});
			
			layer.close(index);
		},
		btn2 : function(index, layero) {
			layer.close(index);
		}

	});
};


function docImport() {
	layer.open({
		type : 2, // page层
		area : [ '500px', '300px' ],
		title : '新增',
		skin : 'layui-layer-rim', // 样式类名
		closeBtn : 0, // 不显示关闭按钮
		shade : 0.3, // 遮罩透明度
		shadeClose : true, // 开启遮罩关闭
		moveType : 1, // 拖拽风格，0是默认，1是传统拖动
		shift : 1, // 0-6的动画形式，-1不开启
		content : 'fileinput'
	});
};