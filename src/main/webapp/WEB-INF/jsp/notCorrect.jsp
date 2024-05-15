<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>QuiZoo</title>
</head>
<body>
	<div class="contents"></div>
	<b> 問<c:out value="${game.quizCount}" />
	</b>
	<div class="parent">
		<b>残念！</b><br><br>
		正解は<c:out value="${answer}" />
		<br>
		<br>
		解説<br><br>
		<c:out value="${text}" />
		<br><br>
		<a href="GameServlet">次の問題へ</a>
	</div>
	</div>
</body>
</html>