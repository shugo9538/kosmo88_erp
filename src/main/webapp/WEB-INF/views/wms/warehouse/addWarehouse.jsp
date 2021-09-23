<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="/WEB-INF/views/common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="/WEB-INF/views/common/header.jsp"%>
		<!--body wrapper start-->
		<div class="wrapper">


			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">창고 등록</h4>
				<ol class="breadcrumb">
					<li><a href="#">창고 관리</a></li>
					<li class="active">창고 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<%-- 			<%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/wms/warehouseList">창고
						목록</a></li>
			</ul>
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">창고 정보 입력</h2>
<%-- 						<form class="form-horizontal" action="${ROOT_PATH}/warehouse/addAction"> --%>
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 control-label">창고 이름</label>
								<div class="col-md-4">
									<input class="form-control" value="Some text value..."
										type="text">
								</div>
								<label class="col-md-2 control-label">창고 종류</label>
								<div class="col-md-4">
									<input class="form-control" value="Some text value..."
										type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">창고 종류</label>
								<div class="col-md-4">
									<input class="form-control" value="Some text value..."
										type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">창고 종류</label>
								<div class="col-md-4">
									<input class="form-control" value="Some text value..."
										type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">창고 종류</label>
								<div class="col-md-4">
									<input class="form-control" value="Some text value..."
										type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">창고 종류</label>
								<div class="col-md-4">
									<input class="form-control" value="Some text value..."
										type="text">
								</div>
							</div>


							<div class="my-3"></div>

							<hr>

							<div class="form-group">

								<h2 class="header-title col-md-12 my-5">랙 등록</h2>
								<div id="rack-group">

									<div id="firstRack"></div>

									<div role="button" class="preview col-md-12" id="addRack"
										onclick="addRack()">
										<i class="icon-plus"></i> 랙 추가
									</div>

								</div>
							</div>
							<button type="submit" class="btn btn-default"
								onclick="warehouseAddAction()">등록</button>
						</form>
					</div>
				</div>
			</div>
			<!--End row-->
			<!--Start row-->
			<div class="row"></div>
			<!--End row-->
			<!--Start row-->
			<div class="row"></div>
			<!--End row-->
		</div>
		<!-- End Wrapper-->
		<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	</div>
	<script src="${RESOURCES_PATH}/logistics/js/logistics.js"></script>
</body>
</html>

