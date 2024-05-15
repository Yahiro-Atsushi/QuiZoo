<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/answer.css">
<title>QuiZoo</title>
</head>
<body>
<div class="quiz-container">    
    <h1>残念!!</h1>
    <h2>正解は<c:out value="${answer}" /></h2>
        
        <figure class="talking-left_icon">
           <img src="アイコン画像のURL" alt="代替テキスト">
        </figure>
        
        <div class="talking-left">
            <c:out value="${text}" />
         </div><br><br><br><br><br>
      <a href="GameServlet">次の問題へ</a>
</div>
</body>
</html>
</html>