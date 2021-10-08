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
								<i class="fa fa-chevron-circle-right mr-2"></i>입고 등록
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
									<c:forEach var="itemDto" items="${itemDtoList}">
										<tr>
											<td class="hidden">
												<%-- 											<td>${productDto.purchase_id}</td> --%>
											<td>${itemDto.item_name}</td>
											<td>${itemDto.quantity}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
<!-- 							<div class="col-md-2 mt-1 mb-4"> -->
<!-- 								<input class="btn btn-default" type="button" -->
<!-- 									id="clientChoiceDeleteBtn" value="test" onclick=reloadOpener()> -->
<!-- 							</div> -->


							<div class="form-group">
								<label class="col-sm-2 control-label">섹션 선택</label>
								<div class="col-sm-10">
									<div id="inbound"></div>
									<select id="destination" class="form-control input">
										<c:forEach var="sectionDto" items="${sectionDtoList}">
											<option value="${sectionDto.section_id}">${sectionDto.section_name}
												(여유 공간 ${sectionDto.capacity-sectionDto.loaded}/
												${sectionDto.capacity}</option>
										</c:forEach>
									</select>
									<div class="my-5"></div>

									<%-- 										<c:forEach var="warehouseDto" items="${warehouseDtoList}"> --%>
									<%-- 											<div>${warehouseDao.warehouse_id}${warehouseDto.warehouse_name}</div> --%>
									<%-- 										</c:forEach> --%>

									<div class="centerBtnContainer">
										<input type="button" class="btn-default align-self-center"
											onclick="approveAction()" value="입고 등록">
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
	<script src="${RESOURCES_PATH}/wms/js/warehousing.js"></script>
</body>
</html>