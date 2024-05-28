<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>QuiZoo - クイズ</title>
    <link rel="stylesheet" href="css/tutorial.css">
</head>
<body>
    <div class="quiz-container">
        <button id="hintButton" class="has-tooltip">
            ヒント
            <span class="tooltip">押すと選択肢が２つになります</span>
        </button>
        <h1>チュートリアル</h1>
        <h2>カーソルを合わせると説明が出ます</h2>
        <div class="question has-tooltip">
            ニャーと鳴く動物は？
            <span class="tooltip">問題文が表示されます</span>
        </div>
        <div class="timer has-tooltip" id="timer">
            残り時間: 10秒
            <span class="tooltip">10秒以内に解答しないと時間切れで不正解</span>
        </div>
        <div class="choices">
            <form id="quizForm" action="TutorialServlet" method="post">
                <button type="button" name="choice" value="犬" class="btn-choice has-tooltip" id="choice1">
                    犬
                    <span class="tooltip">クリックするか1を入力すると解答画面に進む</span>
                </button>
                <button type="button" name="choice" value="猫" class="btn-choice has-tooltip" id="choice2">
                    猫
                    <span class="tooltip">クリックするか2を入力すると解答画面に進む</span>
                </button>
                <br>
                <button type="button" name="choice" value="鳥" class="btn-choice has-tooltip" id="choice3">
                    鳥
                    <span class="tooltip">クリックするか3を入力すると解答画面に進む</span>
                </button>
                <button type="button" name="choice" value="人間" class="btn-choice has-tooltip" id="choice4">
                    人間
                    <span class="tooltip">クリックするか4を入力すると解答画面に進む</span>
                </button>
            </form>
        </div>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var hintButton = document.getElementById('hintButton');
            var choiceButtons = document.querySelectorAll('.btn-choice');
            var correctChoice = '猫'; // 正解の選択肢を「猫」に設定
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
