<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2 class="header-title">근태 조회</h2>
<div class="table-responsive">
	<table id="attendanceTable" class="display table">
		<thead>
			<tr>
				<th>
					<input type="checkbox">
				</th>
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
		<tfoot>
			<tr>
				<th>
					<button id="insertAttendance">근태 입력</button>
				</th>
			</tr>
		</tfoot>
	</table>
</div>
