<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;" charset=UTF-8>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row"> 
			<h3>게시판  <a href="/logout"> 로그아웃 </a> </h3>
		</div>
		<div class="row">
			<form method="post" action="/board/list">
				<div class="form-group" style="display:inline-block;">
	              <select name="searchType" class="form-control">
	                <option value="0" <c:out value="${searchType==0? 'selected':''}"/>>제목</option>
		            <option value="1" <c:out value="${searchType==1? 'selected':''}"/>>내용</option>
		            <option value="2" <c:out value="${searchType==2? 'selected':''}"/>>작성자</option>
	              </select>
	            </div>
				<div class="form-group" style="display:inline-block">		
					<input class="form-control" name="search" value="${search }">
				</div>
				<div style="display:inline-block" >
					<button type="submit" class="btn">search</button>
				</div>
			</form>
		</div>
		<div> 	
			<table class="table table-dark table-striped">
			    <thead>
					<tr>
			        	<th style="width:20%;">번호</th>
			        	<th style="width:60%;">제목</th>
			        	<th style="width:20%;">작성자</th>
			      	</tr>
			    </thead>
			    
			    <tbody>
			    	<c:forEach items="${list}" var="board">
			    	<tr>
		    			<td>${board.number}</td>
			        	<td ><a href="/board/detail?number=${board.number}" style="color:white">${board.title}</a></td>
			        	<td>${board.author}</td>
			        </tr>
			        </c:forEach>
			    </tbody>
			  </table>
		  </div>
		  <ul class="pagination">
		  	<c:if test="${pm.prev}">
			  <li class="page-item"><a class="page-link" href="/board/list?page=${pm.getStartPage()-1 }&search=${search}&searchType=${searchType}">Previous</a></li>
			</c:if>
			
			<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
			  <li class="page-item"
			  	<c:out value="${pm.page.page == idx?'style=font-weight:700':''}"/>>
			  <a class="page-link" href="/board/list?page=${idx }&search=${search}&searchType=${searchType}">${idx }</a></li>
			</c:forEach>
			
			<c:if test="${pm.next }"> 
			  <li class="page-item"><a class="page-link" href="/board/list?page=${pm.getEndPage()+1}&search=${search}&searchType=${searchType}">Next</a></li>
		  	</c:if>
		  </ul>
		 <div class="row">
			  <a href="/board/write" style="margin: 0 0 0 10px;">
			  	<button class="btn btn-default"> 글쓰기 </button>
			  </a>
		</div>  
	</div>
	
</body>
</html>