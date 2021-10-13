<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../common/settings.jsp"%>
<%@ include file="./js_purchase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<c:if test="${dupchk == 0}">
	<script type="text/javascript">
	swal({
		title:"등록 가능한 사업자 번호입니다.",
		type: "success",
		text: "등록 가능",
		timer: 3000
	}, function() {
		$("#dup_chk", opener.document).val(1);
		window.close();
	});
	</script>
</c:if>

<c:if test="${dupchk != 0}">
	<script type="text/javascript">
	swal({
		title:"이미 등록된 사업자 번호입니다.",
		type: "error",
		text: "등록 불가능",
		timer: 3000
	}, function() {
		window.close();
	});
	</script>
</c:if>

</body>
</html>