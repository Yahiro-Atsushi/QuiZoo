<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<style type="text/css">
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
}

.menu-container {
    display: flex;
    height: 100vh;
}

.sidebar {
    width: 160px;
    background-color: #343a40;
    color: #fff;
    padding: 20px;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
}

.sidebar h1 {
    margin-bottom: 30px;
}

.sidebar ul {
    list-style-type: none;
    padding: 0;
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.sidebar ul li {
    margin-bottom: 10px;
}

.sidebar ul li a {
    text-decoration: none;
    color: #fff;
    font-size: 1.2em;
}

.sidebar ul li a:hover {
    color: #17a2b8;
}

.logout-link {
    margin-top: auto; /* ログアウトリンクを下端に配置 */
}

.logout-link a {
    text-decoration: none;
    color: #fff;
    font-size: 1.2em;
}

.content {
    flex: 1;
    padding: 20px;
    display: flex;
    border:  1px solid #050d16;
    background-image: url('image/QuiZoo_TOP3.png'); /* 背景画像のパスを指定 */
    background-size: cover; /* 画像をコンテナ全体にカバーするように設定 */
    background-position: center; /* 画像を中央に配置 */
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.title {
    background-color: rgb(247, 203, 109);
    font-size: 3em;
    color: #155505;
    margin-bottom: 30px;
    border: 2px solid #050d16; /* 枠線を追加 */
    border-radius: 10px; /* 枠線の角丸を追加 */
    padding: 20px; /* テキストと枠線の間に余白を追加 */
    text-align: center; /* テキストを中央に配置 */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* 影を追加 */
   
}

.start-link {
    text-decoration: none;
    color: #155505;
    font-size: 1.5em;
    padding: 10px 25px;
    border: 2px solid #000407; /* 枠線の初期設定 */
    border-radius: 30px;
    background-color: rgb(247, 203, 109);
    transition: all 0.3s;
    display: inline-block; /* リンク要素をブロック要素に変更 */
    position: relative; /* 枠線を追加するための相対位置 */
}

.start-link:hover {
    color: #fff;
    background-color: #0056b3;
}

.start-link:before {
    content: "";
    position: absolute;
    top: -6px;
    left: -6px;
    right: -6px;
    bottom: -6px;
    border-radius: 32px;
    z-index: -1;
}

</style>
<title>QuiZoo</title>
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
            <h1 class="title" style="font-size: 100px;">QuiZoo</h1><br><br><br>
            <a href="GameServlet" class="start-link">ゲームスタート</a>
        </div>
    </div>
</body>
</html>
