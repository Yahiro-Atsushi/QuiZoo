<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QuiZoo</title>
    <link rel="stylesheet" href="css/gamemode.css">
</head>
<body>
    <div class="container">
        <div class="title">前回のゲーム中に異常終了したようです</div>
        <div>再開しますか？</div>
        <form action="AbendGameServlet">
            <button type="submit" name="action" value="はじめから">はじめから</button>
            <button type="submit" name="action" value="つづきから">つづきから</button>
        </form>
        <li><a href="MainServlet">メニューに戻る</a></li>
    </div>
</body>
</html>