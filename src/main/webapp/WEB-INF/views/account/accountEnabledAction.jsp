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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<!-- END PAGE LEVEL STYLES -->
</head>
<body>

		<c:if test="${updateCnt == 1}">
			<script type="text/javascript">
				swal("통장목록","신규통장이 추가되었습니다. 목록으로 이동합니다.","success",{
					closeOnclickOutside : false,
					closeEsc: false,
					buttons : {
						text : '확인',
						value : true,
						timer : 3000
					}
				});
				window.location="${ROOT_PATH}/account/accountList?categoryNum=140";
			</script>
		</c:if>
		
		<c:if test="${updateCnt == 0}">
			<script type="text/javascript">
				alert("통장 추가가 실패 하였습니다.");
				window.history.back();
			</script>	
		</c:if>


<!--Begin core plugin -->
<script src="/logistics_erp/resources/assets/js/jquery.min.js"></script>
<script src="/logistics_erp/resources/assets/js/bootstrap.min.js"></script>
<script src="/logistics_erp/resources/assets/plugins/moment/moment.js"></script>
<script  src="/logistics_erp/resources/assets/js/jquery.slimscroll.js "></script>
<script src="/logistics_erp/resources/assets/js/jquery.nicescroll.js"></script>
<script src="/logistics_erp/resources/assets/js/functions.js"></script>
<!-- End core plugin -->
		
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="/logistics_erp/resources/assets/plugins/sweetalert/sweet-alert.js"></script>
<script src="/logistics_erp/resources/assets/pages/jquery.sweet-alert.custom.js"></script>
<!-- BEGIN PAGE LEVEL SCRIPTS -->		
	
</body>
</html>