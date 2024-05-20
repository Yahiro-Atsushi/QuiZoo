<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/result.css">
<title>QuiZoo</title>
</head>
<body>
    <div class="quiz-container">
        <h1>解答結果</h1>
        <div class="columns-container">
            <div class="column">
                <c:forEach var="i" begin="1" end="5">
                    <div class="question">
                        <span class="result">
                            <c:out value="${i}" />問目: 
                            <span style="color: ${result[i] == '正解' ? 'green' : 'red'};">
                                <c:out value="${result[i]}" />
                            </span>
                        </span>
                    </div>
                </c:forEach>
            </div>
            <div class="column">
                <c:forEach var="i" begin="6" end="10">
                    <div class="question">
                        <span class="result">
                            <c:out value="${i}" />問目: 
                            <span style="color: ${result[i] == '正解' ? 'green' : 'red'};">
                                <c:out value="${result[i]}" />
                            </span>
                        </span>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="link-container">
            <a href="MainServlet">メニュー画面へ</a>
        </div>
    </div>
</body>
</html>
