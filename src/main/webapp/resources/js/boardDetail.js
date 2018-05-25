var common = {
		init : function () {
			$("#doWrite").off().on('click', function() {
				write.check();
			});
			$("#back").off().on('click', function() {
				back.back();
			});
		}
}

var write ={
		doWrite : function () {
			$("#writeFrm").attr("onsubmit", "return true;");
			$("#writeFrm").submit();
		},
		check	: function () {
			var input = $("#writeFrm input");
			
			$.each(input, function(i,index) {
				if($(index).val().length == 0) {
					alert("모든 항목은 필수 값 입니다.");
					return false;
				};
			});
			
			this.doWrite();
		}
}

var back = {
		back	: function () {
			$("#pagingFrm").submit();
		}
}