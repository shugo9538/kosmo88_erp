<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2 class="header-title">출퇴근 기록부</h2>
<div class="table-responsive">
	<table id="commutingRecordsTable" class="table table-hover">
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
	</table>
</div>
<!--End row-->
<!--Start row : 출퇴근 입력 -->
<h2 class="header-title">출퇴근 입력</h2>
<div class="table-responsive">
	<form action="${ROOT_PATH}/hr/attendance/insertCommute" method="post">
		<sec:csrfInput />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
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
<!--End row-->