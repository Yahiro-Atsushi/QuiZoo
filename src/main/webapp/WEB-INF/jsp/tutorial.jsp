<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チュートリアル</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="contents"></div>
<h1>チュートリアル</h1>
<div class="parent">
<form action="TutorialServlet" method="post">
<b>問1</b>
<br><br>
にゃーんと鳴く動物は？<br><br><br>
<input type="submit" name="input" value="犬">
<input type="submit" name="input" value="猫">
<input type="submit" name="input" value="人間">
<input type="submit" name="input" value="ゴリラ">
</form>
</div>
</div>
</body>
</html>