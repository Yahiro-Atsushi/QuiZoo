<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
</head>
<body>
	<div style="text-align: center">
		<h1>QuiZoo</h1>
		<h2>ユーザー登録</h2>
		<form action="RegisterServlet" method="post">
			<p style="text-align: center">
				名前<input type="text" name="name" value="<c:out value='${name}'/>"><br>
			<div style="color: red;">
				<c:out value="${registerErrorMsg.nameError}" />
			</div>
			<br> pass<input type="password" name="pass"
				value="<c:out value='${pass}'/>"><br>
			<br>
			<div style="color: red;">
				<c:out value="${registerErrorMsg.passError}" />
			</div>
			<br> <input type="submit" value="登録・ログイン">
			<div style="color: red;">
				<c:out value="${registerErrorMsg.userDoubleError}" />
			</div>
			</p>
		</form>
		<a href="index.jsp">トップ画面へ戻る</a>
		
	</div>
</body>
</html>