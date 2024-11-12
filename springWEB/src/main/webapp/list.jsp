<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page	import="mvc.user.domain.UserResponseDTO" %>
    <%@ page	import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table class="table">
			<thead>
				<tr>
					<th>아이디</th><th>패스워드</th><th>이름</th>
				</tr>
			</thead>
			<c:forEach items="${lst}" var="user">
			<tr>
				<td>${ user.id }</td>
				<td>${ user.pwd }</td>
				<td>${ user.name }</td>
			</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>