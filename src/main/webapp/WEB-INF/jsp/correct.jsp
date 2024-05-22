<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
<link rel="stylesheet" href="css/answer.css">
</head>
<body>
<div class="quiz-container">    
    <h1>正解!</h1>
    <h2>正解は<c:out value="${answer}" /></h2><br>
    <div class="talking-left">
        <c:out  value="${text}" />
    </div>
    <figure class="talking-left_icon">
        <img src="image/CorrectCat.png" alt="代替テキスト">
    </figure>
    <br><br>
    <c:choose>
        <c:when test="${game.quizCount == 11}">
            <div class="link-container">
                <a href="GameServlet">解答結果へ</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="link-container">
                <a href="GameServlet">次の問題へ</a>
            </div>
        </c:otherwise>
    </c:choose>     
</div>
</body>
</html>
