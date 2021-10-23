<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KU ERP</title>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" />




<link
	href="${RESOURCES_PATH}/assets/plugins/datatables/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${RESOURCES_PATH}/assets/plugins/datatables/css/jquery.dataTables-custom.css"
	rel="stylesheet" type="text/css" />

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
		<%@ include file="/WEB-INF/views/wms/common/myHeader.jspf"%>
		<!--body wrapper start-->

		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">입고 현황</h4>
				<ol class="breadcrumb">
					<li>입고 관리</li>
					<li class="active">입고 현황</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->

			<ul class="nav nav-tabs">
				<li class="nav-item active"><a id="tab_request"
					class="nav-link " data-toggle="tab" href="#request">입고 요청 현황</a></li>
				<li class="nav-item"><a id="tab-history" class="nav-link"
					data-toggle="tab" href="#history">입고 내역</a></li>
			</ul>
			<!-- 				<div class="col-sm-12"> -->
			<div class="tab-content col-sm-12">
				<div class="tab-pane fade active in" id="request">




					<!-- 							<div class="col-sm-12"> -->
					<h2 class="header-title col-xs-12 mt-5">
						<i class="fa fa-chevron-circle-right mr-2"></i>입고 요청
					</h2>
					<div class="col-sm-12">
						<form class="form-horizontal" id="clientManagementForm"
							name="clientManagementForm"
							action="${ROOT_PATH}/purchase/clientRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<div class="table-responsive">
								<!-- 										<div class="col-sm-2 mt-1 mb-4"> -->
								<!-- 											<input class="btn btn-default" type="button" -->
								<!-- 												id="clientChoiceDeleteBtn" value="거래처 삭제"> -->
								<!-- 										</div> -->

								<table id="clientList" class="display table" style="width: 100%">
									<thead>
										<tr>
<!-- 											<th style="text-align: center"><input type="checkBox" -->
<!-- 												class="purchase_id" value="450"></th> -->
											<th>구매처</th>
											<th>입하일</th>
											<th>물품 수</th>
											<th>입고처리</th>
										</tr>
									</thead>
									<c:forEach var="inboundDto" items="${inboundDtoList}">
										<tbody>
											<tr>
<!-- 												<td style="text-align: center"><input type="checkBox" -->
<!-- 													class="purchase_id" value="450"></td> -->
												<td>${inboundDto.client_name}</td>
												<td>${inboundDto.approved_date}</td>
												<td>${inboundDto.count_item}</td>
												<td><a id="submit" class="button"
													onclick="warehousing(${inboundDto.request_id}, ${warehouseId})">입고처리</a></td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</form>
					</div>
				</div>






				<div class="tab-pane fade" id="history">


				
					<h2 class="header-title col-xs-12 mt-5">
						<i class="fa fa-chevron-circle-right mr-2"></i>입고 내역
					</h2>
						<div class="col-sm-12">
						<form class="form-horizontal" id="clientManagementForm"
							name="clientManagementForm"
							action="${ROOT_PATH}/purchase/clientRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<div class="table-responsive">
								<table id="clientList" class="display table" style="width: 100%">
									<thead>
										<tr>
<!-- 											<th style="text-align: center"><input type="checkBox" -->
<!-- 												class="purchase_id" value="450"></th> -->
											<th>품목</th>
											<th>수량</th>
											<th>구매처</th>
											<th>입고완료일</th>
											<th>입고창고</th>
										</tr>
									</thead>
									<c:forEach var="warehousedInboundDto" items="${warehousedInboundDtoList}">
										<tbody>
											<tr>
<!-- 												<td style="text-align: center"><input type="checkBox" -->
<!-- 													class="purchase_id" value="450"></td> -->
												<td>${warehousedInboundDto.item_name}</td>
												<td>${warehousedInboundDto.quantity}</td>
												<td>${warehousedInboundDto.client_name}</td>
												<td>${warehousedInboundDto.approved_date}</td>
												<td>${warehousedInboundDto.warehouse_name}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</form>
					</div>
				</div>





			</div>
		</div>
	<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	</div>
	<!-- End Wrapper-->

	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_datePicker.jspf"%>

	<script
		src="${RESOURCES_PATH}/assets/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${RESOURCES_PATH}/assets/pages/table-data.js"></script>

	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/inbound.js"></script>
	<!-- Page Level Script -->



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
</body>
</html>