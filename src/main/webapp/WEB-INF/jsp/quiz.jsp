<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
 <script>
        let timeLeft = 10;
        function startTimer() {
            const timerElement = document.getElementById('timer');
            const interval = setInterval(() => {
                if (timeLeft <= 0) {
                    clearInterval(interval);
                    window.location.href = 'TimeOutServlet'; // タイムアウト時の遷移先
                } else {
                    timerElement.innerText = '残り時間: ' + timeLeft + '秒';
                    timeLeft--;
                }
            }, 1000);
        }

        window.onload = startTimer;
    </script>
<link rel="stylesheet" href="css/quiz.css">
</head>
<body>

	<div class="quiz-container">
		<h1>
			<b> 問<c:out value="${game.quizCount}" />
		</h1>
		<div class="question">
			<c:out value="${question}" />
		</div>
		 <div class="timer" id="timer">
            残り時間: 10秒
        </div>
		<div class="choices">
			<form action="JudgeServlet" method="post">
				<input type="submit" name="input" value="${button1}">　 
				<input type="submit" name="input" value="${button2}">　
				<input type="submit" name="input" value="${button3}">　
				<input type="submit" name="input" value="${button4}">
			</form>
		</div>
	</div>
	</div>
	</div>
</body>
</html>