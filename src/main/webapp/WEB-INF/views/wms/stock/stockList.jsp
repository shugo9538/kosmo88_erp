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
				<h4 class="page-title">재고 목록</h4>
				<ol class="breadcrumb">
					<li><a href="#">재고 관리</a></li>
					<li class="active">재고 목록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->



			<%-- 			<%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<ul class="nav nav-pills custom-nav">
<%-- 				<li class="active"><a href="${ROOT_PATH}/warehouse/warehouseList">재고 --%>
<!-- 						목록</a></li> -->
				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/add">재고
						등록</a></li>
			</ul>


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
										<th>창고</th>
										<th>입고일</th>
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
	</div>
</body>
</html>