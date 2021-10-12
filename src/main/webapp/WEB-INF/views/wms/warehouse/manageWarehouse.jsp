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
<!-- <body class="sticky-header"> -->
<body>

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
				<!-- 				<li class="nav-item active"><a id="tab_stock" class="nav-link" -->
				<!-- 					data-toggle="tab" href="#stock">재고 정보</a></li> -->
				<li class="nav-item active"><a id="tab_warehouse"
					class="nav-link" data-toggle="tab" href="#warehouse">창고 정보</a></li>
				<li class="nav-item"><a id="tab_section" class="nav-link"
					data-toggle="tab" href="#section">섹션정보</a></li>
				<li class="nav-item"><a id="tab_section" class="nav-link"
					data-toggle="tab" href="#addSection">섹션추가</a></li>
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
					<!-- 					<div class="tab-pane fade active in" id="stock"> -->
					<!-- 						<h2 class="header-title mt-5">재고 목록</h2> -->
					<!-- 						<div class="table-responsive"> -->
					<!-- 							<table id="sectionList" class="display table"> -->
					<!-- 								<thead> -->
					<!-- 									<tr> -->
					<!-- 										<td style="text-align: center"><input type="checkbox" -->
					<!-- 											id="checkAll" name="checkAll"></td> -->
					<!-- 										<th>물품</th> -->
					<!-- 										<th>수량</th> -->
					<!-- 										<th>창고</th> -->
					<!-- 										<th>섹션</th> -->
					<!-- 									</tr> -->
					<!-- 								</thead> -->
					<!-- 								<tbody> -->
					<%-- 									<c:forEach var="stock_sectionDto" --%>
					<%-- 										items="${stock_sectionDtoList}" varStatus="varStatus"> --%>
					<!-- 										<tr> -->
					<%-- 											<td>${varStatus.index}</td> --%>
					<%-- 											<td>${stock_sectionDto.item_name}</td> --%>
					<%-- 											<td>${stock_sectionDto.count}</td> --%>
					<%-- 											<td>${stock_sectionDto.warehouse_name}</td> --%>
					<%-- 											<td>${stock_sectionDto.section_name}(${stock_sectionDto.loaded}/${stock_sectionDto.capacity}) --%>
					<!-- 										</tr> -->
					<%-- 									</c:forEach> --%>
					<!-- 								</tbody> -->
					<!-- 							</table> -->
					<!-- 						</div> -->
					<!-- 					</div> -->

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
							<label class="col-sm-2 control-label">사용섹션</label>
							<div class="col-sm-2">
								<input type="text" class="form-control"
									value="${warehouseDto.stock_count}"
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
							<label class="col-sm-2 control-label">사용용적</label>
							<div class="col-sm-2">
								<input type="text" class="form-control"
									value="${warehouseDto.count_sum}"
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
										<c:forEach var="sectionDto" items="${sectionDtoList}"
											varStatus="varStatus">
											<tr>
												<td>${sectionDto.section }</td>
<!-- 												<td><a id="submit" class="button" -->
<%-- 													onclick="addRack(${purchaseDto.purchase_id})">${sectionDto.section}</a> --%>
<%-- 																									<a href="${ROOT_PATH}/wms/warehouse/addSection">${sectionDto.section}</a></td> --%>
												<td>${sectionDto.warehouse_name}</td>
												<td>(${sectionDto.count}/${sectionDto.capacity})</td>
												<td><c:choose>
														<c:when test="${sectionDto.count>0}">
															사용중	
														</c:when>
														<c:otherwise>
															사용 가능
														</c:otherwise>
													</c:choose></td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>


					<div class="tab-pane fade" id="addSection">
						<h2 class="header-title">섹션 추가</h2>
						<div class="form-group">
							<form class="form-horizontal" method="post"
								action="${ROOT_PATH}/wms/warehouse/addSectionAction"
								onsubmit="return addAction()">
								<!-- 								onsubmit="return addWarehouseAction()"> -->

								<sec:csrfInput />

								<input type="hidden" name="warehouseId" value="${warehouseId}">
								<div id="section-group" class="col-md-12">
									<div id="sectionForm" style="display: none;">
										<div class="form-group">
											<label class="col-md-1 control-label">구역</label>
											<div class="col-md-2">
												<input class="form-control" id="section" name="section"
													type="text" value="${lastSection}" disabled>
											</div>
											<label class="col-md-1 control-label">용적</label>
											<div class="col-md-2">
												<input class="form-control" id="capacity" name="capacity"
													type="text" value="1000" disabled>
											</div>
											<div role="button" id="delAdditionalForm" class="col-md-1"
												onclick="removeSection(this);">
												<i class="icon-minus"></i>
											</div>
										</div>
									</div>
								</div>
								<div role="button" class="preview col-xs-12 my-5" id="addSection">
									<span onclick="cloneSection()"><i class="icon-plus"></i>섹션 추가</span>
								</div>
								<input type="hidden" id="additionalFormCnt"
									name="additionalFormCnt" value="1">
								<div class="col-xs-2">
									<button type="submit" class="btn btn-default mt-5">등록</button>
								</div>
								<!-- 								<button type="button" class="btn btn-default mt-5" -->
								<!-- 									onclick="getNewSection('A')">테스트</button> -->
							</form>
						</div>
					</div>



				</div>
			</div>
		</div>


	</div>

	<!-- End Wrapper-->
	<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/warehouse.js"></script>


	<script>
		window.onload = function(){
			cloneSection();
				
			}
	</script>

	<!-- 일단 돌려막기로 자바스크립트로 active 처리... -->

</body>
</html>