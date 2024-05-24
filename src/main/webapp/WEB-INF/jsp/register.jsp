<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
<link rel="stylesheet" href="css/register.css">
</head>
<body>
	<div style="text-align: center">
		<h1 class="text-outline-shadow">QuiZoo</h1>
	</div>

	<div style="text-align: center">
		<h2 class="text-outline-shadow_user">ユーザー登録</h2>

		<form action="RegisterServlet" method="post">

			<p style="text-align: center">
			<h4 class="text-outline-shadow_str">
				名前 <input type="text" name="name" value="<c:out value='${name}'/>">
			</h4>
			
			<div style="color: red;">
				<c:out value="${registerErrorMsg.nameError}" />
			</div>
			<br>

			<h4 class="text-outline-shadow_str">
				pass <input type="password" name="pass"
					value="<c:out value='${pass}'/>">
			</h4>
			
			<div style="color: red;">
				<c:out value="${registerErrorMsg.passError}" />
			</div>
			<br>
			<form action="RegisterServlet" method="post">
				<input type="submit" value="登録・ログイン" class="btn-submit"><br>
	</div>
	<div style="color: red;">
		<c:out value="${registerErrorMsg.userDoubleError}" />
	</div>
	</p>

	</form>
	<form action="LoginServlet" method="post">
		<input type="submit" value="トップ画面へ戻る" class="btn-submit"><br>
	</form>
</body>
</html>