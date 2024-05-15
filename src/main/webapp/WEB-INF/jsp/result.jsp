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
	<b> 結果 </b>
	<div class="parent">
		<c:forEach var="i" begin="1" end="10">
			<c:out value="${i}" />問目：<c:out value="${result[i]}" />
			<br>
		</c:forEach>
		<br> <b>お疲れ様でした！</b><br>
		<br> <a href="MainServlet">メインへ戻る</a>
	</div>
	</div>
</body>
</html>