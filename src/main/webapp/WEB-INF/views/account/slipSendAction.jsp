<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/accountsettings.jsp"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KU ERP</title>
<!-- BEGIN PAGE LEVEL STYLES -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<!-- END PAGE LEVEL STYLES -->
</head>
<body>

		<!-- 전표 승인상태 체크 (실패)  -->
		<c:if test="${successCnt == 0}">
			<script type="text/javascript">
				swal({
					title:"승인상태",
					type: "error",
					text: "전표의 승인상태를 다시 확인 바랍니다.",
					timer: 2500
				}, function() {
					window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
				});
			</script>
		</c:if>
		
		<!-- 전표 승인상태 체크 (성공)  -->
		<c:if test="${successCnt == 1}">
			<script type="text/javascript">
				swal({
					title:"발송안내",
					type: "success",
					text: "승인안내 문자가 발송 되었습니다.",
					timer: 2500
				}, function() {
					window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
				});
			</script>
		</c:if>
		
</body>
</html>