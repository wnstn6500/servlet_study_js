<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.gn.dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니에 담기</title>
</head>
<body>
	<%
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1001, "키보드", 25000));
		list.add(new Product(1002, "마우스", 15000));
		list.add(new Product(1003, "모니터", 180000));
	%>
	<form action="/selectProduct"></form>
	<select name="bucketOption">
		<%for(Product p:list){%>
			<option value=<%= p.getCode() %>><%= p.getName() %></option>
	
		<%}%>
		
	</select>
</body>
</html>