<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="ScriptAndCss.jsp"></jsp:include>
<script type="text/javascript" src="js/boardDetail.js"></script>
<script>
	$(document).ready(function() {
		common.init();
	})
</script>
<title>Insert title here</title>
</head>
<body>
	  		<c:choose>
	  			<c:when test="${board ne null}">
	  			<div class="container">
					<table class="table table-bordered">
						<tr>
							<td>글번호</td>
							<td>
								<c:if test="${board ne null}">
									<c:out value="${board.bno }"/>
								</c:if>
							</td>
						</tr>
				  		<tr>
				  			<td>제목</td>
							<td>
								<c:if test="${board ne null}">
									<c:out value="${board.title}"/>
								</c:if>
							</td>
				  		</tr>
				  		<tr>
				  			<td>작성자</td>
				  			<td>
								<c:if test="">
									<c:out value="${board.writer}"/>
								</c:if>
							</td>
				  		</tr>
				  		<tr>
				  			<td>작성시간</td>
				  			<td><c:out value="${board.regdate}"/></td>
				  		</tr>
				  		<tr>
				  			<td>내용</td>
				  			<td>
								<c:if test="${board ne null}">
									<c:out value="${board.content}"/>
								</c:if>
							</td>
				  		</tr>
			  		</table>
				</div>
		  		</c:when>
		  		<c:otherwise>
		  		<div class="container">
		  			<form method="POST" action="/web/writeBoard" id="writeFrm" onsubmit="return false;" >
						<table class="table table-bordered">
				  			<tr>
				  				<td>제목</td>
				  				<td><input type="text" name="title" id="title" placeholder="제목을 입력하세요"/></td>
				  			</tr>
				  			<tr>
				  				<td>작성자</td>
				  				<td><input type="text" name="writer" id="writer" placeholder="작성자를 입력하세요"/></td>
				  			</tr>
				  			<tr>
				  				<td>작성내용</td>
				  				<td><textarea rows="10" cols="200" name="content" id="content" placeholder="내용을 입력하세요"></textarea></td>
				  			</tr>
			  			</table>
			  			<input type="submit" value="글작성" class="btn btn-primary" id="doWrite"/>
			  		</form>
				</div>	
		  		</c:otherwise>
	  		</c:choose>
	  		<div class="container">
				<form id="pagingFrm" action="/web/getBoard"">
	  				<input type="hidden" id="page" name="page" value='<c:if test="${paging.page ne null}">${paging.page}</c:if>'>
	  				<input type="hidden" id="first" name="first" value='<c:if test="${paging.first ne null}">${paging.first}</c:if>'>
	  				<input type="hidden" id="type" name="type" value='<c:if test="${paging.type ne null}">${paging.type}</c:if>'>
	  				<input type="hidden" id="second" name="second" value='<c:if test="${paging.second ne null}">${paging.second}</c:if>'>
	  				<input type="hidden" id="rows" name="rows" value='<c:if test="${paging.rows ne null}">${paging.rows}</c:if>'>
	  				<input type="submit" class="btn btn-primary" value="목록으로 가기">
				<c:if test="${board ne null}">
					<a class="btn btn-primary">수정</a>
				</c:if>
	  			</form>
  			</div>
			<c:if test="${board ne null}">
				<div class="container">
					<pre>댓글</pre>
					<form action="">
						<textarea class="form-control" rows="3"></textarea>
						<button type="button" class="btn btn-default">입력</button>
					</form>
				</div>
			</c:if>
</body>
</html>