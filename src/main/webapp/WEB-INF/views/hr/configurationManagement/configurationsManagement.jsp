<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../css_settings/customSettings.jsp"%>
<body class="sticky-header">
	<script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-functions.js"></script>
	<script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-messaging.js"></script>
	<script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-performance.js"></script>
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
				<h4 class="page-title">기초정보 환경설정</h4>
				<ol class="breadcrumb">
					<li>
						<a href="#">기초정보 환경 설정</a>
					</li>
					<li class="active">근태 항목 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--END Page Title-->
			<!--Start Page Tab-->
			<ul class="nav nav-tabs nav-pills custom-nav">
				<li class="nav-item active">
					<a id="selectHRCode">인사 코드 관리</a>
				</li>
				<li class="nav-item">
					<a id="selectDepartments">부서 코드 관리</a>
				</li>
				<li class="nav-item">
					<a id="selectPosition">직급 코드 관리</a>
				</li>
				<li class="nav-item">
					<a id="selectAttendanceCode">근태 항목 관리</a>
				</li>
			</ul>
			<!--End Page Tab-->
			<!--Start row : 인사 코드 관리 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">인사 코드 관리</h2>
						<div class="table-responsive">
							<table id="configDatatables" class="table table-hover">
							</table>
						</div>
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