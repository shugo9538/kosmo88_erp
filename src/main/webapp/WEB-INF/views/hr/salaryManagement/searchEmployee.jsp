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
					<h2 style="font-size: 34px; text-align: center;" class="header-title col-md-12 mb-5">담당자 목록</h2>
					<form class="form-horizontal">
						<table id="searchEmployeeSalary" class="display table">
							<thead>
								<tr>
									<th>사원 번호</th>
									<th>이름</th>
									<th>부서</th>
									<th>연락처</th>
									<th>이메일</th>
								</tr>
								<tr>
									<th>초과근무 수당</th>
									<th>야근 시간</th>
									<th>출석일</th>
									<th>월급</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="dto" items="${dtos}">
									<tr>
										<th>
											<input style="border: none;" type="text" id="employee_id" value="${dto.id}" readonly>
										</th>
										<td>
											<input style="border: none;" type="text" id="employee_name" value="${dto.name}" readonly>
										</td>
										<td>
											<input style="border: none;" type="text" id="department_name" value="${dto.department_name}" readonly>
										</td>
										<td>
											<input style="border: none;" type="text" id="employee_phone" value="${dto.phone}" readonly>
										</td>
										<td>
											<input style="border: none;" type="text" id="employee_email" value="${dto.email}" readonly>
										</td>
									</tr>
									<tr>
										<td>
											<input style="border: none;" type="text" id="employee_over_time" value="${dto.overtime_pay}" readonly>
										</td>
										<td>
											<input style="border: none;" type="text" id="employee_night_time" value="${dto.night_time}" readonly>
										</td>
										<td>
											<input style="border: none;" type="text" id="employee_work_day" value="${dto.work_day}" readonly>
										</td>
										<td>
											<input style="border: none;" type="text" id="employee_basic_pay" value="${dto.basic_pay}" readonly>
											<input style="border: none;" type="hidden" id="employee_time_pay" value="${dto.time_pay}" readonly>
										</td>
										<td>
											<input class="btn btn-primary" type="button" id="select" name="${dto.name}" value="선택" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div style="text-align: center;" class="form-group mt-5 col-md-12">
							<input class="btn  btn-primary" type="button" value="닫기" onclick="window.close();" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--End row-->
	</div>
	<%@ include file="../js_settings/js_insertAttendance.jsp"%>
</body>
</html>