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
				<h4 class="page-title">창고 정보</h4>
				<ol class="breadcrumb">
					<li><a href="#">창고 목록</a></li>
					<li class="active">창고 정보</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<%-- 			<%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/modify">창고
						수정</a></li>
				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/delete">창고
						삭제</a></li>
			</ul>
		
			<!--Start row-->
				<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">섹션 정보</h2>
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 control-label">Text</label>
								<div class="col-md-10">
									<input class="form-control" value="Some text value..."
										type="text">
								</div>
							</div>


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
</body>
</html>