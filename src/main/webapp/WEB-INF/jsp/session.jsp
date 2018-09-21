<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Boot Sample3</title>
</head>
<body>
	<h1>session:${sessionScope.content}</h1>
	<h1>session:<%=session.getAttribute("content")%></h1>
</body>
</html>