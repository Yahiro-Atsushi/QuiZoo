<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="contents"></div>
	<h1>チュートリアル</h1>
	<div class="parent">
		正解は
		<c:out value="${answer}" />
		<br>
		<br> 正解やで
	</div>
	<div class="parent">>
		<li><a href="MainServlet">メニュー画面に戻る</a></li>
	</div>
	</div>
</body>
</html>