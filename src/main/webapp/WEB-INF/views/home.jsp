<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../resources/mainPage.css">
</head>
<body>
<div class="container">
	<div class="header">
		<h2>&#128221; 설문이용</h2>
		<div class="header-buttons">
			<c:choose>
				<c:when test="${isLogin}">
					<a href="/member/logout" onclick="logout()" class="button">&#128682; 로그아웃</a>
					<script>
						function logout() {
							fetch('/member/logout', { method: 'GET' })
							.then(response => {
								alert("로그아웃에 성공했습니다.");
								window.location.href = '/';
							})
							.catch(error => console.error('Error:', error));
						}
					</script>
					<a href="/survey/register" class="button">&#128221; 설문 등록하기</a>
				</c:when>
				<c:otherwise>
					<a href="/member/login" class="button">&#128273; 로그인</a>
					<a href="/member/signup" class="button">&#128100; 회원가입</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<div class="section-title">
		<h3>&#128221; 설문 목록</h3>
	</div>

	<c:forEach items="${surveys}" var="survey">
		<div class="survey-info">
			<div>
				<div class="survey-title">&#128221; ${survey.title}</div>
				<div class="survey-detail">&#128161; 목적: ${survey.purpose}</div>
				<div class="survey-detail">&#128197; 마감 일자: ${survey.endDate}</div>
				<div class="survey-detail">&#127873; 리워드 품목: ${survey.reward}</div>
				<div class="survey-detail">&#128176; 리워드 개수: ${survey.rewardCount}</div>
			</div>
			<a href="/survey/info?id=${survey.id}" class="detail-button">&#128270; 상세보기</a>
		</div>
	</c:forEach>
</div>
</body>
</html>
