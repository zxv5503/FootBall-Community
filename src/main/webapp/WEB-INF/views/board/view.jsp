<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>list</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">

    <nav class="navbar navbar-expand-lg bg-body-tertiary"
         data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">HomePage</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page" href="/list">List</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="http://youtube.com">Link</a></li>
                    <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" href="#" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false"> 게시판선택 </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/list">통합게시판</a></li>
                            <li><a class="dropdown-item" href="freeList">자유게시판</a></li>
                            <li><a class="dropdown-item" href="eplList">EPL</a></li>
                            <li><a class="dropdown-item" href="laligaList">Laliga</a></li>
                            <li><a class="dropdown-item" href="bundesligaList">Bundesliga</a></li>
                            <li><a class="dropdown-item" href="serieList">Serie A</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link disabled"
                                            aria-disabled="true">...</a></li>
                </ul>

            </div>
        </div>
    </nav>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>view</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous">
    <style>
        body {
            background-color: #f9f9f9;
            margin: 0;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-8">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">제목</label>
                <input class="form-control" type="text" value="${bv.title }"
                       readonly name="title">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">ID</label>
                <input class="form-control" type="text" value="${bv.id}" readonly>
            </div>

            <div class="row mb-3">
                <div class="col">
                    <label for="exampleFormControlInput1" class="form-label">작성자</label>
                    <input class="form-control" type="text" value="${bv.email}"
                           readonly>
                </div>
                <div class="col">
                    <label for="exampleFormControlInput1" class="form-label">작성일시</label>
                    <input class="form-control" type="text" value="${bv.hiredate}"
                           readonly>
                </div>
                <div class="col">
                    <label for="exampleFormControlInput1" class="form-label">조회수</label>
                    <input class="form-control" type="text" value="${bv.hits}"
                           readonly>
                </div>
            </div>

            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">내용</label>
                <textarea class="form-control" readonly rows="6">${bv.content }</textarea>
            </div>
            <input type="button" value="목록보기" onclick="location.href='/list'"
                   class="btn btn-primary">
            <input type="button" value="수정"
                   class="btn btn-dark"
                   onclick="location.href='/updateList?id=${bv.id}'">
            <input
                type="button" value="삭제" class="btn btn-danger"
                onclick="location.href='/deleteList?id=${bv.id}'">

        </div>
    </div>
</div>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>