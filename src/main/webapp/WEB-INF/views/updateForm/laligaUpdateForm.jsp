<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀 정보 수정</title>
</head>
<script src="/assets/js/color-modes.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.118.2">
<title>FootBall Community</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/blog/">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary {
	--bd-violet-bg: #712cf9;
	--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
	--bs-btn-font-weight: 600;
	--bs-btn-color: var(--bs-white);
	--bs-btn-bg: var(--bd-violet-bg);
	--bs-btn-border-color: var(--bd-violet-bg);
	--bs-btn-hover-color: var(--bs-white);
	--bs-btn-hover-bg: #6528e0;
	--bs-btn-hover-border-color: #6528e0;
	--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
	--bs-btn-active-color: var(--bs-btn-hover-color);
	--bs-btn-active-bg: #5a23c8;
	--bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
	z-index: 1500;
}

.bd-mode-toggle .dropdown-menu .active .bi {
	display: block !important;
}
</style>
<body>
	<div class="container">
		<header class="border-bottom lh-1 py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 pt-1">
					<a class="link-secondary" href="#">Subscribe</a>
				</div>
				<div class="col-4 text-center">
					<a class="blog-header-logo text-body-emphasis text-decoration-none"
						href="/"><strong>FootBall Community</strong></a>
				</div>
				<div class="col-4 d-flex justify-content-end align-items-center">
					<a class="link-secondary" href="#" aria-label="Search"> <svg
							xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="none" stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2" class="mx-3" role="img"
							viewBox="0 0 24 24">
                    <title>Search</title><circle cx="10.5" cy="10.5"
								r="7.5" />
                    <path d="M21 21l-5.2-5.2" /></svg>
					</a> <a class="btn btn-sm btn-outline-secondary" href="/memberUpdateForm">Update </a> 
					<a class="btn btn-sm btn-outline-secondary" href="/login">Log
						in </a> 
						<a class="btn btn-sm btn-outline-secondary" href="/logout">Log
						out </a>
				</div>
			</div>
		</header>

		<div class="nav-scroller py-1 mb-3 border-bottom">
			<nav class="nav nav-underline justify-content-center">
				<a class="nav-item nav-link link-body-emphasis active" href="">World</a>
				<a class="nav-item nav-link link-body-emphasis" href="/">순위</a> <a
					class="nav-item nav-link link-body-emphasis" href="/news">뉴스</a> <a
					class="nav-item nav-link link-body-emphasis" href="#">자유게시판</a>
			</nav>
		</div>
	</div>




	<div class="container">
		<h2>팀 정보 수정</h2>

		<h3 class="pb-4 mb-4 fst-italic border-bottom"></h3>

		<article class="blog-post">


			<div class="row">
				<div class="col-md-8">
					<div class="p-4 mb-3 bg-body-secondary rounded">
						<table class="table">
							<thead>
								<tr>
									<th>순위</th>
									<th>-</th>
									<th>경기수</th>
									<th>승</th>
									<th>무</th>
									<th>패</th>
									<th>+/-</th>
									<th>=</th>
									<th>승점</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${epl}" var="team" varStatus="status">
									<tr>
										<td>${status.index + 1}</td>
										<td><img src="/assets/img/eplMark/${team.teamName}.png"
											alt="${team.teamName}" class="team-logo"> <a
											class="link-offset-2 link-underline link-underline-opacity-0"
											href="laligaUpdate?teamName=${team.teamName}">${team.teamName}</a></td>
										<td>${team.matchesPlayed}</td>
										<td>${team.wins}</td>
										<td>${team.draws}</td>
										<td>${team.losses}</td>
										<td>${team.goalsPlusMinus}</td>
										<td>${team.goalsSum}</td>
										<td>${team.points}</td>
										<td><a href="laligaDelete?teamName=${team.teamName}">삭제</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<nav class="blog-pagination" aria-label="Pagination">
					<a class="btn btn-outline-primary rounded-pill" href="/laligaInsertForm">insert</a>
					
				</nav>
				</div>
				<div class="col-md-4">
					<div class="position-sticky" style="top: 2rem;">
						<div class="p-3 mb-3 bg-body-tertiary rounded">
							<div class="btn-group-vertical w-100"
								style="max-width: fit-content;">
								<h4 class="pb-4 mb-4 fst-italic border-bottom">톱 리그</h4>
								<a href="/updateForm">
									<button class="btn btn-light text-dark" href="/root"
										onclick="showRanking('EPL')" style="text-align: left;">
										<img src="/assets/img/4league/epl.png"
											style="vertical-align: middle; margin-right: 8px;">
										Premier League
									</button>
								</a> 
								<a href="/laligaUpdateForm">
									<button class="btn btn-light text-dark" href="/laligaroot"
										onclick="showRanking('LaLiga')" style="text-align: left;">
										<img src="/assets/img/4league/Laliga.png"
											style="vertical-align: middle; margin-right: 8px;">
										LaLiga
									</button>
								</a>
								<a href="/bundesligaUpdateForm">
								<button class="btn btn-light text-dark"
									onclick="showRanking('Bundesliga')" style="text-align: left;">
									<img src="/assets/img/4league/bundes.png"
										style="vertical-align: middle; margin-right: 8px;">
									Bundesliga
								</button>
								</a>
								<a href="/serieUpdateForm">
								<button class="btn btn-light text-dark"
									onclick="showRanking('Serie A')" style="text-align: left;">
									<img src="/assets/img/4league/serie.png"
										style="vertical-align: middle; margin-right: 8px;">
									Serie A
								</button>
								</a>
							</div>
						</div>


						<div>
							<h4 class="fst-italic">Recent posts</h4>
							<ul class="list-unstyled">
								<li><a
									class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top"
									href="#"> <svg class="bd-placeholder-img" width="100%"
											height="96" xmlns="http://www.w3.org/2000/svg"
											aria-hidden="true" preserveAspectRatio="xMidYMid slice"
											focusable="false">
											<rect width="100%" height="100%" fill="#777" /></svg>
										<div class="col-lg-8">
											<h6 class="mb-0">Example blog post title</h6>
											<small class="text-body-secondary">January 15, 2023</small>
										</div>
								</a></li>
								<li><a
									class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top"
									href="#"> <svg class="bd-placeholder-img" width="100%"
											height="96" xmlns="http://www.w3.org/2000/svg"
											aria-hidden="true" preserveAspectRatio="xMidYMid slice"
											focusable="false">
											<rect width="100%" height="100%" fill="#777" /></svg>
										<div class="col-lg-8">
											<h6 class="mb-0">This is another blog post title</h6>
											<small class="text-body-secondary">January 14, 2023</small>
										</div>
								</a></li>
								<li><a
									class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top"
									href="#"> <svg class="bd-placeholder-img" width="100%"
											height="96" xmlns="http://www.w3.org/2000/svg"
											aria-hidden="true" preserveAspectRatio="xMidYMid slice"
											focusable="false">
											<rect width="100%" height="100%" fill="#777" /></svg>
										<div class="col-lg-8">
											<h6 class="mb-0">Longer blog post title: This one has
												multiple lines!</h6>
											<small class="text-body-secondary">January 13, 2023</small>
										</div>
								</a></li>
							</ul>
						</div>

						<div class="p-4">
							<h4 class="fst-italic">Archives</h4>
							<ol class="list-unstyled mb-0">
								<li><a href="#">March 2021</a></li>
								<li><a href="#">February 2021</a></li>
								<li><a href="#">January 2021</a></li>
								<li><a href="#">December 2020</a></li>
								<li><a href="#">November 2020</a></li>
								<li><a href="#">October 2020</a></li>
								<li><a href="#">September 2020</a></li>
								<li><a href="#">August 2020</a></li>
								<li><a href="#">July 2020</a></li>
								<li><a href="#">June 2020</a></li>
								<li><a href="#">May 2020</a></li>
								<li><a href="#">April 2020</a></li>
							</ol>
						</div>

						<div class="p-4">
							<h4 class="fst-italic">Elsewhere</h4>
							<ol class="list-unstyled">
								<li><a href="#">GitHub</a></li>
								<li><a href="#">Twitter</a></li>
								<li><a href="#">Facebook</a></li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</article>
	
		
	</div>
	<footer class="py-5 text-center text-body-secondary bg-body-tertiary">
		<p>
			Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a>
			by <a href="https://twitter.com/mdo">@mdo</a>.
		</p>
		<p class="mb-0">
			<a href="#">Back to top</a>
		</p>
	</footer>
	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
