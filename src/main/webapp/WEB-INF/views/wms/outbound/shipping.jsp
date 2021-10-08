<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>




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
				<h4 class="page-title">출고 현황</h4>
				<ol class="breadcrumb">
					<li>출고 관리</li>
					<li class="active">출고 현황</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->

			<ul class="nav nav-tabs">
				<li class="nav-item active"><a id="tab_request"
					class="nav-link " data-toggle="tab" href="#request">출고 요청 현황</a></li>
				<li class="nav-item"><a id="tab-history" class="nav-link"
					data-toggle="tab" href="#history">출고 내역</a></li>
			</ul>
			<!-- 				<div class="col-sm-12"> -->
			<div class="tab-content col-sm-12">
				<div class="tab-pane fade active in" id="request">
				
				
				
<!-- 					<h2 class="header-title  col-xs-12"> -->
<!-- 						<i class="fa fa-chevron-circle-right mr-2"></i> 출고 요청 조회 필터 -->
<!-- 					</h2> -->
<!-- 					<div class="col-sm-12"> -->
<!-- 						<form class="form-horizontal"> -->
<!-- 							<div class="filter"> -->
<!-- 								<div class="form-group"> -->
<!-- 									<label class="control-label col-sm-1">기간</label> -->
<!-- 									<div class="col-sm-4"> -->
<!-- 										<div class="input-daterange input-group" id="date-range"> -->
<!-- 											<input type="text" class="form-control" name="start"> -->
<!-- 											<span class="input-group-addon no-border text-white">to</span> -->
<!-- 											<input type="text" class="form-control" name="end"> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
				
					
					<!-- 							<div class="col-sm-12"> -->
					<h2 class="header-title col-xs-12 mt-5">
						<i class="fa fa-chevron-circle-right mr-2"></i>출고 요청
					</h2>
					<div class="col-sm-12">
						<form class="form-horizontal" id="clientManagementForm"
							name="clientManagementForm"
							action="${ROOT_PATH}/sales/clientRegisterAction" method="post">
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
											<th style="text-align: center"><input type="checkBox"
												class="sales_id" value="450"></th>
											<th>판매처</th>
											<th>요청일</th>
											<th>출하예정일</th>
											<th>출고처리</th>
										</tr>
									</thead>
									<c:forEach var="outboundDto" items="${outboundDtoList}">
										<tbody>
											<tr>
												<td style="text-align: center"><input type="checkBox"
													class="sales_id" value="450"></td>
												<%-- 													<td>${outboundDto.id}</td> --%>
												<td>${outboundDto.client_name}</td>
												<td>${outboundDto.begin_date}</td>
												<td>${outboundDto.end_date}</td>
												<td><a id="submit" class="button"
													onclick="approve(${outboundDto.id}, ${warehouseId})">출고처리</a></td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
						</form>
					</div>
				</div>






				<div class="tab-pane fade" id="history">
				
				
<!-- 	<h2 class="header-title"> -->
<!-- 						<i class="fa fa-chevron-circle-right mr-2"></i> 출고 내역 조회 필터 -->
<!-- 					</h2> -->
<!-- 					<form class="form-horizontal"> -->
<!-- 						<div class="filter"> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label class="control-label col-sm-1">기간</label> -->
<!-- 								<div class="col-sm-4"> -->
<!-- 									<div class="input-daterange input-group" id="date-range"> -->
<!-- 										<input type="text" class="form-control" name="start"> -->
<!-- 										<span class="input-group-addon no-border text-white">to</span> -->
<!-- 										<input type="text" class="form-control" name="end"> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</form> -->
					
					
					<!-- 							<div class="col-sm-12"> -->
					<h2 class="header-title col-xs-12 mt-5">
						<i class="fa fa-chevron-circle-right mr-2"></i>출고 내역
					</h2>
					<form class="form-horizontal" id="clientManagementForm"
						name="clientManagementForm"
						action="${ROOT_PATH}/sales/clientRegisterAction" method="post">
						<!-- csrf 토큰 -->
						<sec:csrfInput />
						<div class="table-responsive">
							<div class="col-sm-2 mt-1 mb-4">
								<input class="btn btn-default" type="button"
									id="clientChoiceDeleteBtn" value="삭제">
							</div>

							<table id="clientList" class="display table" style="width: 100%">
								<thead>
									<tr>
										<th style="text-align: center"><input type="checkbox"
											id="checkAll" name="checkAll"></th>
										<th>품목</th>
										<th>수량</th>
										<th>발송</th>
										<th>창고</th>
										<th>섹션</th>
										<th>출고일</th>
									</tr>
								</thead>
							</table>
						</div>
					</form>
				</div>





			</div>
		</div>
	</div>
	<!-- End Wrapper-->

	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_datePicker.jspf"%>

	<script
		src="${RESOURCES_PATH}/assets/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${RESOURCES_PATH}/assets/pages/table-data.js"></script>

	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/outbound.js"></script>
	<!-- Page Level Script -->
	
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
</body>
</html>