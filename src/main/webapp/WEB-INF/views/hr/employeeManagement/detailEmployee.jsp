<%@page import="com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO"%>
<%@page import="com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/settings.jsp"%>
<body class="sticky-header">
	<c:if test="${insert_code}">
		<script type="text/javascript">
            window.close();
        </script>
	</c:if>
	<div class="wrapper">
		<!--Start row : 근태 항목 입력 -->
		<!--Start row-->
		<div class="row">
			<div class="col-md-12">
				<!-- Start white-box -->
				<div class="white-box" id="white-box">
					<h2 class="header-title">
						<i class="fa fa-chevron-circle-right mr-2"></i>
						인사카드
					</h2>
					<table id="client" class="display table mt-12" style="width: 100%">
						<tr>
							<th style="background-color: #f1f1f1;">사진</th>
							<td colspan="3">
								<img id="photo" src="${employee.photo}">
								</div>
							</td>
						</tr>
						<tr>
							<th style="background-color: #f1f1f1;">부서</th>
							<td>
								<input type="text" name="department_id" id="department_id" value="${employee.department_id}" readonly>
							</td>
							<th style="background-color: #f1f1f1;">이름</th>
							<td>
								<input type="text" name="name" id="name" value="${employee.name}">
							</td>
						</tr>
						<tr>
							<th style="background-color: #f1f1f1;">주민등록번호</th>
							<td>
								<input type="text" id="resident_reg_num" name="resident_reg_num" value="${employee.resident_reg_num}" readonly>
							</td>
							<th style="background-color: #f1f1f1;">이메일</th>
							<td>
								<input class="input" type="text" id="email1" name="email1" value="${employee.email}" readonly>
							</td>
						</tr>
						<tr>
							<th rowspan="3" style="background-color: #f1f1f1;">주소</th>
							<td>
								<input type="text" name="zip_code" id="zip_code" value="${employee.zip_code}" readonly>
							</td>
							<th style="background-color: #f1f1f1;">전화번호</th>
							<td>
								<input type="text" id="phone" name="phone" value="${employee.phone}" readonly>
							</td>
						</tr>
						<tr>
							<td>
								<input style="width: 350px;" type="text" name="address" id="address" value="${employee.address}" readonly>
							</td>
							<th style="background-color: #f1f1f1;">입사일</th>
							<td>
								<fmt:formatDate value="${employee.hire_date}" pattern="yy년 MM월 dd일 " />
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" name="detail_address" id="detail_address" value="${employee.detail_address}" readonly>
							</td>
							<th style="background-color: #f1f1f1;">직급</th>
							<td>
								<input style="width: 350px;" type="text" name="detail_address" id="detail_address"
									value="${employee.position_id}" readonly
								>
							</td>
						</tr>
						<tr>
							<td colspan="4" style="text-align: center;">
								<input type="button" id="updateEmployee" value="수정">
								<input type="reset" value="취소" onclick="window.close();">
							</td>
						</tr>
					</table>
				</div>
				<!-- end white-box -->
			</div>
		</div>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<%@ include file="../js_settings/js_insertAttendance.jsp"%>
</body>
</html>