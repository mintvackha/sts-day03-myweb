<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>사용자 상세보기</h1>
	<table class="table table-bordered">
		<tr>
			<th width="20%">ID</th><td width="80%">${user.id }
			</td>
		</tr>
		
		<tr><th>PASSWORD</th><td>${user.password }
		</td></tr>
		<tr><th>NAME</th><td>${user.name }
		</td></tr>
		<tr><th>ROLE</th><td>${user.role }
		</td></tr>
		
		
	</table>
	
	
	<a href="user.list">목록</a>
	<a href="update.do?seq=${user.id }">정보 수정</a>
	<a href="delete.do?seq=${user.id }">유저 삭제</a>
</body>
</html>