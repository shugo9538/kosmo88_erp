<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<title>회계관리 - 일반전표</title>
</head>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		<%-- <%@ include file="common/accountHeader.jsp" %>   --%>
		<!-- header section end-->
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h2 class="page-title">매입/매출장 목록</h2>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<!-- Start responsive Table-->
			<div class="col-md-12">
				<!-- 메뉴버튼 -->
				<div>
					<ul class="nav nav-pills custom-nav">
						<li class="active">
							<a href="${ROOT_PATH}/account/purchaseList?categoryNum=131">매입목록</a>
						</li>
						<li class="active">
							<a href="${ROOT_PATH}/account/salesList?categoryNum=132">매출목록</a>
						</li>
					</ul>
				</div>
				<!-- 메뉴버튼 끝 -->
				<div class="white-box">
					<div class="title" style="text-align-last: center">
						<h2 class="header-title">매입/매출장</h2>
						<h2 class="header-title">2021년</h2>
					</div>
					<!--Start row-->
					<div class="row">
						<div class="col-md-12">
							<form action="#" class="form-horizontal">
								<div class="form-group">
									<label class="control-label col-md-4">검색 일자</label>
									<div class="input-daterange input-group" id="date-range">
										<div class="col-md-3">
											<input type="text" class="form-control" name="start" id="statd_date" readonly />
										</div>
										<div class="col-md-1">
											<input type="text" class="form-control" readonly value="~">
										</div>
										<div class="col-md-3">
											<input type="text" class="form-control" name="end" id="end_date" readonly />
										</div>
										<div class=" col-md-3">
											<select class="form-control" id="salesPurchase">
												<option value="0" selected>선택</option>
												<option value="1">매출</option>
												<option value="2">매입</option>
											</select>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!--End row-->
					<div class="table-responsive">
						<c:set var="sum_supply" value="0" />
						<c:set var="sum_tax" value="0" />
						<c:set var="sum_total" value="0" />
						<table id="example" class="table table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th>전표일자</th>
									<th>전표번호</th>
									<th>계정과목</th>
									<th>거래처코드</th>
									<th>거래처</th>
									<th>사업자번호</th>
									<th>품명</th>
									<th>공급가액</th>
									<th>세액</th>
									<th>합계</th>
									<th>유형</th>
									<th>요약</th>
									<th>일반전표ID</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="dto" items="${saleslip}">
									<tr>
										<td>
											<!-- 전표일자(slip 테이블 승인일자 동일)  -->
											<fmt:formatDate pattern="yyyy-MM-dd" value="${dto.confirm_date}" />
										</td>
										<!-- 전표번호  -->
										<td>${dto.id}</td>
										<!-- 계정과목  -->
										<td>${dto.account_title}</td>
										<!-- 거래처코드 -->
										<td>${dto.client_code}</td>
										<!-- 거래처이름 -->
										<td>${dto.client_name}</td>
										<!-- 사업자번호 -->
										<td>${dto.client_num}</td>
										<!-- 상품이름 or 재화 or 서비스 제공 -->
										<td>${dto.product_name}</td>
										<!-- row 공급가액 -->
										<td>
											<fmt:formatNumber pattern="###,###,###,###" value="${dto.supply_amount}" />
										</td>
										<!-- row 세액 -->
										<td>
											<fmt:formatNumber pattern="###,###,###,###" value="${dto.tax_amount}" />
										</td>
										<!-- row 합계 -->
										<td>
											<fmt:formatNumber pattern="###,###,###,###" value="${dto.supply_amount + dto.tax_amount}" />
										</td>
										<td>${dto.type}</td>
										<td>${dto.abs}</td>
										<td>${dto.slip_id}</td>
										<!-- 공급가액 합계  -->
										<c:set var="sum_supply" value="${sum_supply + dto.supply_amount}" />
										<!-- 세액 합계  -->
										<c:set var="sum_tax" value="${sum_tax + dto.tax_amount}" />
										<!-- 공금가액 + 세액 합계  -->
										<c:set var="sum_total" value="${sum_total + dto.supply_amount + dto.tax_amount}" />
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr style="background-color: ghostwhite; font-weight: bold;">
									<td colspan="5" align="center">합계</td>
									<td>0건(매수0매)</td>
									<td>
										<fmt:formatNumber pattern="###,###,###,###" value="${sum_supply}" />
									</td>
									<td>
										<fmt:formatNumber pattern="###,###,###,###" value="${sum_tax}" />
									</td>
									<td>
										<fmt:formatNumber pattern="###,###,###,###" value="${sum_total}" />
									</td>
									<td colspan="4"></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!--End row-->
		<!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>
		<%-- <%@ include file="common/accountFooter.jsp"%> --%>
		<!--End footer -->
	</div>
	<!--End main content -->
</body>
</html>
