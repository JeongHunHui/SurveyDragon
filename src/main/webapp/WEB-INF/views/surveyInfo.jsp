<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
      body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        color: #495057;
        line-height: 1.6;
        padding: 0;
        text-align: center;
        width: 80%;
        margin: auto;
      }

      .survey-info {
        display: flex;
        background-color: #ffffff;
        padding: 20px;
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
      }

      .survey-image {
        flex: 1; /* 이미지 컬럼에 비중을 설정 */
        max-width: 50%; /* 최대 너비 제한 */
        padding-right: 20px; /* 오른쪽 패딩 추가 */
      }

      .survey-details {
        flex: 1; /* 상세 정보 컬럼에 비중을 설정 */
        padding-left: 20px; /* 왼쪽 패딩 추가 */
      }

      h2 {
        margin-bottom: 20px;
        color: #343a40;
      }
      .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #282c34; /* 어두운 톤의 배경색 */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
        margin: 0 auto;
        padding: 10px 20px; /* 패딩 조정 */
        height: 80px; /* 높이 조정 */
      }

      .header > .left, .header > .right {
        flex: 1;
        text-align: left;
      }

      .header > h2 {
        flex: 2; /* 중앙 부분 더 넓게 설정 */
        font-size: 24px; /* 글꼴 크기 조정 */
        color: #ffffff; /* 글꼴 색상 흰색으로 변경 */
        margin: 0;
        text-align: center;
      }

      .header > .right {
        text-align: right;
      }

      .header > .left > a {
        margin-left: 20px;
        font-size: 24px;
        font-weight: bold;
        color: #ffffff; /* 링크 색상 흰색으로 변경 */
        text-decoration: none;
        transition: color 0.3s; /* 마우스 오버 효과를 위한 전환 효과 추가 */
      }

      .header > .left > a:hover, .header > .right > a:hover, .header > h2:hover {
        color: #4d9fec; /* 마우스 오버 시 색상 변경 */
      }

      .survey-title-header {
        text-align: left; /* 왼쪽 정렬 */
        color: #343a40;
        font-size: 24px; /* 글꼴 크기 */
        margin-top: 20px; /* 상단 여백 */
        margin-bottom: 10px; /* 하단 여백 */
      }

      p {
        margin: 10px 0;
      }

      ul {
        list-style: none;
        padding: 0;
      }

      li {
        margin-bottom: 20px;
        border-bottom: 1px solid #dee2e6;
        padding-bottom: 15px;
      }

      textarea {
        width: 100%;
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #ced4da;
        border-radius: 8px;
        box-sizing: border-box;
        font-size: 14px;
        height: 150px; /* 높이를 설정하여 더 많은 텍스트가 보이도록 합니다. */
      }

      button {
        width: 100%;
        background-color: #007bff;
        color: #fff;
        padding: 15px 20px;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
      }

      button:hover {
        background-color: #004085;
      }
    </style>
</head>

<body>
<div class="header">
    <div class="left">
        <a href="/">&#128221; 설문이용</a>
    </div>
</div>

<h3 class="survey-title-header">${survey.title}</h3>
<div class="survey-info">
    <div class="survey-image">
        <img src="https://movie-mania-2023-tuk.s3.ap-northeast-2.amazonaws.com/%E3%85%87.avif" alt="${movie.title}" style="max-width: 100%; height: auto;">
    </div>
    <div class="survey-details">
        <p><strong>&#128161; 목적:</strong> ${survey.purpose}</p>
        <p><strong>&#128197; 마감 일자:</strong> ${survey.endDate}</p>
        <p><strong>&#127873; 리워드 품목:</strong> ${survey.reward}</p>
        <p><strong>&#128176; 리워드 개수:</strong> ${survey.rewardCount}</p>
    </div>
</div>

</body>
</html>
