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
    	alert("게시글 작성을 위해 로그인 페이지로 이동합니다.");
        window.location.href = "/login";
    }

    // 페이지 로딩이 완료되면 경고창을 띄움
    window.onload = function() {
        showErrorMessage();
    };
</script>
</body>
</html>