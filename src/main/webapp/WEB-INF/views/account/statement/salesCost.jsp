<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/accountsettings.jsp"%>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<title>회계관리 - 매입/매출장</title>
</head>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%-- <%@ include file="../common/left_side.jsp"%> --%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%-- <%@ include file="../common/header.jsp"%> --%>
		<%@ include file="../common/accountHeader.jsp" %>
		 <c:set var="now" value="<%=new java.util.Date()%>" />
 		<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy년MM월dd일" /></c:set>  
		
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
				<!-- 메뉴버튼 끝 -->
				<div class="white-box">
					<div class="title" style="text-align-last: center">
						<h2 class="header-title">매입/매출장</h2>
						<h2 class="header-title"><c:out value="${sysYear}"/>년</h2>
					</div>
					<!-- 테이블 시작  -->
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
									<td>${getCnt}건(매수${getCnt}매)</td>
									<td>
										<fmt:formatNumber pattern="###,###,###,###" value="${sum.sum_supply}" />
									</td>
									<td>
										<fmt:formatNumber pattern="###,###,###,###" value="${sum.sum_tax}" />
									</td>
									<td>
										<fmt:formatNumber pattern="###,###,###,###" value="${sum.sum_total}" />
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
		<%@ include file="../../common/footer.jsp"%>
		<%-- <%@ include file="common/accountFooter.jsp"%> --%>
		<!--End footer -->
	</div>
	<!--End main content -->
</body>
</html>
