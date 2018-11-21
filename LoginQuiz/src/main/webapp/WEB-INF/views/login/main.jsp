<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${login == true }">
		${id } 님 환영합니다<br>
		<a href="/login/mypage">마이페이지</a>
		<a href="/login/logout">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href="/login/join">회원가입</a>
		<a href="/login/login">로그인</a>
	</c:otherwise>
</c:choose>
<c:if test="${login == false }">
	<script type="text/javascript">
		alert('로그인 실패');
	</script>
</c:if>
</body>
</html>