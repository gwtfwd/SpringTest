<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<form method="post" class="offset-3 col-6">
		<div class="text-center">회원 가입</div>
		<div class="form-group">
	  		<label for="id">ID:</label>
	  		<input type="text" class="form-control" name="id">
		</div>
		<div class="form-group">
	  		<label for="pw">Password:</label>
	  		<input type="password" class="form-control" name="pw">
		</div>
		<div class="form-group">
	  		<label for="pw">Password Confirm:</label>
	  		<input type="password" class="form-control" name="pwConfirm">
		</div>
		<div class="form-group">
	  		<label for="pw">email:</label>
	  		<input type="email" class="form-control" name="email">
		</div>
		<button type="submit" class="btn btn-outline-primary 
			col-12">로그인</button>
	</form>
	<div class="offset-3 col-6">
		<a href="/" class="text-center">
		홈으로
		</a>
	</div>
</body>
</html>