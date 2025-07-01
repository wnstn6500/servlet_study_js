<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${list }">
				<tr onclick="location.href='/student/detail?no=${s.studentNo}'">
					<td>${s.studentNo }</td>
					<td>${s.studentName }</td>
					<td>${s.studentAge }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>