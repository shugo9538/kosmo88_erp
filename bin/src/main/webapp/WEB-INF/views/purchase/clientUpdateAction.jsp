<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<c:if test="${update == true}">
	<script type="text/javascript">
		alert("내용이 수정 되었습니다.");
<<<<<<< HEAD
=======
		opener.parent.location.reload();
>>>>>>> 93c57a16fe887c0213199b3599ad6f190506bdb7
		window.close();
	</script>
</c:if>

<c:if test="${update != true}">
	<script type="text/javascript">
		alert("내용 수정이 실패하였습니다. 다시 시도해주세요!!");
		window.history.back();
	</script>
</c:if>

<%@ include file="../common/footer.jsp"%>
</body>
</html>