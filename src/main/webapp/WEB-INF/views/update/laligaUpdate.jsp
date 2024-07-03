<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>팀 정보 수정</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f5f5f5;
        }

        .form-container {
            width: 400px;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .form-group button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }

        .form-group button:hover {
            background-color: #0056b3;
        }

        .logo-container {
            position: absolute;
            top: 20px;
            left: 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<a href="javascript:history.go(-1)" class="logo-container">
    <img src="/assets/img/tong/backspace-fill.svg" alt="Logo" width="50" height="50">
</a>

<div class="form-container">
    <h2>팀 정보 수정</h2>
    
    <form action="laligaRealUpdate" method="post">
       
        <div class="form-group">
            <label for="teamName">팀 이름:</label>
            <input type="text" id="teamName" name="teamName" value="${laliga.teamName}" readonly>
        </div>
        <div class="form-group">
            <label for="matchesPlayed">경기 수:</label>
            <input type="number" id="matchesPlayed" name="matchesPlayed" value="${laliga.matchesPlayed}">
        </div>
        <div class="form-group">
            <label for="wins">승:</label>
            <input type="number" id="wins" name="wins" value="${laliga.wins}">
        </div>
        <div class="form-group">
            <label for="draws">무승부:</label>
            <input type="number" id="draws" name="draws" value="${laliga.draws}">
        </div>
        <div class="form-group">
            <label for="losses">패:</label>
            <input type="number" id="losses" name="losses" value="${laliga.losses}">
        </div>
        <div class="form-group">
            <label for="goalsPlusMinus">득실 차:</label>
            <input type="text" id="goalsPlusMinus" name="goalsPlusMinus" value="${laliga.goalsPlusMinus}">
        </div>
        <div class="form-group">
            <label for="goalsSum">득점:</label>
            <input type="number" id="goalsSum" name="goalsSum" value="${laliga.goalsSum}">
        </div>
        <div class="form-group">
            <label for="points">승점:</label>
            <input type="number" id="points" name="points" value="${laliga.points}">
        </div>
        
            
        <div class="form-group">
            <button type="submit">수정</button>
        </div>
    </form>
</div>

</body>
</html>
