<%@ page 	language="java" 
			contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>    		    		
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    		

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="./common/header.jsp" %> 
	
	<c:if test="${ loginUser == null }">
	<div align="right">
		<form action="login.kdt" method="post">
			<label>
				아이디 : 
				<input type="text" name="id">
			</label>
			<label>
				패스워드 : 
				<input type="password" name="pwd">
			</label>
			<button type="submit">LOGIN</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onClick="joinHandler()">JOIN</button>
		</form>
	</div>
	</c:if>
	<c:if test="${ loginUser != null }">
		<div align="right">
			${loginUser.getName()}님 환영합니다.
			&nbsp;&nbsp;&nbsp;
			<button type="button" onClick="logoutHandler()">로그아웃</button>
			</p>
	
			<a href="list.kdt">목록보기</a>
		</div>
	</c:if>
	
	<%@ include file="./common/footer.jsp" %>
	
	<script>
		// 해당 이벤트 발생시 JoinController 를 통해서 
		// joinForm.jsp 페이지로 이동할것 
		// 분기 방식은 true 로 해서 forward 방식으로 
		function joinHandler() {
			location.href="joinform.kdt" ; 
		}
		
		function logoutHandler() {
			location.href="logout.kdt";
		}
		
		
	</script>
</body>
</html>