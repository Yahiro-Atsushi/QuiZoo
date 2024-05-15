<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
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
</head>
<body onload="startTimer()">
	<b><span id="countdownLabel"></span></b>
</body>
</html>