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
				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/">창고
						목록</a></li>
			</ul>

			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<form class="form-horizontal">
							<h2 class="header-title">창고 정보 입력</h2>
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

							<div class="form-group">

								<label class="col-sm-1 control-label">주소</label>
								<div class="col-sm-2">
									<input class="form-control col-sm-2" type="text"
										id="sample6_postcode" placeholder="우편번호">
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-default "
										onclick="sample6_execDaumPostcode()" value="우편번호 찾기">우편번호
										찾기</button>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-1"></div>
								<div class="col-sm-5">
									<input class="form-control" type="text" id="sample6_address"
										placeholder="주소"><br>
								</div>
								<div class="col-sm-6">
									<input class="form-control" type="text"
										id="sample6_detailAddress" placeholder="상세주소">
								</div>

							</div>

							<input class="form-control" type="hidden"
								id="sample6_extraAddress" placeholder="참고항목">



							<h2 class="header-title col-md-12 my-5">랙 등록</h2>
							<div id="rack-group">

								<!-- 									<div id="firstRack"></div> -->
								<div id="rack" style="display: none;">
									<div class="form-group">
										<label class="col-md-1 control-label">랙 이름</label>
										<div class="col-md-5">
											<input class="form-control" value="" type="text">
										</div>
										<label class="col-md-1 control-label">용적</label>
										<div class="col-md-3">
											<input class="form-control" value="" type="text">



<!-- 											<div class="input-group bootstrap-touchspin"> -->
<!-- 												<span class="input-group-btn"><button -->
<!-- 														class="btn btn-primary bootstrap-touchspin-down" -->
<!-- 														type="button">-</button></span><span -->
<!-- 													class="input-group-addon bootstrap-touchspin-prefix" -->
<!-- 													style="display: none;"></span><input id="demo3" type="text" -->
<!-- 													value="" name="demo3" class="form-control" -->
<!-- 													style="display: block;"><span -->
<!-- 													class="input-group-addon bootstrap-touchspin-postfix" -->
<!-- 													style="display: none;"></span><span class="input-group-btn"><button -->
<!-- 														class="btn btn-primary bootstrap-touchspin-up" -->
<!-- 														type="button">+</button></span> -->
<!-- 											</div> -->




										</div>
										<div role="button" class="col-md-1" onclick="delRack(this);">
											<i class="icon-minus"></i>
										</div>
									</div>
								</div>
								<!-- onload시 복제 처리했으며, 아이디 중복으로 인한 문제가 발생할 수도 있다 -->


								<div role="button" class="preview col-md-12 md-5" id="addRack"
									onclick="addRack()">
									<i class="icon-plus"></i> 랙 추가
								</div>

							</div>
							<button type="submit" class="btn btn-default mt-5"
								onclick="warehouseAddAction()">등록</button>
						</form>
					</div>
				</div>
				<!--End row-->
			</div>
			<!-- End Wrapper-->
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
			<%@ include file="/WEB-INF/views/wms/common/myFooter.jsp"%>
		</div>
	</div>

	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script>
		window.onload = addRack();
	</script>
	<!-- 다음 도로명주소 -->
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/daumAddress.js"></script>
</body>
</html>

