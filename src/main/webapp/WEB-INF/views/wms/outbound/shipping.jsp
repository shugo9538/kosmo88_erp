<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kosmo88.logistics_erp.wms.dto.V_sectionDto"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Enumeration"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/wms/common/css_core.jspf"%>
<%@ include file="/WEB-INF/views/wms/common/settings.jspf"%>
</head>
<!-- <body class="sticky-header"> -->
<body class="shipping">
	<div class="main-content">
		<div class="wrapper">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="white-box">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>출고 처리
							</h2>

							<form class="form-horizontal" method="post"
								action="${ROOT_PATH}/wms/inbound/shippingAction"
								onsubmit="return shippingAction()">
								<sec:csrfInput />
								<table id="clientList" class="display table" style="width: 100%">
									<thead>
										<tr>
											<th>품목</th>
											<th>출고 수량</th>
											<th>재고 정보</th>
										</tr>
									</thead>
									<tbody>
								
										<c:forEach var="itemDto" items="${itemDtoList}">
											<input name="itemId" type="hidden" value="${itemDto.item_id}" />
											<input name="quantity" type="hidden"
												value="${itemDto.quantity}" />
											<tr>
												<td class="item">${itemDto.item_name}</td>
												<td class="quantity">${itemDto.quantity}</td>
												<td><c:set var="stockStatus" value="${false}" /> <c:set
														var="stockItem" value="" /> <c:set var="stockStatus"
														value="" /> <c:set var="tempStock" value="" /> <c:forEach
														var="stockDto" items="${stockDtoList}">
														<c:if test="${itemDto.item_name eq stockDto.item_name}">
															<c:set var="stockStatus" value="${true}" />
															<c:set var="tempStock" value="${stockDto}" />
														</c:if>
													</c:forEach> <c:choose>
														<c:when
															test="${stockStatus eq true && itemDto.quantity <= tempStock.sum_count}">
														재고 충분 (${itemDto.quantity}/${tempStock.sum_count})
														</c:when>
														<c:when
															test="${stockStatus eq true && itemDto.quantity > tempStock.sum_count}">
														재고 부족 (${itemDto.quantity}/${tempStock.sum_count})
														</c:when>
														<c:otherwise>
														재고 없음
														</c:otherwise>

													</c:choose></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="col-xs-2">
									<button type="button" class="btn btn-default mt-5"
									onclick="shippingAction(${inboundId})">출고
										처리</button>
								</div>
							</form>
							<!-- 							<div class="col-md-2 mt-1 mb-4"> -->
							<!-- 								<input class="btn btn-default" type="button" -->
							<!-- 									id="clientChoiceDeleteBtn" value="test" onclick=reloadOpener()> -->
							<!-- 							</div> -->
							<!-- 							<div class="centerBtnContainer"> -->
							<!-- 								<input type="button" class="btn-default align-self-center" -->
							<!-- 									onclick="shippingAction()" -->
							<!-- 									value="출고 처리"> -->
							<!-- 							</div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/outbound.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/warehouse.js"></script>
</body>
</html>
