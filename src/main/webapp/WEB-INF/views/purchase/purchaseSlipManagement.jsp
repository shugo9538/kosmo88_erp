<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">구매전표 관리</h4>
				<ol class="breadcrumb">
					<li class="active">구매전표 관리</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/purchase/purchaseSlipRegister">구매전표 등록</a></li>
				<li class="active"><a href="${ROOT_PATH}/purchase/purchaseSlipDelete">구매전표 삭제</a></li>
			</ul>
		</div>
		<!-- End Wrapper-->
		
		<%@ include file="../common/footer.jsp"%>
</body>
</html>