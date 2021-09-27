<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	
<c:if test="${insertCnt == 0}">
	<script type="text/javascript">
		errorAlert(insertError);
	</script>
</c:if>

<c:if test="${insertCnt == 1 }">
	<script type="text/javascript">
		alert("거래처를 등록하였습니다.")
	</script>
	<c:redirect url="clientRegister?insertCnt=${insertCnt}"/>
</c:if>

</body>
</html>