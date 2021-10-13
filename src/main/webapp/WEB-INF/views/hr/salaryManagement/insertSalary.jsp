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
						<sec:csrfInput />
					<form id="insertSalaryForm" action="${ROOT_PATH}/hr/salary/insertSalaryAction" method="post">
						<div class="table-responsive" align="center">
							<table id="insertSalaryTable" class="table table-hover">
								<thead>
									<tr>
										<th>지급 대상</th>
										<th>기본급</th>
										<th>초과 근무 수당</th>
										<th>성과금</th>
										<th>식대료</th>
										<th>급여일</th>
										<th>소득세</th>
										<th>월급(합계)</th>
									</tr>
								</thead>
								<tbody id="salary-group">
									<tr id="salary" style="display: none;">
										<td>
											<input class="form-control" name="employee_id" type="text" onclick="javascript:void(searchEmployee());" disabled>
										</td>
										<td>
											<input class="form-control" name="basic_pay" type="number" disabled>
										</td>
										<td>
											<input class="form-control" name="overtime_pay" type="number" disabled>
										</td>
										<td>
											<input class="form-control" name="bonus" type="number" disabled>
										</td>
										<td>
											<input class="form-control" name="meal_fee" type="number" disabled>
										</td>
										<td>
											<input class="form-control" name="payday" type="date" disabled>
										</td>
										<td>
											<input class="form-control" name="income_tax" type="number" disabled>
										</td>
										<td>
											<input name="employee_salary" type="number" disabled>
										</td>
										<td weight="1">
											<div role="button" onclick="delSalary(this);">
												<i class="icon-minus"></i>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							<div role="button" class="preview col-md-12 md-5" id="addSalary" onclick="addSalary()">
								<i class="icon-plus"></i>
								항목 추가
							</div>
							<div style="text-align: center;">
								<button id="insertSalaryAction">등록</button>
								<input type="reset" value="취소" onclick="window.close();">
							</div>
						</div>
					</form>
				</div>			</div>
		</div>
	</div>
	<!--End row-->
	</div>
	<%@ include file="../js_settings/js_insertAttendance.jsp"%>
</body>
</html>