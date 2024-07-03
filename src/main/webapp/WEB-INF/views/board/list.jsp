<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    
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
 <style>
        body {
            background-color: #f9f9f9;
            color: #fff;
            margin: 0;
        }
    </style>
</head>
<body>

    <div class="container" style="padding-top: 50px;">
        <table class="table table-bordered table-hover">
            <tr>
                <th class="status">-</th>
                 <th class="email">작성자</th>
                <th class="title">제목</th>
                
                <th class="hiredate">작성일시</th>
                <th class="recommend">추천</th>
                <th>조회수</th>
            </tr>
            <c:forEach var="board" items="${boardList}">
          
                <tr>
                    <td>${board.status} </td>
                    <td>${board.email} </td>
                    <td style="text-align:left;">
                        <a href="view?id=${board.id}" class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                            ${board.title }
                        </a>
                    </td> 
                    
                    <td>${board.hiredate }</td>
                    <td>${board.recommend }</td>
                    <td>${board.hits }</td>
                </tr>
                </c:forEach>
            
        </table>
        <form action="/write">
    <button type="submit" class="btn btn-dark fixed button">글쓰기</button>
</form>
        </div>

   
  



        <!-- 글쓰기 버튼 -->
        
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
