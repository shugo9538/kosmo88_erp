<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO"%>
<%@ include file="../common/settings.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<title>우여곡절 - 재무상태표</title>
</head>

<body class="sticky-header">

	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->

	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		<%@ include file="common/accountHeader.jsp"%>
		<%@ include file="statement/incomeStatementSetting.jsp"%>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<c:set var="sysYear">
			<fmt:formatDate value="${now}" pattern="yyyy년MM월dd일" />
		</c:set>
		<!-- header section end-->

		<!--body wrapper start-->
		<div class="wrapper">

			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">재무제표</h4>
				<ol class="breadcrumb">
					<li><a href="${ROOT_PATH}/account/financialStatement?net_income=${income8}">재무상태표</a>
					</li>
					<li><a href="${ROOT_PATH}/account/incomeStatement">손익계산서</a></li>
					<!--   <li class="active">
                        Responsive Table
                    </li> -->
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->


			<!-- Start responsive Table-->
			<div class="col-md-12">
				<div class="white-box">
					<div class="title" style="text-align-last: center">
						<h1 class="header-title" style="font-size:35px">손익계산서</h1>
						<h2 class="header-title">
							제 01기(당)기
							<c:out value="${sysYear}" />
						</h2>
					</div>
					<div class="table-responsive">
						<table id="incomeStatment" class="table table table-hover m-0">
							<thead>
								<tr>
									<th>과목</th>
									<th colspan="2">제 01(당)기</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Ⅰ . 매 출 액</td>
									<td></td>
									<td class="red"><fmt:formatNumber value="${income1}"
											pattern="###,###,###,###" /></td>
								</tr>
								<tr>
									<td>상 품 매 출</td>
									<td class="red"><fmt:formatNumber value="${sales_cost}"
											pattern="###,###,###,###" />
									<td></td>
								</tr>
								<tr class="info">
									<td>Ⅱ . 매 출 원 가</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td class="red">상 품 매 출 원 가</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>기초 상품 재고액</td>
									<td class="red"><fmt:formatNumber value="${basic_product}"
											pattern="###,###,###,###" /></td>
									<td></td>
								</tr>
								<tr>
									<td>당기 상품 매 입 액</td>
									<td class="red"><fmt:formatNumber
											value="${current_product}" pattern="###,###,###,###" /></td>
									<td></td>
								</tr>
								<tr>
									<td>기말 상품 재고액</td>
									<td></td>
									<td class="red"><fmt:formatNumber value="${end_product}"
											pattern="###,###,###,###" /></td>
								</tr>
								<tr class="info">
									<td>Ⅲ . 매 출 총 이 익</td>
									<td></td>
									<td class="red"><fmt:formatNumber value="${income1}"
											pattern="###,###,###,###" /></td>
								</tr>
								<tr class="warning">
									<td>Ⅳ . 판 매 관 리 비</td>
									<td></td>
									<td class="red"><fmt:formatNumber value="${income2}"
											pattern="###,###,###,###" /></td>
								</tr>
								<c:if test="${employee_salary > 0}">
									<tr>
										<td>직 원 급 여</td>
										<td class="red"><fmt:formatNumber
												value="${employee_salary}" pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${employee_benefits >0}">
									<tr>
										<td>복 리 후 생 비</td>
										<td class="red"><fmt:formatNumber
												value="${employee_benefits}" pattern="###,###,###,###"></fmt:formatNumber>
										</td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${travel_expenses > 0}">
									<tr>
										<td>여 비 교 통 비</td>
										<td class="red"><fmt:formatNumber value="${travel_expenses}"
												pattern="###,###,###,###"></fmt:formatNumber></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${entertainment > 0}">
									<tr>
										<td>접 대 비</td>
										<td class="red"><fmt:formatNumber value="${entertainment}"
												pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${communication_cost > 0}">
									<tr>
										<td>통 신 비</td>
										<td class="red"><fmt:formatNumber value="${communication_cost}"
												pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${water_utility_bill > 0 }">
									<tr>
										<td>수 도 광 열 비</td>
										<td class="red"><fmt:formatNumber value="${water_utility_bill}"
												pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${taxes_and_duties > 0}">
									<tr>
										<td>세 금 과 공 과 금</td>
										<td class="red"><fmt:formatNumber value="${taxes_and_duties}"
												pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${paid_rent > 0}">
									<tr>
										<td>지 급 임 차 료</td>
										<td class="red"><fmt:formatNumber value="${paid_rent}"
												pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${premium >0}">
									<tr>
										<td>보 험 료</td>
										<td class="red"><fmt:formatNumber
												value="${premium}"
												pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${vehicle_maintenance_cost > 0}">
									<tr>
										<td>차 량 유 지 비</td>
										<td class="red"><fmt:formatNumber
												value="${vehicle_maintenance_cost}"
												pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<c:if test="${office_supplies > 0}">
									<tr>
										<td>사 무 용 품 비</td>
										<td class="red"><fmt:formatNumber
												value="${office_supplies}" pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>

								<c:if test="${consumables_cost > 0}">
									<tr>
										<td>소 모 품 비</td>
										<td class="red"><fmt:formatNumber
												value="${consumables_cost}" pattern="###,###,###,###" /></td>
										<td></td>
									</tr>
								</c:if>
								<tr class="warning">
									<td>Ⅴ . 영 업 이 익</td>
									<td></td>
									<td class="red">
									<c:if test="${income3 == 0}">
									</c:if>
									<c:if test="${income3 > 0 || income3 < 0}">
											<fmt:formatNumber value="${income3}" pattern="###,###" />
									</c:if>	
									</td>
								</tr>
								<tr>
									<td>Ⅵ . 영 업 외 수 익</td>
									<td></td>
									<td class="red"><c:if test="${income4 == 0}">
										</c:if> <c:if test="${income4 > 0}">
											<fmt:formatNumber value="${income4}"
												pattern="###,###,###,###" />
										</c:if></td>
								</tr>
								<tr>
									<td>이 자 수 익</td>
									<td class="red"><c:if test="${interest_income == 0}">
										</c:if> <c:if test="${interest_income > 0}">
											<fmt:formatNumber value="${interest_income}"
												pattern="###,###" />
										</c:if></td>
									<td></td>
								</tr>
								<tr>
									<td>Ⅶ . 영 업 외 비 용</td>
									<td></td>
									<td class="red"><c:if test="${income5 == 0}">
										</c:if> <c:if test="${income5 > 0}">
											<fmt:formatNumber value="${income5}"
												pattern="###,###,###,###" />
										</c:if></td>
								</tr>
								<tr>
									<td>이 자 비 용</td>
									<td class="red"><c:if test="${interest_expense == 0}">
										</c:if> <c:if test="${interest_expense > 0}">
											<fmt:formatNumber value="${interest_expense}"
												pattern="###,###,###,###" />
										</c:if></td>
									<td></td>
								</tr>
								<tr>
									<td>Ⅷ . 법인세비용차감전순이익</td>
									<td></td>
									<td class="red"><c:if test="${income6 > 0}">
											<fmt:formatNumber value="${income6}"
												pattern="###,###,###,###" />
										</c:if></td>
								</tr>
								<tr class="danger">
									<td>Ⅸ . 법 인 세 비 용</td>
									<td></td>
									<td class="red">
										<!-- 법인세 비용 있는경우  --> <c:if test="${income7 == 0}">
										</c:if> <!-- 법인세 비용 없는 경우  --> <c:if test="${income7 > 0}">
											<fmt:formatNumber value="${income7}"
												pattern="###,###,###,###" />
										</c:if>
									</td>
								</tr>
								<tr class="info">
									<td>Ⅹ . 당 기 순 이 익</td>
									<td></td>
									<td class="red">
									<input type="hidden" id="income8" name="income8" value="${income8}">
									<fmt:formatNumber value="${income8}"
											pattern="###,###,###,###" /></td>
								</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- End responsive Table-->
			
		</div>
		<!-- End Wrapper-->

		<!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>
		<%@ include file="common/accountFooter.jsp"%>
		<!--End footer -->
	</div>
	<!--End main content -->
</body>
</html>
