<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/settings.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			
			
			
					<h3 style="color:white">그림가져오기</h3>
			
				<c:forEach var="dto" items="${list}">
				
					<img alt="1" src="${dto}">
					
				</c:forEach>
				
				
				
				
</body>
</html>