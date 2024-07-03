<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// 현재 날짜와 시간을 받아옴
	Date currentDate = new Date();

	// 날짜 포맷 지정
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// hiredate 값을 현재 날짜와 시간으로 설정
	String hiredate = dateFormat.format(currentDate);
%>
<html lang="en">
<head>
	<nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">HomePage</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="/list">List</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="http://youtube.com">Link</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							게시판선택
						</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/list">통합게시판</a></li>
							<li><a class="dropdown-item" href="freeList">자유게시판</a></li>
							<li><a class="dropdown-item" href="eplList">EPL</a></li>
							<li><a class="dropdown-item" href="laligaList">Laliga</a></li>
							<li><a class="dropdown-item" href="bundesligaList">Bundesliga</a></li>
							<li><a class="dropdown-item" href="serieList">Serie A</a></li>
						</ul>
					</li>
					<li class="nav-item">
						<a class="nav-link disabled" aria-disabled="true">...</a>
					</li>
				</ul>
				<form class="d-flex" role="search" >
					<input class="form-control me-2" type="search" placeholder="제목" aria-label="Search" name="searchKeyword">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Write</title>
	<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous">
	<style>
		body {
			background-color: #343a40; /* 배경색 지정 */
			color: #fff; /* 글자색 지정 */
			margin: 0; /* 바디 마진 제거 */
		}

		.form-container {
			width: 100%;
			max-width: 800px; /* 가로 길이 조절 */
			margin: auto;
			text-align: left;
			padding: 15px; /* 내용 칸에 여백 추가 */
		}

		.mb-3 {
			margin-bottom: 20px; /* 간격 조절 */
		}

		.form-control {
			width: 100%;
		}
	</style>
</head>
<body>
<form method="post" action="/updateListSubmit">
	<div class="p-3 mb-2 bg-dark-subtle text-dark-emphasis">
		<div class="d-flex justify-content-center align-items-center"
			 style="height: 80vh;">
			<div class="form-container">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">제목</label>
					<input type="text" class="form-control"
						   id="exampleFormControlInput1" placeholder="title" name="title" value="${board.title}">
				</div>
				<input type="hidden" name="id" value="${board.id}">
				<input type="hidden" name="email" value="${board.email}">
				<div class="mb-3">
					<label for="status" class="form-label">게시판</label><br>
					<select class="form-select" aria-label="Default select example" name="status">
						<option value="${board.status}">${board.status}</option>
					</select>
					<input type="hidden" name="hiredate" value="${hiredate}">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">내용</label>
					<textarea class="form-control" id="exampleFormControlTextarea1"
							  rows="5" placeholder="content" name="content">${board.content}</textarea>
				</div>
				<input type="submit" value="저장" class="btn btn-dark">
				<input type="button" value="취소" onclick="history.back()" class="btn btn-danger">
			</div>
		</div>
	</div>
</form>
</body>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
