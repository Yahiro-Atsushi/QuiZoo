<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/journal.css">
    <title>履歴一覧</title>
</head>
<body>
<div class="menu-container">
 <div class="sidebar">
            <h2>QuiZoo</h2>
            <ul>
            	<li><a href="MainServlet">TOP</a></li>
                <li><a href="JournalServlet">履歴</a></li>
                <li><a href="#">ランキング</a></li>
                <li class="logout-link"><a href="#">ログアウト</a></li>
            </ul>
 </div>
 <div class="content">
    <div class="quiz-container">
        <h1>履歴一覧</h1>

        <div class="history-list" style="text-align: center;">
            <table style="margin: 0 auto;">
                <h3>履歴がありません</h3>
                <p>まずは遊んでみてね！</p>
            </table>
        </div>
        <br><br>
        <div class="link-container">
            <a href="MainServlet" class="btn-return">TOPに戻る</a>
        </div>
    </div>
</div>
</div>
</body>
</html>
