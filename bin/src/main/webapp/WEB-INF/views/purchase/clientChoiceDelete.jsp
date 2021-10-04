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
		alert("선택하신 거래처가 삭제되었습니다.");
		window.location= "/logistics_erp/purchase/clientManagement"
	</script>
</c:if>

<c:if test="${update != true}">
	<script type="text/javascript">
		alert("거래처 삭제에 실패하였습니다. 다시 시도해주세요!!");
		window.history.back();
	</script>
</c:if>

<%@ include file="../common/footer.jsp"%>
</body>
</html>