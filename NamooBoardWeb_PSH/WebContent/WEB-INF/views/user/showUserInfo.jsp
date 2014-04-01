<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 상세정보 보기</title>
</head>
<body>
<form action="./list.do" method="post">
<table>
<tr>
<th>ID</th>
<td>${user.userId}</td>
</tr>
<tr>
<th>이름</th>
<td>${user.name}</td>
</tr>
<tr>
<th>이메일</th>
<td>${user.email}</td>
</tr>
</table>
<input type="submit" value="확인" />
</form>
<button onclick="location.href='${ctx}/user/remove.do?userId=${user.userId}';">삭제하기</button>
</body>
</html>