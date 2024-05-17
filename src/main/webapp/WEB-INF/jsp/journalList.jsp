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
                <li><a href="JournalServlet">履歴</a></li>
                <li><a href="#">ランキング</a></li>
                <li class="logout-link"><a href="#">ログアウト</a></li>
            </ul>
 </div>
    <div class="quiz-container">
        <h1>履歴一覧</h1>

        <div class="history-list" style="text-align: center;">
            <table style="margin: 0 auto;">
                <thead>
                    <tr>
                        <th>日付</th>
                        <th>正解数</th>
                        <th>詳細</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" begin="1" end="10">
                        <tr>
                            <td><c:out value="2024/05/17"/></td>
                            <td><c:out value="${i}"/></td>
                            <td>
                                <form action="JournalServlet" method="post">
                                    <input type="hidden" name="journalId" value="${3}">
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
            <a href="MainServlet" class="btn-return">メニューに戻る</a>
        </div>
    </div>
</body>
</html>
