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
				<h4 class="page-title">차량 목록</h4>
				<ol class="breadcrumb">
					<li><a href="#">차량 관리</a></li>
					<li class="active">차량 목록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			
			

			<ul class="nav nav-pills custom-nav">
<%-- 				<li class="active"><a href="${ROOT_PATH}/truck/list">차량 --%>
<!-- 						목록</a></li> -->
				<li class="active"><a href="${ROOT_PATH}/wms/truck/add">차량
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
										<th>차량번호</th>
										<th>분류(적재)</th>
										<th>최종위치</th>
										<th>상태</th>
										<th>등록일</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td><a href="${ROOT_PATH}/wms/truck/view">5223</a></td>
										<td>5톤땀프</td>
										<td>본사창고</td>
										<td>운행중</td>
										<td>2021/04/27</td>
									</tr>
								
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!--재고 목록End row-->
			
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