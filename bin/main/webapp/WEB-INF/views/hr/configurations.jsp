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
			<ul class="nav nav-pills custom-nav">
				<li class="active">
					<a href="${ROOT_PATH}/hr/configurations/attendanceCode">근태 항목 관리</a>
				</li>
				<li class="active">
					<a href="${ROOT_PATH}/">사원별 휴가 일수 조회</a>
				</li>
				<li class="active">
					<a href="${ROOT_PATH}/">급여 관리</a>
				</li>
				<li class="active">
					<a href="${ROOT_PATH}/">호봉 테이블</a>
				</li>
			</ul>
			<!--End Page Tab-->
			<!--Start row : 근태 항목 관리 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">근태 항목 관리</h2>
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>근태 코드</th>
										<th>근태 명칭</th>
										<th>근태 유형</th>
										<th>허가 여부</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="acDTO" items="${acList}">
										<tr>
											<td>1</td>
											<td>${acDTO.id}</td>
											<td>${acDTO.name}</td>
											<td>${acDTO.type}</td>
											<td>${acDTO.enabled}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!--End row-->
			
			<!--Start row : 사원별 휴가 일수 조회 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">사원별 휴가 일수 조회</h2>
						<div class="table-responsive">
							<form action="${ROOT_PATH}/hr/configurations/insertAttendanceCode" method="POST">
								<sec:csrfInput />
								<table class="table table-hover">
									<thead>
										<tr>
											<th>근태 코드</th>
											<th>근태 명칭</th>
											<th>근태 유형</th>
											<th>허가 여부</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<input type="text" name="id">
											</td>
											<td>
												<input type="text" name="name">
											</td>
											<td>
												<input type="text" name="type">
											</td>
											<td>
												<select name="enabled">
													<option value="Y">Y</option>
													<option value="N">N</option>
												</select>
											</td>
										</tr>
										<tr>
											<td colspan="4" align="center">
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
			<!--Start row : 근태 항목 추가 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">근태 항목 추가</h2>
						<div class="table-responsive">
							<form action="${ROOT_PATH}/hr/configurations/insertAttendanceCode" method="POST">
								<sec:csrfInput />
								<table class="table table-hover">
									<thead>
										<tr>
											<th>근태 코드</th>
											<th>근태 명칭</th>
											<th>근태 유형</th>
											<th>허가 여부</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<input type="text" name="id">
											</td>
											<td>
												<input type="text" name="name">
											</td>
											<td>
												<input type="text" name="type">
											</td>
											<td>
												<select name="enabled">
													<option value="Y">Y</option>
													<option value="N">N</option>
												</select>
											</td>
										</tr>
										<tr>
											<td colspan="4" align="center">
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
		<%@ include file="../common/footer.jsp"%>
</body>
</html>