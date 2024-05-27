<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuiZoo - クイズ</title>
<link rel="stylesheet" href="css/tutorial_answer.css">
</head>
<body>
    <div class="quiz-container">
        <h1>チュートリアル</h1>
        <div class="question has-tooltip">
            正解は猫
            <span class="tooltip">正解が表示されます</span>
        </div>
        <div class="talking">
            <div class="explain has-tooltip">
                猫ひろしは人間だろっていう奴も不正解
                <span class="tooltip">解説文が表示されます</span>
            </div>
        </div>
        <div class="link-container">
            <a href="TutorialServlet">戻る</a>
        </div>
        <br>
        <div class="link-container">
            <a href="MainServlet">メニュー画面へ</a>
        </div>
    </div>
    
</body>
</html>
