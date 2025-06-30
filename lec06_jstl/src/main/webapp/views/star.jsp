<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>별 출력</title>
</head>
<body>

	<c:forEach var="num" begin="1" end="${count}" varStatus="vs">
			
		<c:forEach var="num2" begin="1" end="${num}" varStatus="vs">
		
		⭐	
		
	</c:forEach>	
	<br>
	</c:forEach>

</body>
</html>