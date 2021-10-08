<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/wms/common/css_multiSelect.jspf"%>
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
		<%@ include file="/WEB-INF/views/common/header.jsp"%>
		<!--body wrapper start-->
		<div class="wrapper">

			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">창고 정보</h4>
				<ol class="breadcrumb">
					<li><a href="${ROOT_PATH}/wms/warehouse/">창고 목록</a></li>
					<li class="active">창고 정보</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->

			<ul class="nav nav-tabs">

				<li class="nav-item active"><a id="tab_warehouse"
					class="nav-link" data-toggle="tab" href="#warehouse">창고 정보</a></li>
				<li class="nav-item"><a id="tab_section" class="nav-link"
					data-toggle="tab" href="#section">섹션</a></li>
				<li class="nav-item"><a id="tab_stock" class="nav-link"
					data-toggle="tab" href="#stock">재고 정보</a></li>
			</ul>

			<!-- 페이지 특정 부분만 가져오려면.. 
							1. include한 후에 태그 숨기기
							2. 애초에 페이지 띄우기 전에 파라미터 보내서 if체크하기
							3. ajax! -->

			<!--Start row-->
			<!-- 				<div class="row tab-content"> -->
			<div class="white-box">
				<div class="tab-content">
					<!-- show 제거 -->


					<!-- End Wrapper-->
					<div class="tab-pane fade active in" id="warehouse">
						<h2 class="header-title">창고 정보</h2>
						<div class="form-group">
							<label class="col-sm-2 control-label">창고명</label>
							<div class="col-sm-2">
								<input class="form-control" value="${warehouseDto.name}"
									type="text" readonly>
							</div>
							<label class="col-sm-2 control-label">등록일</label>
							<div class="col-sm-2">
								<input type="text" class="form-control"
									value="${warehouseDto.register_date}" readonly>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">주소</label>
							<div class="col-sm-5">
								<input class="form-control" type="text"
									value="${warehouseDto.address}" readonly>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">총섹션</label>
							<div class="col-sm-2">
								<input type="text" class="form-control"
									value="${warehouseDto.section_count}" readonly>
							</div>
							<label class="col-sm-2 control-label">가용섹션</label>
							<div class="col-sm-2">
								<input type="text" class="form-control"
									value="${warehouseDto.section_count
										-warehouseDto.used_section_count}"
									readonly>
							</div>
						</div>
						<div class="form-group">
							<div class="form-group"></div>
							<label class="col-sm-2 control-label">총용적</label>
							<div class="col-sm-2">
								<input type="text" class="form-control"
									value="${warehouseDto.capacity_sum}" readonly>
							</div>
							<label class="col-sm-2 control-label">가용용적</label>
							<div class="col-sm-2">
								<input type="text" class="form-control"
									value="${warehouseDto.capacity_sum
										-warehouseDto.loaded_sum}"
									readonly>
							</div>

						</div>

					</div>




					<div class="tab-pane fade" id="section">
						<h2 class="header-title">섹션 목록</h2>
						<div class="form-group">
							<div class="table-responsive">
								<table id="sectionList" class="display table">
									<thead>
										<tr>
											<!-- <td style="text-align: center"><input type="checkbox" -->
											<!-- 												id="checkAll" name="checkAll"></td> -->
											<th>섹션</th>
											<th>창고</th>
											<th>용적</th>
											<!-- 											<th>물품</th> -->
											<!-- 											<th>총 수량</th> -->
											<th>상태</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="sectionDto"
											items="${sectionDtoList}" varStatus="varStatus">
											<tr>
												<td>${sectionDto.section}</td>
												<td>${sectionDto.warehouse_name}</td>
												<td>(${sectionDto.capacity})</td>
												<td><c:choose>
														<c:when test="${section_loaded>0}">
															사용 가능	
														</c:when>
														<c:otherwise>
															사용중
														</c:otherwise>
													</c:choose></td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>



					<div class="tab-pane fade" id="stock">
						<h2 class="header-title mt-5">재고 목록</h2>
						<div class="table-responsive">
							<table id="sectionList" class="display table">
								<thead>
									<tr>
										<!-- 										<td style="text-align: center"><input type="checkbox" -->
										<!-- 											id="checkAll" name="checkAll"></td> -->
										<th>물품</th>
										<th>수량</th>
										<th>창고</th>
										<th>섹션</th>
										<th>입고일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="stock_detailDto" items="${stock_detailDtoList}"
										varStatus="varStatus">
										<tr>
											<%-- 											<td>${varStatus.index}</td> --%>
											<td>${stockDto.item_name}</td>
											<td>${stockDto.count}</td>
											<td>${stockDto.warehouse_name}</td>
											<td>${stockDto.section_name}</td>
											<%-- 													(${stockDto.loaded+(0.0)}/${sectionDto.capacity}) --%>
											<td>${stockDto.register_date}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>



				</div>
			</div>
		</div>


	</div>

	<!-- End Wrapper-->
	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>



	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/warehouse.js"></script>
	<!-- 일단 돌려막기로 자바스크립트로 active 처리... -->
	<script>
		// 			  				window.onload = selTab(); 
		// 		var tempFunc = function() {
		// 			selTab();
		// 			initDatePicker();
		// 			adjustIncludedPage();
		// 		}
		// 		window.onload = tempFunc;
	</script>
</body>
</html>