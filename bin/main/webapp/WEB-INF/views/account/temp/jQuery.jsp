<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>제이쿼리 위젯 달력 사용하기</title>
  
</head>
<body>

<%@ include file="../common/accountHeader.jsp" %>

		<!-- 여기있으면 input태그 무조건 위에 있어야함 -->
          <!--   <script type="text/javascript">
			$(function(){
			
			    $("#date1").datepicker();
			
			});
			</script> -->
<%@ include file="../common/accountFooter.jsp" %>
<input type="text" name="date" id="date1" size="12" />


</body>
</html>