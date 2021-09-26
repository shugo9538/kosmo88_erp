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
	<!-- 					근태 조회 버튼 임시 -->
					<button id="selectAttendacne">근태 조회</button>
<%-- 					<a href="${ROOT_PATH}/hr/attendance/selectAttendacne">근태 조회</a> --%>
				</li>
				<li class="active">
					<a href="${ROOT_PATH}/hr/attendance/attendanceStatus">근태 현황</a>
				</li>
				<li class="active">
					<a href="${ROOT_PATH}/hr/attendance/commutingRecords">출퇴근 기록부</a>
				</li>
			</ul>
			<!--End Page Tab-->
			<!--Start row : 근태 항목 관리 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">근태 조회</h2>
						<div class="table-responsive">
							<table id="example" class="display table">
								<thead>
									<tr>
										<th>#</th>
										<th>근태 아이디</th>
										<th>근태 코드</th>
										<th>근태 신청일</th>
										<th>시작</th>
										<th>종료</th>
										<th>사유</th>
										<th>상태</th>
									</tr>
								</thead>
								
<!-- 								여기다가 결과물 뿌림 -->
								<tbody id="attendanceList">
									<c:forEach var="aDTO" items="${attendanceList}">
										<tr>
											<td>1</td>
											<td>${aDTO.id}</td>
											<td>${aDTO.attendance_cd_id}</td>
											<td>${aDTO.application_date}</td>
											<td>${aDTO.begin_date}</td>
											<td>${aDTO.end_date}</td>
											<td>${aDTO.reason}</td>
											<td>${aDTO.state}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
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
<%-- 							<form action="${ROOT_PATH}/hr/attendance/insertAttendance" method="post"> --%>
<%-- 								<sec:csrfInput /> --%>
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
												<button id="insertAttendance">등록</button>
												<input type="reset" value="취소">
											</td>
										</tr>
									</tbody>
								</table>
<!-- 							</form> -->
						</div>
					</div>
				</div>
			</div>
			<!--End row-->
			
			<!--Start row : 출퇴근 기록부 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">출퇴근 기록부</h2>
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>출퇴근 아이디</th>
										<th>근무일</th>
										<th>시작 시각</th>
										<th>종료 시각</th>
										<th>야근 시간</th>
										<th>초과근무 시간</th>
										<th>근태</th>
										<th>사원번호</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="commuteDTO" items="${commuteList}">
										<tr>
											<td>1</td>
											<td>${commuteDTO.id}</td>
											<td>${commuteDTO.work_date}</td>
											<td>${commuteDTO.begin_date}</td>
											<td>${commuteDTO.end_date}</td>
											<td>${commuteDTO.night_time}</td>
											<td>${commuteDTO.over_time}</td>
											<td>${commuteDTO.attendance_id}</td>
											<td>${commuteDTO.employee_id}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!--End row-->
			
			<!--Start row : 출퇴근 입력 -->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">출퇴근 입력</h2>
						<div class="table-responsive">
							<form action="${ROOT_PATH}/hr/attendance/insertCommute" method="post">
								<sec:csrfInput />
								<table class="table table-hover">
									<thead>
										<tr>
											<th>근무일</th>
											<th>시작시각</th>
											<th>종료시각</th>
											<th>야근</th>
											<th>초과근무</th>
											<th>근태</th>
											<th>사원</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<input type="date" name="work_date">
											</td>
											<td>
												<input type="time" name="begin_date">
											</td>
											<td>
												<input type="time" name="end_date">
											</td>
											<td>
												<input type="number" name="night_time">
											</td>
											<td>
												<input type="number" name="over_time">
											</td>
											<td>
												<input type="text" name="attendance_id">
											</td>
											<td>
												<input type="text" name="employee_id">
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
		<%@ include file="../common/footer.jsp"%>
</body>
</html>