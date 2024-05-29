<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>내 설문 관리</title>
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

      .container {
        width: 80%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }

      table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
      }

      table, th, td {
        border: 1px solid #ddd;
      }

      th, td {
        padding: 12px;
        text-align: left;
      }

      th {
        background-color: #f2f2f2;
      }

      button {
        padding: 10px 15px;
        background-color: #4caf50;
        color: white;
        cursor: pointer;
        border: none;
        border-radius: 4px;
      }

      button:hover {
        background-color: #45a049;
      }

      .action-buttons {
        display: flex;
        gap: 10px;
      }
    </style>
    <script>
      function confirmDelete(surveyId) {
        if (confirm("정말 이 설문을 삭제하시겠습니까?")) {
          location.href = '/survey/delete?id=' + surveyId;
        }
      }
    </script>
</head>
<body>
<h2>내 설문 관리</h2>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>제목</th>
            <th>목적</th>
            <th>마감 일자</th>
            <th>리워드 품목</th>
            <th>리워드 개수</th>
            <th>액션</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="survey" items="${surveys}">
            <tr>
                <td>${survey.title}</td>
                <td>${survey.purpose}</td>
                <td>${survey.endDate}</td>
                <td>${survey.reward}</td>
                <td>${survey.rewardCount}</td>
                <td><a href="${survey.url}">${survey.url}</a></td>
                <td class="action-buttons">
                    <button onclick="location.href='/survey/edit?id=${survey.id}'">수정</button>
                    <button onclick="confirmDelete(${survey.id})">삭제</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
