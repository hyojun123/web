<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<jsp:include page="ScriptAndCss.jsp"></jsp:include>
<script type="text/javascript" src="js/exam.js"></script>
<script>
	$(document).ready(function() {
        common.init();
	});
</script>
<body>
	<button id="exam">버튼</button>
</body>
</html>
