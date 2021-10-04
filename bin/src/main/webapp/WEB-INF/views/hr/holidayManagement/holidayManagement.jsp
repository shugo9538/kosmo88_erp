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
				<h4 class="page-title">휴가 관리</h4>
				<ol class="breadcrumb">
					<li>
						<a href="#">휴가 관리</a>
					</li>
					<li class="active">휴가 잔여일수 현황</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--END Page Title-->
			<!--Start Page Tab-->
			<ul class="nav nav-pills custom-nav">
				<li class="active">
					<a>휴가 잔여일수 현황</a>
				</li>
				<li class="active">
					<a>휴가 사용실적</a>
				</li>
				<li class="active">
					<a>근태 집계표</a>
				</li>
			</ul>
			<!--End Page Tab-->
			<!--Start row : 근태 항목 관리 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box"  id=holidayDatatables>
					</div>
				</div>
			</div>
			<!--End row-->
			<!--Start row : 근태 항목 입력 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">근태 입력</h2>
						<div class="table-responsive">
							<form action="${ROOT_PATH}/hr/attendance/insertAttendance" method="post">
								<sec:csrfInput />
								<table class="table table-hover">
									<thead>
										<tr>
											<th>근태 아이디</th>
											<th>근태 코드</th>
											<th>근태 신청일</th>
											<th>시작</th>
											<th>종료</th>
											<th>사유</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<input type="text" name="id">
											</td>
											<td>
												<input type="text" name="attendance_cd_id">
											</td>
											<td>
												<input type="date" name="application_date">
											</td>
											<td>
												<input type="date" name="begin_date">
											</td>
											<td>
												<input type="date" name="end_date">
											</td>
											<td>
												<input type="text" name="reason">
											</td>
										</tr>
										<tr>
											<td colspan="6" align="center">
												<input type="submit" value="등록">
												<input type="reset" value="취소">
											</td>
										</tr>
									</tbody>
								</table>
							</form>
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