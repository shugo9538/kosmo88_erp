<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
    일자: <input type="text" id="datepicker"><!-- 스크립트 소스보다 인풋이 위에있어야함  -->
    
    <script>
        $("#datepicker").datepicker();
    </script>
 

</body>
</html>