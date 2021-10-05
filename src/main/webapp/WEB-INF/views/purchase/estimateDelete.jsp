<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<meta charset="UTF-8">
<title></title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
</head>
<body>

<c:if test="${update == true}">
	<script type="text/javascript">
		swal({
			title:"견적서 삭제 성공",
			type: "success",
			text: "해당 견적서가 삭제되었습니다.",
			timer: 2500
		}, function() {
			opener.parent.location.reload();
			window.close();
		});
	</script>	
</c:if>

<c:if test="${update != true}">
	<script type="text/javascript">
	swal({
		title:"견적서 삭제 실패",
		type: "error",
		text: "잠시 후 다시 시도해주세요!",
		timer: 2500
	}, function() {
		window.history.back();
	});
	</script>	
</c:if>

<%@ include file="../common/footer.jsp"%>
</body>
</html>