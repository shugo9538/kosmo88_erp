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
				<h4 class="page-title">창고 목록</h4>
				<ol class="breadcrumb">
					<li><a href="#">창고 관리</a></li>
					<li class="active">창고 목록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<%-- <%@ include file="../codeFragment/wmsMenu.jsp"%> --%>


			


			<!--Start row-->
			<div class="row">
				<div class="white-box">
					<h2 class="header-title">랙 목록</h2>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>랙 이름</th>
									<th>창고</th>
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
									<td>A-2</td>
									<td>랙창창</td>
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
			</div>





		</div>
		<!-- End Wrapper-->
		<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	</div>
</body>
</html>
>



