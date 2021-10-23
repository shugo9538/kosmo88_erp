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
		<c:if test="${insertCnt == 1}">
		<script type="text/javascript">
			swal(
					{
						title : "통장목록",
						type : "success",
						text : "신규통장이 추가되었습니다.",
						timer : 2500
					},
					function() {
						window.location = "${ROOT_PATH}/account/accountList?categoryNum=140";
					});
		</script>
	</c:if>
	
		<c:if test="${insertCnt == 0}">
		<script type="text/javascript">

			swal({
				title : "통장목록",
				type : "error",
				text : "신규통장이 추가에 실패하였습니다.",
				timer : 2500
			}, function() {
				window.history.back();
			});
		</script>
	</c:if>
</body>
</html>