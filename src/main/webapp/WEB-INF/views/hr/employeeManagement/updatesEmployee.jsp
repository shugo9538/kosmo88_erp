<%@page import="com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO"%>
<%@page import="com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/settings.jsp"%>
<body class="sticky-header">
	<c:if test="${update_code}">
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
					<form class="form-horizontal" name="updateEmployeeAction" id="updateEmployeeAction"
						action="${ROOT_PATH}/hr/employee/${employee.id}/updateEmployeeAction" method="post" enctype="multipart/form-data"
						accept-charset="UTF-8"
					>
						<!-- csrf 토큰 -->
						<sec:csrfInput />
						<h2 class="header-title">
							<i class="fa fa-chevron-circle-right mr-2"></i>
							인사카드 수정 등록
						</h2>
						<table id="client" class="display table mt-12" style="width: 100%"> 
							<tr>
								<th rowspan="2" style="background-color: #f1f1f1;">사진</th>
								<td colspan="3">
									<div id="temp_image">
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<input type="file" name="photo" id="photo" accept="/" onchange="setImage(event);" value="${employee.photo}" required>
								</td>
							</tr>
							<tr>
								<th style="background-color: #f1f1f1;">부서</th>
								<td>
									<select name="department_id" id="department_id">
										<c:forEach items="${departmentCodeDTOs}" var="dto">
											<c:if test="${dto.id == employee.department_id}">
												<option value="${dto.getId()}" selected>${dto.name}</option>
											</c:if>
											<c:if test="${dto.id != employee.department_id}">
												<option value="${dto.getId()}">${dto.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</td>
								<th style="background-color: #f1f1f1;">이름</th>
								<td>
									<input type="text" name="name" id="name" value="${employee.name}" required placeholder="홍길동">
								</td>
							</tr>
							<tr>
								<th style="background-color: #f1f1f1;">주민등록번호</th>
								<c:set value="${employee.resident_reg_num}" var="regi" />
								<td>
									<input style="width: 100px;" type="text" id="register_num1" name="resident_reg_num1" maxlength="6" required
										onkeyup="nextRegisterNum1()" value="${fn:substringBefore(regi, '-')}"
									>
									-
									<input style="width: 100px;" type="text" id="register_num2" name="resident_reg_num2" maxlength="7" required
										onkeyup="nextRegisterNum2()" value="${fn:substringAfter(regi, '-')}"
									
								</td>
								<th style="background-color: #f1f1f1;">이메일</th>
								<c:set value="${employee.email}" var="email" />
								<td>
									<input class="input" type="text" id="email1" name="email1" maxlength="20" style="width: 100px" required
										value="${fn:substringBefore(email, '@')}"
									>
									@
									<input class="input" type="text" id="email2" name="email2" maxlength="20" style="width: 80px" required
										value="${fn:substringBefore(email, '@')}"
									>
									<select class="input" name="email3" onchange="selectEmailChk();">
										<option value="0">직접입력</option>
										<option value="naver.com">네이버</option>
										<option value="gmail.com">구글</option>
										<option value="nate.com">네이트</option>
										<option value="daum.net">다음</option>
									</select>
								</td>
							</tr>
							<tr>
								<th rowspan="3" style="background-color: #f1f1f1;">주소</th>
								<td>
									<input type="text" name="zip_code" id="zip_code" required placeholder="우편번호" value="${employee.zip_code}">
									<button type="button" class="btn  btn-primary" id="search_zip_code" name="search_zip_code"
										onclick="daumPostcode()"
									>우편번호검색</button>
								</td>
								<th style="background-color: #f1f1f1;">전화번호</th>
								<c:set value="${employee.phone}" var="phone" />
								<td>
									<input style="width: 50px;" type="text" id="phone1" name="phone1" maxlength="3"
										value="${fn:split(phone, '-')[0]}" required onkeyup="nextPhone1()"
									>
									-
									<input style="width: 50px;" type="text" id="phone2" name="phone2" maxlength="4"
										value="${fn:split(phone, '-')[1]}" required onkeyup="nextPhone2()"
									>
									-
									<input style="width: 50px;" type="text" id="phone3" name="phone3" maxlength="4"
										value="${fn:split(phone, '-')[2]}" required onkeyup="nextPhone3()"
									>
								</td>
							</tr>
							<tr>
								<td>
									<input style="width: 350px;" type="text" name="address" id="address" placeholder="주소" required
										value="${employee.address}"
									>
								</td>
								<th style="background-color: #f1f1f1;">입사일</th>
								<fmt:formatDate value="${employee.hire_date }" pattern="yyyy-MM-dd" var="hire" />
								<td>
									<input type="date" name="hire_date" id="hire_date" value="${hire}" required>
								</td>
							</tr>
							<tr>
								<td>
									<input style="width: 350px;" type="text" name="detail_address" id="detail_address" placeholder="상세주소" required
										value="${employee.detail_address}"
									>
								</td>
								<th style="background-color: #f1f1f1;">직급</th>
								<td>
									<select name="position_id" id="position_id">
										<c:forEach items="${positionCodeDTOs}" var="dto">
											<c:if test="${dto.id == employee.position_id}">
												<option value="${dto.getId()}" selected>${dto.name}</option>
											</c:if>
											<c:if test="${dto.id != employee.position_id}">
												<option value="${dto.getId()}">${dto.name}</option>
											</c:if>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: center;">
									<input type="submit" id="updateEmployeeAction" value="수정">
									<input type="reset" value="취소" onclick="window.history.back();">
								</td>
							</tr>
						</table>
					</form>
				</div>
				<!-- end white-box -->
			</div>
		</div>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<%@ include file="../js_settings/js_insertAttendance.jsp"%>
</body>
</html>