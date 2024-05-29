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
        <div class="title">難易度を選択してゲームスタートします！</div>
        <form is="modeForm" action="GameServlet">
            <button type="submit" name="gameMode" 
            		value="<c:out value='${easy}'/>" 
            		id="easy">簡単</button>
            <button type="submit" name="gameMode" 
            		value="<c:out value='${normal}'/>" 
            		id="normal">普通</button>
            <button type="submit" name="gameMode" 
            		value="<c:out value='${hard}'/>" 
            		id="hard">難しい</button>
            <button type="submit" name="gameMode" 
            		value="<c:out value='${challenge}'/>" 
            		id="challenge">チャレンジ</button>
        </form>
        <div >※チャレンジモードは間違えるまで続くよ！</div>
        
         <div style="text-align: center">
            <div class="button003">
        <a href="MainServlet">メニューに戻る</a>
    </div>
</body>
</html>