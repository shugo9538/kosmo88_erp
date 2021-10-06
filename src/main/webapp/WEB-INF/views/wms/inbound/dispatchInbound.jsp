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
						<h2 class="header-title">
							<i class="fa fa-chevron-circle-right mr-2"></i>입하 지시
						</h2>
						<div class="form-group">
							<label class="col-sm-2 control-label">Input Select</label>
							<div class="col-sm-10">
								<select class="form-control">
									<c:forEach var="warehouseDto" items="${warehouseDtoList}">
										<option></option>
									</c:forEach>
								</select>
							</div>
						</div>

					</div>
					<div class="white-box"></div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
</body>
</html>