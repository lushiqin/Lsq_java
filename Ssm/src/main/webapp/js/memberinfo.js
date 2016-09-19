/*严格模式
"use strict";
 */
$(document).ready(function() {
	$.ajax({
		url : "userList",
		type : "post",
		dataType : 'json',
		data : '',
		success : function(data, textStatus) {
			var str = '';
			$.each(data, function(i, n) {
				str += '<tr>';
				str += '	<td>'+n.id+'</td>';
				str += '	<td>'+n.username+'</td>';
				str += '	<td>'+n.usermobi+'</td>';
				str += '	<td>'+n.useradde+'</td>';
				str += '</tr>';
			});
			$("#tbody").html(str);
		},
		error : function(data) {
			layer.msg("失败咯" + data);
			$.each(data, function(i, n) {
				layer.msg(i + "---" + n);
			});
		}
	});
});