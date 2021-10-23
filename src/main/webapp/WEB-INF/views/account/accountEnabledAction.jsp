<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/accountsettings.jsp"%>      
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

	<c:if test="${updateCnt == 1}">
		<script type="text/javascript">
			swal(
					{
						title : "통장미사용",
						type : "success",
						text : "선택하신 통장이 미사용 처리 되었습니다.",
						timer : 2500
					},
					function() {
						window.location = "${ROOT_PATH}/account/accountList?categoryNum=140";
					});
		</script>
	</c:if>

	<c:if test="${updateCnt == 0}">
		<script type="text/javascript">
			swal(
					{
						title : "통장목록",
						type : "error",
						text : "미사용 처리가 되지 않았습니다. \n통장목록을 다시 확인 바랍니다.",
						timer : 2500
					},
					function() {
						window.location = "${ROOT_PATH}/account/slipList?categoryNum=140";
					});
		</script>
	</c:if>

</body>
</html>