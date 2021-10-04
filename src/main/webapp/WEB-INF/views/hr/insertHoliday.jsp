<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	<c:if test="${stateCode == true}">
	</c:if>
	<div class="wrapper">
		<!--Start row : 근태 항목 입력 -->
		<div class="row">
			<div class="col-md-12">
				<div class="white-box">
					<h2 class="header-title">근태 입력</h2>
						<sec:csrfInput />
					<form id="insertAttendanceForm" action="${ROOT_PATH}/hr/attendance/insertAttendanceAction" method="post">
						<div class="table-responsive" align="center">
							<table id="insertAttendanceTable" class="table table-hover">
								<thead>
									<tr>
										<th>사원 코드</th>
										<th>휴가 사용일</th>
										<th>연차</th>
										<th>휴가 코드</th>
										<th>삭제 버튼</th>
									</tr>
								</thead>
								<tbody id="attendance-group">
									<tr id="attendance" style="display: none;">
										<td>
											<input class="form-control" name="employee_id" type="number" disabled>
										</td>
										<td>
											<input class="form-control" name="use_date" type="number" disabled>
										</td>
										<td>
											<input class="form-control" name="annual_holiday" type="date" disabled>
										</td>
										<td>
											<input class="form-control" name="holiday_id" type="date" disabled>
										</td>
										<td weight="1">
											<div role="button" onclick="delAttendance(this);">
												<i class="icon-minus"></i>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							<div role="button" class="preview col-md-12 md-5" id="addAttendance" onclick="addAttendance()">
								<i class="icon-plus"></i>
								항목 추가
							</div>
							<div style="text-align: center;">
								<button id="insertAttendanceAction">등록</button>
								<input type="reset" value="취소" onclick="window.close();">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--End row-->
	</div>
	<%@ include file="js_settings/js_insertAttendance.jsp"%>
</body>
</html>