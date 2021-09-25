<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/settings.jsp"%>
<%@ include file="/WEB-INF/views/wms/common/myHeader.jsp"%>
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
				<h4 class="page-title">랙 정보</h4>
				<ol class="breadcrumb">
					<li><a href="#">랙 목록</a></li>
					<li class="active">랙 정보</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<%-- 			<%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/modify">랙
						수정</a></li>
				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/delete">랙
						삭제</a></li>
			</ul>
			<ul class="nav nav-tabs">
				<li class="nav-item" id="firstli"><a id="firstTab"
					class="nav-link" data-toggle="tab" href="#wsInfo"
					onload="selTab(this)">랙 정보</a></li>
				<!-- 				<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#wsInfo">랙 정보</a></li> -->
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#rack">재고 정보</a></li>
				<!-- 				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#rack">랙</a></li> -->
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#inout">입출고</a></li>
				<!-- 				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#inout">입출고</a></li> -->
			</ul>
			<!--Start row-->
			<div class="white-box">
				<!-- 				<div class="row tab-content"> -->
				<div class="tab-content">
					<!-- 					<div class="tab-pane fade show active" id="wsInfo"> -->
					<div class="tab-pane fade" id="wsInfo" onload="selTab(this)">

						<!-- 					<div class="col-md-12"> -->
						<h2 class="header-title">랙 정보</h2>
						<div class="form-group">
							<label class="col-sm-1 control-label">랙 번호</label>
							<div class="col-sm-5">
								<input class="form-control" value="" type="text" readonly>
							</div>

							<label class="col-sm-1 control-label">등록일</label>
							<div class="col-md-5">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="mm/dd/yyyy" id="datepicker-autoclose"> <span
										class="input-group-addon b-0 text-white"><i
										class="icon-calender"></i></span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label">랙 이름</label>
							<div class="col-sm-5">
								<input class="form-control" value="" type="text">
							</div>

							<label class="col-sm-1 control-label">랙 종류</label>
							<div class="col-sm-5">
								<select class="form-control">
									<option>일반랙</option>
									<option>야적랙</option>
									<option>냉동랙</option>
								</select>
							</div>
						</div>
						
					</div>
					<div class="tab-pane fade" id="rack">
						<!-- 					<div class="col-md-12"> -->
						<h2 class="header-title">재고 정보</h2>
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>랙 이름</th>
										<th>랙창창</th>
										<th>창창랙</th>
										<th>랙 상태</th>
										<th>포화도</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td><a href="${ROOT_PATH}/wms/warehouse/view">본사 랙</a></td>
										<td>랙창창</td>
										<td>고창랙</td>
										<td><span class="label label-warning">랙중</span></td>
										<td>
											<div class="progress progress-striped progress-sm">
												<div class="progress-bar progress-bar-warning"
													style="width: 25%;"></div>
											</div>
										</td>
									</tr>
									<tr>
										<td>2</td>
										<td>유라 랙</td>
										<td>랙창창</td>
										<td>고창랙</td>
										<td><span class="label label-warning">랙중</span></td>
										<td>
											<div class="progress progress-striped progress-sm">
												<div class="progress-bar progress-bar-warning"
													style="width: 90%;"></div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<%-- 					<jsp:include page="/WEB-INF/views/wms/rack/rackList.jsp"> --%>
					<%-- 						<jsp:param value="2" name="warehouseNum" /> --%>
					<%-- 					</jsp:include> --%>

					<div class="tab-pane fade" id="inout">
						<h2 class="header-title">금일 입•출고</h2>
					</div>
				</div>
			</div>



			<!-- End Wrapper-->
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
			<%@ include file="/WEB-INF/views/wms/common/myFooter.jsp"%>

			<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
			<!-- 일단 돌려막기로 자바스크립트로 active 처리... -->
			<script>
				window.onload = selTab();
			</script>
</body>
</html>