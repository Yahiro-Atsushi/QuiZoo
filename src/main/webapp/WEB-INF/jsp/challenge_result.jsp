<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>QuiZoo</title>
<style>
@charset "UTF-8";
body {
    margin: 0;
    padding: 0;
    background-color: #099e24f6;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #333;
}

.quiz-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-align: left;
    background-color: #fff;
    padding: 40px 60px;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    min-width: 0;
    width: 100%;
}

h1 {
    font-size: 2.5em;
    margin-bottom: 10px;
    color: #343a40;
}

h2 {
    font-size: 2em;
    margin-bottom: 10px;
    color: #e40404;
}

.talking-left_icon {
    margin: auto;
    text-align: center; 
}

.talking-left_icon img {
    width: 100px;
    height: 110px;
    margin: auto;
    display: block; 
    background-position: center;
}

.talking-left {
	width: 20em;
    margin-bottom: 20px;
    padding: 15px;
    border: 1px solid #ccc;
    border-radius: 10px;
    background-color: lightpink;
    text-align: left;
    word-wrap: break-word; /* テキストの折り返しを設定 */
    word-break: break-word; /* 長い単語や文字列を折り返す */
    overflow-wrap: break-word; /* 長い単語の折り返しを強制 */
}

.link-container {
    margin-top: 20px;
    text-align: center;
    margin: auto;
}

.link-container a {
    margin: auto;
    text-decoration: none;
    display: inline-block;
    padding: 10px 20px;
    border-radius: 30px;
    background-color: #007bff;
    color: #fff;
    transition: background-color 0.3s;
}

.link-container a:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>
<div class="quiz-container">    
    <h1>終了!</h1>
    	<h2>正解数：10問</h2><br>
    		<div class="talking-left">
       			またの挑戦をお待ちしております。
    		</div>
    			<figure class="talking-left_icon">
       				<img src="image/Challenge_Result.png" alt="代替テキスト">
    			</figure>
    <br><br>
    			<div class="link-container">
        		<a href="MainServlet">TOPへ</a>
        		</div>      
</div>
</body>
</html>