<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo</title>
<link rel="stylesheet" href="css/quiz.css">
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
<body>
    <div class="quiz-container">
     <button id="hintButton">
        ヒント     
     </button>
        <h1>問<c:out value="${game.quizCount}" /></h1>
        <div class="question">
            <c:out value="${question}" />
        </div>
        <div class="timer" id="timer">残り時間: 10秒</div>
        <div class="choices">
            <form id="quizForm" action="JudgeServlet" method="post">
                <input class="btn-choice" type="submit" name="input" value="${button1}" id="choice1">
                <input class="btn-choice" type="submit" name="input" value="${button2}" id="choice2">
                <input class="btn-choice" type="submit" name="input" value="${button3}" id="choice3">
                <input class="btn-choice" type="submit" name="input" value="${button4}" id="choice4">
            </form>
        </div>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var hintButton = document.getElementById('hintButton');
            var choiceButtons = document.querySelectorAll('.btn-choice');
            var correctChoice = '<%= request.getAttribute("answer") %>'; 
            var form = document.getElementById('quizForm');

            hintButton.addEventListener('click', function() {
                var choices = Array.from(choiceButtons);
                var incorrectChoices = choices.filter(function(button) {
                    return button.value !== correctChoice;
                });
                var shuffledChoices = shuffleArray(incorrectChoices);

                for (var i = 0; i < 2; i++) {
                    shuffledChoices[i].disabled = true;
                    shuffledChoices[i].classList.add('disabled');
                }
                // ヒントボタンを無効化
                hintButton.disabled = true; 
            });

            // 各選択肢ボタンをキーボードの数字と対応させる
            choiceButtons.forEach(function(choiceButton, index) {
                choiceButton.addEventListener('click', function() {
                    if (!this.classList.contains('disabled')) {
                        var choiceValue = this.value;
                        var input = document.createElement('input');
                        input.type = 'hidden';
                        input.name = 'choice';
                        input.value = choiceValue;
                        form.appendChild(input);
                        form.submit();
                    }
                });
                // キーボードの数字を押したときの処理
                document.addEventListener('keydown', function(event) {
                    if (event.key == (index + 1).toString()) {
                        choiceButton.click();
                    }
                });
            });

            // 選択肢をシャッフルする
            function shuffleArray(array) {
                for (var i = array.length - 1; i > 0; i--) {
                    var j = Math.floor(Math.random() * (i + 1));
                    var temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                return array;
            }
        });
    </script>
</body>
</html>
