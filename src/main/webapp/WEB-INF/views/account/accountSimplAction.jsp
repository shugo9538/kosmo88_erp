<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/accountsettings.jsp"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- BEGIN PAGE LEVEL STYLES -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />
<!-- END PAGE LEVEL STYLES -->
</head>
<body>

	<c:if test="${insertCnt == 1}">
		<script type="text/javascript">
			swal(
					{
						title : "통장거래내역",
						type : "success",
						text : "거래내역이 추가 되었습니다",
						timer : 2500
					},
					function() {
						window.location = "${ROOT_PATH}/account/accountList?categoryNum=140";
					});
		</script>
	</c:if>

	<c:if test="${insertCnt == 0}">
		<script type="text/javascript">
			swal(
					{
						title : "거래내역추가",
						type : "error",
						text : "계좌번호가 확인 되지 않습니다. \n 다시 확인 바랍니다.",
						timer : 2500
					},
					function() {
						window.location = "${ROOT_PATH}/account/accountList?categoryNum=140";
					});
		</script>
	</c:if>


	<c:if test="${insertCnt == 2}">
		<script type="text/javascript">
			swal(
					{
						title : "통장잔액",
						type : "error",
						text : "잔액 업데이트에 실패하였습니다.",
						timer : 2500
					},
					function() {
						window.location = "${ROOT_PATH}/account/accountList?categoryNum=140";
					});
		</script>
	</c:if>

</body>
</html>