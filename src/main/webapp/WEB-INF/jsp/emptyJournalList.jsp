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
<div class="sidebar">
            <h1>QuiZoo</h1>
            <ul>
            	<li><a href="MainServlet">TOP</a></li>
                <li><a href="JournalServlet">履歴</a></li>
                <li><a href="RankingServlet">ランキング</a></li>
                <li class="logout-link"><a href="LogoutServlet">ログアウト</a></li>
            </ul>
 </div>
    <div class="quiz-container">
        <h1>履歴一覧</h1>

        <div class="history-list" style="text-align: center;">
            <table style="margin: 0 auto;">
                <h2>履歴がありません</h2>
                <p>まずは遊んでみてね！</p>
            </table>
        </div>
        <br><br>
        <div class="link-container">
            <a href="MainServlet" class="btn-return">メニューに戻る</a>
        </div>
    </div>
</body>
</html>
