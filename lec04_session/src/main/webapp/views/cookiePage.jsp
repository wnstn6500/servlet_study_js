<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 연습하기</title>
</head>
<body>


	<%
	Cookie[] cookies = request.getCookies();
	String userId = "_____";

	// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("user_name")){
					userId = c.getValue();
					break;
				}
			}
		}
	%>
	<h1>닉네임</h1>
	<p>닉네임: <%=userId %></p>
	
	
	<form action="/saveNick" method="post">
	    <input type="text" name="nickName" placeholder="닉네임 입력">
	    <input type="submit" value="저장">
	</form>
	
	<form action="/removeNick" method="post">   
	    <input type="submit" value="삭제" name="remove">    
	</form>
</body>
</html>