<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<title>QuiZoo</title>
</head>
<body>
    <div class="menu-container">
        <div class="sidebar">
            <h2>QuiZoo</h2>
            <ul>
            	<li><a href="MainServlet">TOP</a></li>
                <li><a href="TutorialServlet">遊び方</a></li>
            	<li><a href="SelectGameModeServlet">ゲーム開始</a></li>
                <li><a href="JournalServlet">履歴</a></li>
                <li><a href="ChallengeRankingServlet">ランキング</a></li>
                <li class="logout-link"><a href="LogoutServlet">ログアウト</a></li>
            </ul>
        </div>
        <div class="content">
            <h1 class="title" style="font-size: 100px;">QuiZoo</h1><br><br><br>
            <script>
				alert='${gameErrorMsg}'
			</script>
            <a href="GameServlet" class="start-link">ゲームスタート</a>
        </div>
    </div>
</body>
</html>
