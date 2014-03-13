<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My first JSP</title>
</head>
<style>
body {background-color: yellow;}
p {	color: blue;}
</style>
<body>
	<h1>My First Example JSP</h1>
	
	<c:import url="data.jsp" />
	
	<p>${message}</p>
	<c:choose >
		<c:when test="${not empty message1 }"><p>Hello World</p></c:when>
		<c:otherwise><p>goodbye world</p></c:otherwise>
	</c:choose>
	
	<!-- User enters info, then takes them to a servlet for display -->
	<form action="ServletTest" method="post">
		Please enter your name <br> <input type="text" name="name"
			size="20px"><br> Please type a password<br>
		<input type="password" name="password" size="20px"> <br>
		<input type="submit" value="submit here">
	</form>
</body>
</html>
