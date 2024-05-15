<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
=======
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
>>>>>>> efcc590 (Merge branch 'main' of https://github.com/Yahiro-Atsushi/QuiZoo)
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>QuiZoo</title>
</head>
<body>
<<<<<<< HEAD
<div class="contents"></div>
<b>
問<c:out value="${game.quizCount}" />
</b>
<div class="parent">
<b>残念！</b><br><br>
正解は<c:out value="${answer}" /><br><br>
解説<br><br>
<c:out value="${text}" /><br><br>
<a href="GameServlet">次の問題へ</a>
</div>
</div>
=======
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
>>>>>>> efcc590 (Merge branch 'main' of https://github.com/Yahiro-Atsushi/QuiZoo)
</body>
</html>