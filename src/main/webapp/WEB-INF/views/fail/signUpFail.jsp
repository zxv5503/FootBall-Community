<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>
<script type="text/javascript">
    // 로그인 실패 시 경고창을 띄우는 함수
    function showErrorMessage() {
        alert("회원가입에 실패했습니다.\n1.양식에 맞지않는 정보 입력\n2.이메일 중복");
        window.history.back();
    }

    // 페이지 로딩이 완료되면 경고창을 띄움
    window.onload = function() {
        showErrorMessage();
    };
</script>
</body>
</html>