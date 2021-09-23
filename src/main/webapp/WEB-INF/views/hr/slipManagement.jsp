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
				<h4 class="page-title">전표 관리</h4>
				<ol class="breadcrumb">
					<li>
						<a href="#">전표 관리</a>
					</li>
					<li class="active">전표 생성</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--END Page Title-->
			<!--Start Page Tab-->
			<ul class="nav nav-pills custom-nav">
				<li class="active">
					<a href="${ROOT_PATH}/hr/holiday/leftHolidayNum">전표 생성</a>
				</li>
				<li class="active">
					<a href="${ROOT_PATH}/hr/holiday/useHolidayNum">전표 집계</a>
				</li>
			</ul>
			<!--End Page Tab-->
			<!--Start row : 급여관리 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">전표 관리</h2>
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>사원 코드</th>
										<th>휴가 사용일</th>
										<th>연차</th>
										<th>휴가 코드</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="huDTO" items="${holidayUsageList}">
										<tr>
											<td>1</td>
											<td>${huDTO.employee_id}</td>
											<td>${huDTO.use_date}</td>
											<td>${huDTO.annual_holiday}</td>
											<td>${huDTO.holiday_id}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!--End row-->
		</div>
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
</body>
</html>