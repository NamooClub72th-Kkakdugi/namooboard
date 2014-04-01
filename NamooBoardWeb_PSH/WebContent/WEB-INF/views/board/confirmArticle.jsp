<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 작성 확인하기</title>
<style type="text/css">
table,th,td {
	border: 1px solid #222;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>${article.articleNo}</th>
				<th>${article.regDate}</th>
				<th>${article.author}</th>
			</tr>
			<tr>
				<td colspan="3">${article.subject}</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="3">${article.content}</td>
			</tr>
		</tbody>
	</table>
	<button onclick="location.href='${ctx}/board/articleList.do?boardNo=${boardNo}'">확인</button>
</body>
</html>