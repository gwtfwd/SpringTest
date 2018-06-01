<%@ page language="java" contentType="text/html;
	charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<form method="post" action="/main" class="offset-3 col-6">
		<div class="text-center">로그인 화면</div>
		<div class="form-group">
	  		<label for="id">ID :</label>
	  		<input type="text" class="form-control" name="id" autocomplete=off>
		</div>
		<div class="form-group">
	  		<label for="pw">Password :</label>
	  		<input type="password" class="form-control" name="pw">
		</div>
		<button type="submit" class="btn btn-outline-primary 
			col-12">로그인</button>
	</form>
	<div class="offset-3 col-6">
		<a href="/member/signup" class="text-center">
		회원가입
		</a>
	</div>
</body>
</html>
