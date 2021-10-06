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
	<div class="main-content">
		<div class="wrapper">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="white-box">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>입하 지시
							</h2>


							<table id="clientList" class="display table" style="width: 100%">
								<thead>
									<tr>
<!-- 										<th>번호</th> -->
										<th>품목</th>
										<th>수량</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="productDto" items="${productDtoList}">
										<tr>
											<td class="hidden">
<%-- 											<td>${productDto.purchase_id}</td> --%>
											<td>${productDto.item_name}</td>
											<td>${productDto.quantity}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>



							<div class="form-group">
								<label class="col-sm-2 control-label">입하 창고 선택</label>
								<div class="col-sm-10">
									<div id="inbound"></div>
									<select id="destination" class="form-control input">
										<c:forEach var="warehouseDto" items="${warehouseDtoList}">
											<option value="${warehouseDto.warehouse_id}">${warehouseDto.warehouse_name}
												(여유 섹션 ${warehouseDto.empty_section_count})</option>
										</c:forEach>
									</select>
									<div class="my-5"></div>

									<%-- 										<c:forEach var="warehouseDto" items="${warehouseDtoList}"> --%>
									<%-- 											<div>${warehouseDao.warehouse_id}${warehouseDto.warehouse_name}</div> --%>
									<%-- 										</c:forEach> --%>

									<div class="centerBtnContainer">
										<input type="button" class="btn-default align-self-center"
											onclick="dispatchAction()" value="입하 지시">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/inbound.js"></script>
</body>
</html>