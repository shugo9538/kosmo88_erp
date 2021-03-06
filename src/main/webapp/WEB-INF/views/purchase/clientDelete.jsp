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
			title:"거래처 삭제",
			type: "success",
			text: "해당 거래처가 삭제되었습니다.",
			timer: 2500
		}, function() {
			opener.parent.location.reload();
			window.close();
		});
	</script>	
</c:if>

<c:if test="${update != true}">
	<script type="text/javascript">
		alert("해당 거래처 삭제가 실패하였습니다. 다시 시도해주세요!!");
		window.history.back();
	</script>
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

</body>
</html>