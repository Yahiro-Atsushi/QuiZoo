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
    <h1>チャレンジ終了!</h1>
    <h2>正解数 <c:out value="${answerCount}" /></h2><br>
    <div class="talking-left">
        <p>また挑戦してね</p>
    </div>
    <figure class="talking-left_icon">
        <img src="image/NotCorrectCat.png" alt="代替テキスト">
    </figure>
    <br><br>
        <div class="link-container">
                <a href="MainServlet">TOPへ</a>
        </div>
         
</div>
</body>
</html>
