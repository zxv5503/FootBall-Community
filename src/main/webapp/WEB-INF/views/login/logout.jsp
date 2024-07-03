<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그아웃</title>
</head>
<body>
    <script type="text/javascript">
        // 페이지가 로드될 때 실행되는 JavaScript 함수
        window.onload = function() {
            // confirm 함수를 사용하여 사용자에게 확인 대화상자를 표시
            var confirmation = confirm("로그아웃되었습니다.");
            // 사용자가 확인을 클릭하면 true를 반환하고, 취소를 클릭하면 false를 반환
            if (confirmation) {
                // 확인을 클릭한 경우, 로그인 페이지로 리다이렉트
                window.location.href = "/login";
            } else {
                // 취소를 클릭한 경우, 뒤로 가기 기능을 수행하여 이전 페이지로 이동
                window.history.back();
            }
        };
    </script>
</body>
</html>
