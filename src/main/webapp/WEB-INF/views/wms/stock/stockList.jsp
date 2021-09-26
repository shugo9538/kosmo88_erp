<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/settings.jsp"%>
<body class="sticky-header onload="initDateRange()">
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
				<h4 class="page-title">재고 목록</h4>
				<ol class="breadcrumb">
					<li><a href="#">재고 관리</a></li>
					<li class="active">재고 목록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->



			<%-- 			<%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<!-- 			<ul class="nav nav-pills custom-nav"> -->
			<%-- 				<li class="active"><a href="${ROOT_PATH}/warehouse/warehouseList">재고 --%>
			<!-- 						목록</a></li> -->
			<%-- 				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/add">재고 --%>
			<!-- 						등록</a></li> -->
			<!-- 			</ul> -->
			<div class="row">
				<div class="col-md-12 filter">
					<div class="white-box">
						<form class="form-horizontal">
							<h2 class="header-title">재고 조회 필터</h2>
							<div class="form-group">
								<label class="col-sm-1 control-label">창고</label>
								<div class="col-sm-5">
									<select class="form-control">
										<option>본사창고1</option>
										<option>본사창고2</option>
										<option>야적창고1</option>
									</select>
								</div>

								<label class="col-sm-1 control-label">랙</label>
								<div class="col-sm-5">
									<select class="form-control">
										<option>일반랙</option>
										<option>야적랙</option>
										<option>냉동랙</option>
									</select>
								</div>

							</div>
							<div class="form-group">

								<label class="col-sm-1 control-label">기간</label>
								<!-- 								<div class="col-md-5"> -->
								<!-- 								<div class="input-group col-sm-10"> -->
								<div class="input-group">

									<div class="col-md-8">
										<div class="input-daterange input-group" id="date-range">
											<input type="text" class="form-control" name="start">
											<span class="input-group-addon no-border text-white">-</span>
											<input type="text" class="form-control" name="end">
										</div>
									</div>



								</div>
							</div>
							<button type="submit" class="btn btn-default mt-5"
								onclick="warehouseAddAction()">조회</button>
						</form>
					</div>
				</div>
			</div>


			<!--Start row-->
			<div class="row">
<!-- 				<div class="col-md-12"> -->
					<div class="white-box">
						<!-- 						<h2 class="header-title">Projects</h2> -->
						<div class="table-responsive">
							<h2 class="header-title">재고 목록</h2>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>품목명</th>
										<th>품목 분류</th>
										<th>수량</th>
										<th>위치</th>
										<th>입고일</th>
										<th>출고일</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>하리보</td>
										<td>제과류</td>
										<td>200</td>
										<td>본사창고</td>
										<td>2021/04/27</td>
										<td>2021/04/30</td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
<!-- 				</div> -->
			</div>
			<!--재고 목록End row-->




			<!--Start row-->
			<div class="row"></div>
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
		<%@ include file="/WEB-INF/views/wms/common/myFooter.jsp"%>

	</div>
</body>
</html>