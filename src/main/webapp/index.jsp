<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>

	<div style="text-align: center">
		<p class="text-outline-shadow">QuiZoo</p>
	</div>

	<div style="text-align: center">
		<form action="LoginServlet" method="post">
			<h4 class="text-outline-shadow_str">
				名前<input type="text" name="name" value="<c:out value='${name}'/>"><br>
			</h4>
			
			<c:if test="${ not empty loginErrorMsg.nameError }">
				<div class="errorMsg">
					<c:out value="${loginErrorMsg.nameError}" />
				</div>
			</c:if>
			<div style="color: red;">
				<c:out value="${}" />
			</div>
			
			<br>
			<div style="text-align: center">
				<h4 class="text-outline-shadow_str">
					pass<input type="password" name="pass"
						value="<c:out value='${pass}'/>"><br>
				</h4>
				
				<c:if test="${ not empty loginErrorMsg.passError }">
					<div class="errorMsg">
						<c:out value="${loginErrorMsg.passError}" />
					</div>
				</c:if>
				
				<br> <input type="submit" value="ログイン" class="btn-submit"><br>
				
				<c:if test="${ not empty loginErrorMsg.notUser }">
					<div class="errorMsg">
						<c:out value="${loginErrorMsg.notUser}" />
					</div>
				</c:if>
		</form>
	</div>
<br>
	<form action="LoginServlet" method="get">
		<div style="text-align: center">
			<input type="submit" value="新規登録" class="btn-submit">
	</form>
	</div>
	
</body>
</html>