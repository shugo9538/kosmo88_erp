<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/settings.jsp"%>
<body class="sticky-header">
	<c:if test="${stateCode == true}">
	</c:if>
	<div class="wrapper">
		<!--Start row : 근태 항목 입력 -->
		<div class="row">
			<div class="col-md-12">
				<div class="white-box">
					<h2 class="header-title">근태 입력</h2>
					<div class="table-responsive">
						<form id="insertAttendanceForm" action="${ROOT_PATH}/hr/attendance/insertAttendanceAction" method="post">
							<sec:csrfInput />
							<table id="insertAttendanceTable" class="table table-hover">
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
											<input type="submit" id="insertAttendanceAction" value="등록">
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
	<%@ include file="../js_settings/js_insertAttendance.jsp"%>
</body>
</html>