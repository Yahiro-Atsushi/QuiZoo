<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>QuiZoo</title>
    <link rel="stylesheet" href="css/journal.css">
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
            <h1>履歴</h1>
            <p class="date">回答した日付: <c:out value="${journal.playDate}" /></p>
            <c:forEach var="i" begin="1" end="10">
                <div class="question-item">
                    <p><strong>問題文:</strong> <c:out value="${quizMap[i].questionMsg}" /></p>
                    <p><strong>答え:</strong> <c:out value="${quizMap[i].answer}" /></p>
                    <!-- <p><strong>解説:</strong> <c:out value="${quizMap[i].}" /></p> -->
                    <p><strong>あなたの解答:</strong></p>
                     <span class="${question.correct ? 'correct' : 'incorrect'}">
                        <c:out value="${journal.quizResults[i]}" /> (<c:out value="${question.correct ? '正解' : '不正解'}" />)
                    </span></p>
                </div>
            </c:forEach>
            <div class="summary">
            <p>10問中 <c:out value="${journalPort.correctCount}" /> 問正解</p>
        </div>
        </div>
		<br>
        <div class="link-container">
            <a href="JournalServlet" class="btn-return">一覧へ戻る</a>
        </div>
    </div>
</div>
</body>
</html>
