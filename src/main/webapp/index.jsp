<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
</head>
<body>
	<h1 style="text-align:center">QuiZoo</h1>
	<form action=" LoginServlet" method="post">
	<p  style="text-align:center">
		名前<input type="text" name="name"><br>
		pass<input type="password" name="pass"><br><br>
		<input type="submit" value="ログイン">
	</p>
	</form>
	<form action=" RegisterServlet">
	<p  style="text-align:center">	
		<input type="submit" value="新規登録">
	</form>
	</p>
</body>
</html>