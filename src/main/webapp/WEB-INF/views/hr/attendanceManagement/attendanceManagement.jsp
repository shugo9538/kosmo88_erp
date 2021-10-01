<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content ">
		<!-- header section start-->
		<%@ include file="../../common/header.jsp"%>
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">근태 관리</h4>
				<ol class="breadcrumb">
					<li>
						<a href="#">근태 관리</a>
					</li>
					<li class="active">근태 조회</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--END Page Title-->
			<!--Start Page Tab-->
			<ul class="nav nav-pills custom-nav">
				<li class="active">
					<a id="selectAttendacne">근태 조회</a>
				</li>
				<li class="active">
					<a id="commutingRecords">출퇴근 기록부</a>
				</li>
			</ul>
			<!--End Page Tab-->
			<!--Start row : 근태 항목 관리 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box" id="datatables">
					</div>
				</div>
			</div>
			<!--End row-->
		</div>
		<!-- End Wrapper-->
		<%@ include file="../../common/footer.jsp"%>
		<%@ include file="../js_settings/js_attendance.jsp"%>
</body>
</html>