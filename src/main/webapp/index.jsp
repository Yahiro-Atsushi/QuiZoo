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
		<form action="LoginServlet" method="post">
			<p>
				名前<input type="text" name="name" value="<c:out value='${name}'/>"><br>
				<div style="color: red;">
						 <c:out value="${loginErrorMsg.nameError}" />
				 </div>
			<br>
		pass<input type="password" name="pass" value="<c:out value='${pass}'/>"><br>
				<br> <div style="color: red;">
				<c:out value="${loginErrorMsg.passError}" />
				 </div>
			<br>
		<input type="submit" value="ログイン">
			</p>
			
	</form>
</div>

<div style="text-align:center">	
	<form action="LoginServlet" method="get">
		<input type="submit" value="新規登録">
	</form>
</div>
<div style="color: red;">
		<c:out value="${loginErrorMsg.notUser}" />
	</div>
</body>
</html>