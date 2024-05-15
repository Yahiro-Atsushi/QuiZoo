<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
<link rel="stylesheet" href="css/quiz.css">
</head>
<body>

	<div class="quiz-container">
		<h1>
			<b> 問<c:out value="${game.quizCount}" />
		</h1>
		<div class="question">
			<c:out value="${question}" />
		</div>
		<jsp:include page="timer.jsp" />
		<div class="choices">
			<form action="JudgeServlet" method="post">
				<input type="submit" name="input" value="${button1}">　 
				<input type="submit" name="input" value="${button2}">　
				<input type="submit" name="input" value="${button3}">　
				<input type="submit" name="input" value="${button4}">
			</form>
		</div>
	</div>
	</div>
	</div>
</body>
</html>