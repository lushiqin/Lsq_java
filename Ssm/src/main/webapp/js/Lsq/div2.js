/*严格模式
"use strict";
 */

$(document).ready(
		function() {
			$.ajax({
				url : 'userser',
				type : 'post',
				dateTpye : 'json',
				success : function(data) {
					var str = "";
					$.each(data, function(i, n) {
						str += "<li ><a href = '#' class = 'navmsg' id = '"
								+ n.id + "'>" + n.username + "</a>&nbsp</li>";
					});
					$(".nav").html(str);

					var num = $(".navmsg");
					for (var i = 0; i < num.length; i++) {
						$(num[i]).on("mouseover", function() {
							var id = $(this).attr("id");

							$.ajax({
								url : 'userIdser',
								type : 'post',
								dateType : 'json',
								data : {
									userid : id
								},
								success : function(data) {
									$("#mobi").text(data.usermobi);
									$("#addr").text(data.useradde);
								},
								error : function(data) {
									layer.msg(data);
								}
							});

							$(".navmsgs").addClass("show");
							$(".navmsgs").css("left", "0px");
							$(this).on("mouseout", function() {
								$(".navmsgs").removeClass("show");
							})
						});
					}

				},
				error : function(data) {
					layer.msg(data);
				}
			});
		});



$(".num").on("mouseover",function(){
	$(".banner").css("left","-200px");
	$(this).on("mouseout",function(){
		$(".banner").css("left","0px");
	});
});






