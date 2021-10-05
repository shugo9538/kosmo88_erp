<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/accountsettings.jsp"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
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
		<!-- 전표 승인상태 체크 (실패)  -->
		<c:if test="${NOT_APPROVED == 10}">
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
		
		<!-- 전표 부서번호 체크 (실패)  -->
		<c:if test="${UNIDENTIFIED == 11}">
			<script type="text/javascript">
				swal({
					title:"부서번호",
					type: "error",
					text: "부서번호가 확인 되지 않습니다.",
					timer: 2500
				}, function() {
					window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
				});
			</script>
		</c:if>	
			
		<!-- 전표 승인상태가 아닐때  -->
		<c:if test="${updateCnt == 0}">
			<script type="text/javascript">
				swal({
					title:"전표상태",
					type: "error",
					text: "전표 승인상태를 확인 바랍니다.",
					timer: 2500
				}, function() {
					window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
				});
			</script>
		</c:if>	
		
		<!-- REQUEST_TBL 업데이트 실패  -->
		<c:if test="${FAIL == 14}">
			<script type="text/javascript">
			swal({
				title:"부서상태",
				type: "error",
				text: "부서상태가 업데이트 되지 않았습니다.",
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
					title:"전표상태",
					type: "success",
					text: "선택하신 전표가 승인 처리 되었습니다.",
					timer: 2500
				}, function() {
					window.location="${ROOT_PATH}/account/slipList?categoryNum=140";
				});
			</script>
		</c:if>
</body>
</html>