<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
<link rel="stylesheet" href="css/ranking.css">
</head>
<body>
    <div class="menu-container">
        <div class="sidebar">
            <h2>QuiZoo</h2>
            <ul>
                <li><a href="MainServlet">TOP</a></li>
                <li><a href="JournalServlet">履歴</a></li>
                <li><a href="RankingServlet">ランキング</a></li>
                <li class="logout-link"><a href="LogoutServlet">ログアウト</a></li>
            </ul>
        </div>
        <div class="content">
            <div class="quiz-container">
                c
                <div class="history-list" style="text-align: center;">
                    <table style="margin: auto;">
                        <thead>
                            <tr>
                                <th>順位</th>
                                <th>プレイヤー名</th>
                                <th>正解数</th>
                                <th>詳細</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i" begin="1" end="10">
                                <tr>
                                    <td><p>1位</p></td>
                                    <td><p>末永さん</p></td>
                                    <td><p>10問</p></td>
                                    <td>
                                        <form action="JournalServlet" method="post">
                                            <input type="hidden" name="historyId" value="${3}">
                                            <input type="submit" value="詳細を見る">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
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
