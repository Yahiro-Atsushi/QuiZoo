<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<script>
	function startCountdown() {
		var secondsLeft = 10;
		var countdownLabel = document.getElementById("countdownLabel");
		countdownLabel.innerHTML = secondsLeft;

		var countdownInterval = setInterval(function() {
			secondsLeft--;
			countdownLabel.innerHTML = secondsLeft;
			if (secondsLeft <= 0) {
				clearInterval(countdownInterval);
				window.location.href = "TimeOutServlet";
			}
		}, 1000);
	}
</script>
</head>
<body onload="startCountdown()">
	<b><span id="countdownLabel"></span></b>
</body>
</html>