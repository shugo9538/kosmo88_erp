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
				<h4 class="page-title">출고 목록</h4>
				<ol class="breadcrumb">
					<li><a href="#">출고 관리</a></li>
					<li class="active">출고 목록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->



			<%-- 			<%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<!-- 			<ul class="nav nav-pills custom-nav"> -->
			<%-- 				<li class="active"><a href="${ROOT_PATH}/warehouse/warehouseList">출고 --%>
			<!-- 						목록</a></li> -->
			<%-- 				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/add">출고 --%>
			<!-- 						등록</a></li> -->
			<!-- 			</ul> -->
			<div class="row">
				<div class="col-md-12 filter">
					<div class="white-box">
						<form class="form-horizontal">
							<h2 class="header-title">출고 조회 필터</h2>
							<div class="form-group">
								<label class="col-sm-1 control-label">창고 번호</label>
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

								<label class="col-sm-1 control-label">창고 이름</label>
								<div class="col-sm-5">
									<input class="form-control" value="" type="text">
								</div>

								<label class="col-sm-1 control-label">창고 종류</label>
								<div class="col-sm-5">
									<select class="form-control">
										<option>일반창고</option>
										<option>야적창고</option>
										<option>냉동창고</option>
									</select>
								</div>
							</div>


							<h2 class="header-title col-md-12 my-5">랙</h2>
							<div id="rack-group">

								<!-- 									<div id="firstRack"></div> -->
								<div id="rack">
									<div class="form-group">
										<label class="col-md-1 control-label">랙 이름</label>
										<div class="col-md-5">
											<input class="form-control" value="" type="text">
										</div>
										<label class="col-md-1 control-label">용적</label>
										<div class="col-md-3">
											<input class="form-control" value="" type="text">
										</div>
										<div role="button" class="col-md-1" onclick="delRack(this);">
											<i class="icon-minus"></i>
										</div>
									</div>
								</div>
								<!-- onload시 복제 처리했으며, 아이디 중복으로 인한 문제가 발생할 수도 있다 -->


							</div>
							<button type="submit" class="btn btn-default mt-5"
								onclick="warehouseAddAction()">조회</button>
						</form>
					</div>
				</div>
			</div>


			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<!-- 						<h2 class="header-title">Projects</h2> -->
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>품목명</th>
										<th>품목 분류</th>
										<th>수량</th>
										<th>위치</th>
										<th>출고일</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td><a href="${ROOT_PATH}/wms/warehouse/view">하리보</a></td>
										<td>제과류</td>
										<td>200</td>
										<td>본사창고</td>
										<td>2021/04/27</td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!--출고 목록End row-->




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
	</div>
</body>
</html>