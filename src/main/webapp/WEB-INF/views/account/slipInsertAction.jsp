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
		<c:if test="${FAIL == 14}">
			<script type="text/javascript">
				swal({
					title:"지출결의서",
					type: "error",
					text: "지출결의서 등록 실패 하였습니다. 확인 후 다시 등록바랍니다.",
					timer: 2500
				}, function() {
					window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
				});
			</script>
		</c:if>
			
		<!-- EXPENSE_TBL 등록실패  -->
		<c:if test="${EXPENSE == 18}">
			<script type="text/javascript">
			swal({
				title:"비용등록",
				type: "error",
				text: "비용등록이 되지 않았습니다. 다시 확인 바랍니다.ㄴ",
				timer: 2500
			}, function() {
				window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
			});
			</script>
		</c:if>			
		
		<!-- REQUEST 요청코드   -->
		<c:if test="${REQUEST_CODE_FAIL == 16}">
			<script type="text/javascript">
			swal({
				title:"요청코드 확인",
				type: "error",
				text: "요청정보가 확인 되지 않습니다. 다시 확인 바랍니다.",
				timer: 2500
			}, function() {
				window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
			});
			</script>
		</c:if>			
		
		<!-- 사원번호 요청코드   -->
		<c:if test="${EMPLOYEE_ID == 17}">
			<script type="text/javascript">
			swal({
				title:"사원번호 확인",
				type: "error",
				text: "사원번호가 확인 되지 않습니다. 다시 확인 바랍니다.",
				timer: 2500
			}, function() {
				window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
			});
			</script>
		</c:if>			
				
		<!-- 전표 승인상태 체크 (성공)  -->
		<c:if test="${SUCCESS == 13}">
			<script type="text/javascript">
				swal({
					title:"지출결의",
					type: "success",
					text: "요청하신 지출결의가 등록 되었습니다.",
					timer: 2500
				}, function() {
					window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
				});
			</script>
		</c:if>
</body>
</html>