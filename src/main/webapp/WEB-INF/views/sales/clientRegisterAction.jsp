<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script src="${RESOURCES_PATH}/sales/js/clientRegister.js"></script>
<body class="sticky-header">
	
<c:if test="${insertCnt == 0}">
	<script type="text/javascript">
		errorAlert(insertError);
	</script>
</c:if>

<c:if test="${insertCnt == 1 }">
	<script type="text/javascript">
		alert("거래처를 등록하였습니다.");
		window.history.back();
	</script>
</c:if>

</body>
</html>