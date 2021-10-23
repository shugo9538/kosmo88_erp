<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KU ERP</title>
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
				<h4 class="page-title">제목</h4>
				<ol class="breadcrumb">
					<li><a href="#">소메뉴</a></li>
					<li class="active">대메뉴</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<!--Start row-->
			<div class="row">
			<button role=button style="border: 1px solid; background: yellow"
					onclick="success('그랭', '알똬', addAction())">b</button>
				<button role=button style="border: 1px solid; background: yellow"
					onclick="success('그랭', '알똬', function(){location.reload()})">b</button>
				<button role=button style="border: 1px solid; background: yellow"
					onclick="swal('성공', '', '', 3000)">b</button>
				<button role=button style="border: 1px solid; background: yellow"
					onclick="swal('성공', '', 'success',  1500)">b</button>
				<button role=button style="border: 1px solid; background: yellow"
					onclick="swal('입력확인하슈', '잘못 입력했다 짜샤~', 'error', 1500);">b</button>

			</div>
			<!--End row-->
		</div>
		<!-- End Wrapper-->
		<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	</div>

	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_datePicker.jspf"%>
	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	
	<script src="${RESOURCES_PATH}/wms/js/warehouse.js"></script>
</body>
</html>