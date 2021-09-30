<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">

<c:if test="${deleteCnt == 0}">
	<script type="text/javascript">
		errorAlert(deleteError);
	</script>
</c:if>

<c:if test="${deleteCnt == 1 }">
	<script type="text/javascript">
		alert("거래처가 삭제 되었습니다.");
		window.close();
	</script>
</c:if>

</body>
</html>