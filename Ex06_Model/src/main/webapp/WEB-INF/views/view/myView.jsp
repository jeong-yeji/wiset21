<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	out.println("Model(Sub) : Hello World");
	%>
	<br>
	
	${ObjectTest}
	
	<br>
	
	${lists}
	
	<br>
	<br>
	
	<c:forEach var="mylist" items="${lists}">
	${mylist} <br>
	</c:forEach>
	
	<br>
	<br>
	����� �̸��� ${name} �Դϴ�.
</body>
</html>