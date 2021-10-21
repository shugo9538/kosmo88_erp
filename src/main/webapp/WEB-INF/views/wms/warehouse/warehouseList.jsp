<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/wms/common/css_core.jspf"%>
<%@ include file="/WEB-INF/views/wms/common/settings.jspf"%>
</head>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="/WEB-INF/views/common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="/WEB-INF/views/wms/common/myHeader.jspf"%>
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">창고 목록</h4>
				<ol class="breadcrumb">
					<li><a href="#">창고 관리</a></li>
					<li class="active">창고 목록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->

			<div class="row">
				<div class="col-md-12">
					<ul class="nav nav-tabs">
						<li class="nav-item active"><a id="tab_list"
							class="nav-link " data-toggle="tab" href="#list">창고 목록</a></li>
						<li class="nav-item"><a id="tab_add" class="nav-link"
							data-toggle="tab" href="#add">창고 등록</a></li>
					</ul>
				</div>
			</div>
			<%-- <%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<div class="row">
				<div class="col-md-12">
					<div class="tab-content">
						<div class="tab-pane fade active in" id="list">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>창고 목록
							</h2>
							<form class="form-horizontal" id="clientManagementForm"
								name="clientManagementForm"
								action="${ROOT_PATH}/purchase/clientRegisterAction"
								method="post">
								<!-- csrf 토큰 -->
								<sec:csrfInput />
								<div class="table-responsive">

									<table id="clientList" class="display table"
										style="width: 100%">
										<thead>
											<tr>
												<th>창고명</th>
												<th>사용섹션수</th>
												<th>사용용적</th>
												<th>등록일</th>
												<th>포화도</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="warehouseDto" items="${warehouseDtoList}">
												<tr>
													<!-- 													<td>1</td> -->
													<td><a
														href="${ROOT_PATH}/wms/warehouse/manage?id=${warehouseDto.id}">
															${warehouseDto.name} </a></td>
													<td>${warehouseDto.stock_count}/${warehouseDto.section_count}</td>
													<td>${warehouseDto.count_sum}/${warehouseDto.capacity_sum}</td>
													<td>${warehouseDto.register_date}</td>
													<td>
														<div class="progress progress-striped progress-sm">
															<fmt:formatNumber var="loadRate"
																value="${warehouseDto.count_sum/warehouseDto.capacity_sum*100}"
																pattern="#.##" />

															<div class="progress-bar progress-bar-warning"
																style="width:${(warehouseDto.count_sum)/(warehouseDto.capacity_sum+0.0)*100}%;"></div>
														</div>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</form>
						</div>
						<div class="tab-pane fade" id="add">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>창고 추가
							</h2>
							<div class="row">
								<div class="col-md-12">
									<div class="white-box">
										<form class="form-horizontal" method="post"
											action="${ROOT_PATH}/wms/warehouse/addAction"
											onsubmit="return addAction()">
<!-- 											onsubmit="return warehouseAddAction()"> -->

											<sec:csrfInput />
											<h2 class="header-title">창고 정보 입력</h2>
											<!-- 											<div class="form-group"> -->
											<!-- 												<label class="col-sm-1 control-label">창고 번호</label> -->
											<!-- 												<div class="col-sm-5"> -->
											<!-- 													<input class="form-control" value="" type="text" readonly> -->
											<!-- 												</div> -->

											<!-- 												<label class="col-sm-1 control-label">등록일</label> -->
											<!-- 												<div class="col-md-5"> -->
											<!-- 													<div class="input-group"> -->
											<!-- 														<input type="text" class="form-control" -->
											<!-- 															placeholder="mm/dd/yyyy" id="datepicker-autoclose"> -->
											<!-- 														<span class="input-group-addon b-0 text-white"><i -->
											<!-- 															class="icon-calender"></i></span> -->
											<!-- 													</div> -->
											<!-- 												</div> -->
											<!-- 											</div> -->
											<div class="form-group">

												<label class="col-sm-1 control-label">창고 이름</label>
												<div class="col-sm-5">
													<input class="form-control" name="name" type="text"
														required="true">
												</div>

												<label class="col-sm-1 control-label">창고 종류</label>
												<div class="col-sm-5">
													<select class="form-control" name="kind">
														<option>일반창고</option>
														<option>야적창고</option>
														<option>냉동창고</option>
													</select>
												</div>
											</div>

											<div class="form-group">

												<label class="col-sm-1 control-label">주소</label>
												<div class="col-sm-2">
													<input class="form-control col-sm-2" type="text"
														id="sample6_postcode" name="zip" placeholder="우편번호"
														disabled>
												</div>
												<div class="col-sm-1">
													<button type="button" class="btn btn-default "
														onclick="sample6_execDaumPostcode()" value="우편번호 찾기">우편번호
														찾기</button>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-1"></div>
												<div class="col-sm-5">
													<input class="form-control" type="text"
														id="sample6_address" name="basicAddr" placeholder="주소"><br>
												</div>
												<div class="col-sm-6">
													<input class="form-control" type="text"
														id="sample6_detailAddress" name="detailAddr"
														placeholder="상세주소">
												</div>

											</div>

											<input class="form-control" type="hidden"
												id="sample6_extraAddress" placeholder="참고항목">



											<h2 class="header-title col-md-12 my-5">섹션 등록</h2>
											<div id="section-group" class="col-md-12">
												<div id="sectionForm" style="display: none;">
													<div class="form-group">
														<label class="col-md-1 control-label">구역</label>
														<div class="col-md-2">
															<input class="form-control" id="section" name="section" type="text"
																value="A" disabled>
														</div>
														<label class="col-md-1 control-label">용적</label>
														<div class="col-md-2">
															<input class="form-control" id="capacity" name="capacity" type="text"
																value="1000" disabled>
														</div>
														<div role="button" id="delAdditionalForm" class="col-md-1"
															onclick="removeNode(this);">
															<i class="icon-minus"></i>
														</div>
													</div>
												</div>
											</div>
											<div role="button" class="preview col-md-12 my-5"
												id="addSection" onclick="cloneSection()">
												<i class="icon-plus"></i>섹션 추가
											</div>
											<input type="hidden" id="additionalFormCnt"
												name="additionalFormCnt" value="1">
											<button type="submit" class="btn btn-default mt-5">등록</button>
											<button type="button" class="btn btn-default mt-5"
												onclick="setAdditionalFormNum()">테스트</button>
										</form>
									</div>
								</div>
								<!--End row-->
							</div>
						</div>
					</div>
				</div>
			</div>




		</div>
	</div>
	<!--창고 목록End row-->





	<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/warehouse.js"></script>
	<!-- 다음 도로명주소 -->
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/daumAddress.js"></script>
	<script>
		window.onload = function(){
			cloneForm();
		}
	</script>
</body>
</html>