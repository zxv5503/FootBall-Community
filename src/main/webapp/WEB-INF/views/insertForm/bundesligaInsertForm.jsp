<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert Form</title>
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
            width: calc(100% - 20px); /* 기존 가로길이에서 20px만큼 뺀 값을 설정 */
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
    <form id="bundesligaInsertForm" method="post" action="bundesligaInsertForm">
        <h2>Bundesliga</h2>
        <div class="form-group">
            <label for="teamName">Team Name:</label>
            <input type="text" id="teamName" name="teamName" placeholder="Enter team name" required>
        </div>
        <div class="form-group">
            <label for="matchesPlayed">Matches Played:</label>
            <input type="number" id="matchesPlayed" name="matchesPlayed" placeholder="Enter matches played" required>
        </div>
        <div class="form-group">
            <label for="wins">Wins:</label>
            <input type="number" id="wins" name="wins" placeholder="Enter wins" required>
        </div>
        <div class="form-group">
            <label for="draws">Draws:</label>
            <input type="number" id="draws" name="draws" placeholder="Enter draws" required>
        </div>
        <div class="form-group">
            <label for="losses">Losses:</label>
            <input type="number" id="losses" name="losses" placeholder="Enter losses" required>
        </div>
        <div class="form-group">
            <label for="goalsPlusMinus">Goals Plus Minus:</label>
            <input type="text" id="goalsPlusMinus" name="goalsPlusMinus" placeholder="Enter goals plus minus" required>
        </div>
        <div class="form-group">
            <label for="goalsSum">Goals Sum:</label>
            <input type="number" id="goalsSum" name="goalsSum" placeholder="Enter goals sum" required>
        </div>
        <div class="form-group">
            <label for="points">Points:</label>
            <input type="number" id="points" name="points" placeholder="Enter points" required>
        </div>
        <div class="form-group">
            <button type="submit">Insert</button>
        </div>
    </form>
</div>






</body>
</html>
