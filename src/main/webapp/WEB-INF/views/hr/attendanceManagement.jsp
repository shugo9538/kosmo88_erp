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
			근태관리
			<table>
				<tr>
					<th>근태 코드</th>
					<th>근태 명칭</th>
					<th>근태 유형</th>
					<th>근태 상태</th>
				</tr>
				<tr>
					<th>1000</th>
					<th>2021연가</th>
					<th>휴가</th>
					<th>사용가능</th>
				</tr>
				<tr>
					<th>1000</th>
					<th>2021연가</th>
					<th>휴가</th>
					<th>사용가능</th>
				</tr>
			</table>
			<form >
				<table>
					<tr>
						<th>근태 코드</th>
						<th>근태 명칭</th>
						<th>근태 유형</th>
					</tr>
					<tr>
						<td>
							<input type="number">
							근태 코드
						</td>
						<td>
							<input type="text">
							근태 명칭
						</td>
						<td>
							<select>
								<option>기본</option>
								<option>휴가</option>
								<option>출/퇴근</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- End Wrapper-->
	<%@ include file="../common/footer.jsp"%>
</body>
</html>