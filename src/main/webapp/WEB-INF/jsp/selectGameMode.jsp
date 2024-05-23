<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QuiZoo</title>
    <link rel="stylesheet" href="styles.css"> <!-- 上記CSSファイルのリンク -->
</head>
<body>
    <div class="container">
        <div class="title">難易度を選択してね</div>
        <form action="GameServlet">
            <button type="submit" name="mode" value="<c:out value='${easy}'/>">簡単</button>
            <button type="submit" name="mode" value="<c:out value='${normal}'/>">普通</button>
            <button type="submit" name="mode" value="<c:out value='${hard}'/>">難しい</button>
            <button type="submit" name="mode" value="<c:out value='${challenge}'/>">チャレンジ</button>
        </form>
        <div >※チャレンジモードは間違えるまで続くよ！</div>
        <li><a href="MainServlet">メニューに戻る</a></li>
    </div>
</body>
</html>