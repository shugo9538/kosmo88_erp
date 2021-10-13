<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../common/settings.jsp"%>
<%@ include file="./js_purchase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<c:if test="${update == true}">
	<script type="text/javascript">
	swal({
		title:"거래처 내용 수정 성공",
		type: "success",
		text: "내용이 수정 되었습니다.",
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
		title:"거래처 내용 수정 실패",
		type: "error",
		text: "잠시 후 다시 시도해주세요!",
		timer: 2500
	}, function() {
		window.history.back();
	});
	</script>
</c:if>

</body>
</html>