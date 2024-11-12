<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="joinUser" method="get">
	<div align="center">
		<label>
			아이디 : 
			<input type="text" name="id">
		</label>
		<br>
		<label>
			비밀번호 : 
			<input type="password" name="pwd">
		</label>
		<br>
		<label>
			이름 : 
			<input type="text" name="name">
		</label>
			<br>
		<label>
			성별 : 
			<input type="text" name="gender">
		</label>
		<br>
		<button type="submit" class="btn btn-primary">가입</button>
		<button type="submit" class="btn btn-primary">가입취소</button>
	</div>
	</form>
</body>
</html>