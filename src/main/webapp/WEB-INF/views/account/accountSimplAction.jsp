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
				swal("통장거래내역","거래내역이 추가 되었습니다.","success",{
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
		
		<c:if test="${insertCnt == 0}">
			<script type="text/javascript">
			swal("거래내역추가","계좌번호가 확인 되지 않습니다. \n 다시 확인 바랍니다..","error",{
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
		
		<c:if test="${insertCnt == 2}">
			<script type="text/javascript">
			swal("통장잔액","잔액 업데이트에 실패하였습니다.","error",{
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