<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
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

      .info {
        margin-bottom: 15px;
        color: #555;
      }

      button {
        width: 100%;
        padding: 10px;
        background-color: #4caf50;
        color: white;
        cursor: pointer;
        border: none;
        border-radius: 4px;
        margin-bottom: 10px;
      }

      button:hover {
        background-color: #45a049;
      }
    </style>
</head>
<body>
<h2>마이페이지</h2>
<div class="container">
    <%--@declare id="name"--%><%--@declare id="email"--%><label for="name">이름:</label>
    <div class="info">${member.name}</div>

    <label for="email">이메일:</label>
    <div class="info">${member.email}</div>

    <button onclick="location.href='/member/edit'">정보 수정</button>
    <button onclick="location.href='/survey/manage'">내 설문 관리</button>
</div>

</body>
</html>
