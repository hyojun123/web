<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<jsp:include page="ScriptAndCss.jsp"></jsp:include>
<script type="text/javascript" src="js/board.js"></script>
<script>
	$(document).ready(function() {
		common.init();
	});
</script>
<body>
<div class="container">
	<select id="viewCnt">
		<option value="10" <c:if test='${paging.rows eq "10"}'>selected="selected"</c:if>>10</option>
		<option value="20" <c:if test='${paging.rows eq "20"}'>selected="selected"</c:if>>20</option>
		<option value="30" <c:if test='${paging.rows eq "30"}'>selected="selected"</c:if>>30</option>
		<option value="40" <c:if test='${paging.rows eq "40"}'>selected="selected"</c:if>>40</option>
		<option value="50" <c:if test='${paging.rows eq "50"}'>selected="selected"</c:if>>50</option>
	</select>
</div>
<div class="container">
	<select id="selectSearch">
		<option value="writer" <c:if test='${paging.type eq "writer"}'>selected="selected"</c:if>>글쓴이로 검색</option>
		<option value="regdate" <c:if test='${paging.type eq "regdate"}'>selected="selected"</c:if>>날짜별로 검색</option>
		<option value="title" <c:if test='${paging.type eq "title"}'>selected="selected"</c:if>>제목으로 검색</option>
	</select>
	<form id="frm" class="form-search" action="/web/getBoard" method="GET" onsubmit="return false;">
	  <input type="text" class="input-medium search-query" id="first" name="first" value='<c:if test="${paging.first ne null}">${paging.first}</c:if>'>
	  <input type="hidden" id="page" name="page" value='<c:if test="${paging.page ne null}">${paging.page}</c:if>'>
	  <input type="hidden" id="rows" name="rows" value='<c:if test="${paging.rows ne null}">${paging.rows}</c:if>'>
	  <input type="hidden" id="bno" name="bno">
	  <input type="text" class="input-medium search-query" id="second" name="second" 
	  <c:choose>
	  	<c:when test="${paging.type eq 'regdate'}"></c:when>
	  	<c:otherwise>style="display: none"</c:otherwise>
	  </c:choose>value='<c:if test="${paging.second ne null}">${paging.second}</c:if>'>
	  <input type="hidden" id="type" name="type" <c:if test="${paging.type ne null}">value = "${paging.type}"</c:if>>
	  <input type="submit" id="searchBtn" class="btn" value="검색"/>
	</form>
</div>
<div>
	<table id="dataTbl" class="table table-striped table-bordered table-hover">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>조회수</td>
			<td>작성시간</td>
		<tr>
		<c:forEach var="board" items="${boardList}">
			<tr class="data">
				<td><c:out value="${board.bno}"/></td>
				<td><a href="#" class="detail" data-bno="${board.bno}"><c:out value="${board.title}"/></a></td>
				<td><c:out value="${board.writer}"/></td>
				<td><c:out value="${board.viewcnt}"/></td>
				<td><c:out value="${board.regdate}"/></td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
	  <ul>
	  		<c:if test="${paging.pageGroup > 1}">
	  			<li><a href="#" class="pageMove" data-number="1">처음페이지</a></li>
	  			<li><a href="#" class="pageMove" data-number="${paging.prePage}">이전</a></li>
	  		</c:if>
	  		<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}" step="1">
		  		<c:choose>
	                <c:when test="${i eq paging.page}">
	                    <li class="active"><a href="#" class="pagable" data-number="${i}">${i}</a></li>
	                </c:when>
	                <c:otherwise>
                		<li><a href="#" class="pagable" data-number="${i}">${i}</a></li>
	                </c:otherwise>
	            </c:choose>
		  	</c:forEach>
		  	<c:if test="${paging.pageGroup < paging.endPageGroup}">
		  			<li><a href="#" class="pageMove" data-number="${paging.nextPage}">다음</a></li>
		  			<li><a href="#" class="pageMove" data-number="${paging.totalPage}">마지막페이지</a></li>
	  		</c:if>
	  </ul>
	</div>
</div>
<div>
	<a class="btn btn-primary" id="writeBoard">글쓰기</a>
</div>
</body>
</html>
