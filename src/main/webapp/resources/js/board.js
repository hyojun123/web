var common = {
			init : function() {
				$(".pagable").off().on('click', function () {
					common.pageClick($(this).data('number'));
				});
				
				$("#searchBtn").off().on('click', function () {
					common.pageMove($(this).data('number'));
				});
				
				$(".pageMove").off().on('click', function () {
					common.pageMove($(this).data('number'));
				});
				
				$(document).off().on('click','.detail', function () {
					
					search.viewBoard($(this).data('bno'));
				});
				
				$("#selectSearch").off().on('change', function () {
					search.changeType($(this).val());
				});
				
				$("#viewCnt").off().on('change', function () {
					draw.setViewCnt($(this).val());
				});
				
				$("#writeBoard").off().on('click', function () {
					writeBoard.write();
				});
			},
		
			pageClick : function(pageNumber) {
				if (pageNumber == "" || pageNumber == undefined) {
					$("#page").val(1);
				} else {
					$("#page").val(pageNumber);
				}
				
				$("#type").val($("#selectSearch").val());
				
				$.ajax({
					type		: "GET",
					url			: "/web/boardApi",
					data		: $('#frm').serialize(),
					success : function(result) {
						var resultData = JSON.parse(result);
						draw.drawTable(resultData);
					},
					error	: function(result) {
						console.log(result);
					}
				});
			},
			pageMove : function(page) {
				if (page == "" || page == undefined) {
					$("#page").val(1);
				} else {
					$("#page").val(page);
				}
				$("#type").val($("#selectSearch").val());
				$("#frm").attr("onsubmit","return true;");
				$("#frm").submit();
			},
	}
	
var draw = {
		drawTable : function (resultData) {
			var resultTbData = resultData.data;
			$(".data").remove();
			$("#first").val(resultData.first);
			$("#second").val(resultData.second);
			$("#type").val(resultData.type);
			$(".active").removeClass("active");
			$(this).addClass("active");
			if(resultData.searchType == "regdate") {
				$("#second").attr("style","");
			}
			
			$.each(resultTbData,function(index,item) {
				var str = "<tr class='data'>"
				+"<td>"+item.bno+"</td>"
				+"<td><a href='#' class='detail' data-bno='"+item.bno+"'>"+item.title+"</a></td>"
				+"<td>"+item.writer+"</td>"
				+"<td>"+item.viewcnt+"</td>"
				+"<td>"+item.regdate+"</td>"
				+"</tr>";
				
				$("#dataTbl").append(str);
			});
		},
		
		setViewCnt : function (rows) {
			$("#rows").val(rows);
			common.pageMove("");
		}
}

var writeBoard = {
		write	: function () {
			$('#frm').attr('action', '/web/getBoardDetail');
			$("#frm").attr('onsubmit','return true;');
			$("#frm").submit();
			
		}
}

var search = {
		changeType	: function(type) {
			$("#type").val(type);
			if (type=="regdate") {
				$("#second").attr('style','');
				$("#first").attr("placeholder","시작날짜");
				$("#second").attr("placeholder","마지막날짜");
			} else {
				$("#second").attr('style','display:none');
			}
		},
		
		viewBoard	: function (bno) {
			$("#bno").val(bno);
			$("#frm").attr("onsubmit","return true;");
			$("#frm").attr("action","/web/getBoardDetail");
			$("#frm").submit();
			
		}
}
