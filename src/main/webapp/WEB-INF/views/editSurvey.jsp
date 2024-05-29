<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>설문 수정</title>
    <style>
      body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        text-align: center;
        margin: 50px;
      }

      h2 {
        color: #333;
      }

      form {
        width: 300px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }

      label {
        display: block;
        margin-bottom: 8px;
        color: #333;
      }

      input {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
      }

      button {
        width: 100%;
        padding: 10px;
        background-color: #4caf50;
        color: white;
        cursor: pointer;
        border: none;
        border-radius: 4px;
      }

      button:hover {
        background-color: #45a049;
      }
    </style>
    <script>
      function handleUpdate() {
        alert("설문이 성공적으로 수정되었습니다!");
      }
    </script>
</head>
<body>
<h2>설문 수정</h2>
<form action="/survey/update" method="post" accept-charset="utf-8">
    <input type="hidden" name="id" value="${survey.id}">
    <input type="hidden" name="memberId" value="${survey.memberId}">

    <label for="title">제목:</label>
    <input type="text" id="title" name="title" value="${survey.title}" required><br>

    <label for="purpose">목적:</label>
    <input type="text" id="purpose" name="purpose" value="${survey.purpose}" required><br>

    <label for="endDate">마감 일자:</label>
    <input type="text" id="endDate" name="endDate" value="${survey.endDate}" required><br>

    <label for="reward">리워드 품목:</label>
    <input type="text" id="reward" name="reward" value="${survey.reward}" required><br>

    <label for="rewardCount">리워드 개수:</label>
    <input type="text" id="rewardCount" name="rewardCount" value="${survey.rewardCount}" required><br>

    <label for="url">설문 링크:</label>
    <input type="text" id="url" name="url" value="${survey.url}" required><br>
</form>
</body>
</html>
