<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="contents">
<div class="parent">
<jsp:include page="timer.jsp" />
<form action="JudgeServlet" method="post">
<b>
問<c:out value="${game.quizCount}" />
</b>
<br><br>
<c:out value="${question}" /><br><br>
<input type="submit" name="input" value="${button1}">
　<input type="submit" name="input" value="${button2}">
　<input type="submit" name="input" value="${button3}">
　<input type="submit" name="input" value="${button4}">
</form>
</div>
</div>
</body>
</html>