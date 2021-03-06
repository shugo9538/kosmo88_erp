<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<title></title>
</head>
<body>

<c:if test="${update == true}">
	<script type="text/javascript">
		swal({
			title:"거래처 삭제",
			type: "success",
			text: "선택하신 거래처가 삭제되었습니다.",
			timer: 2500
		}, function() {
			window.location= "/logistics_erp/purchase/clientManagement"
		});
	</script>
</c:if>

<c:if test="${update != true}">
	<script type="text/javascript">
		swal({
			title:"거래처 삭제 실패",
			type: "error",
			text: "잠시 후 다시 시도해주세요!",
			timer: 2500
		}, function() {
			window.history.back();
		});
	</script>
</c:if>

<%@ include file="../common/footer.jsp"%>
<%@ include file="./js_purchase.jsp"%>
</body>
</html>