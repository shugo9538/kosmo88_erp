<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/wms/common/css_multiSelect.jspf"%>
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
				<h4 class="page-title">입고 목록</h4>
				<ol class="breadcrumb">
					<li><a href="#">입고 관리</a></li>
					<li class="active">입고 목록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->



			<!-- 			<ul class="nav nav-pills custom-nav"> -->
			<%-- 				<li class="active"><a href="${ROOT_PATH}/warehouse/warehouseList">입고 현황</a></li> --%>
			<%-- 				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/add">입고 내역</a></li> --%>
			<!-- 			</ul> -->
			<ul class="nav nav-tabs">
				<li class="nav-item" id="firstli"><a id="firstTab"
					class="nav-link" data-toggle="tab" href="#wsInfo"
					onload="selTab(this)">입고 현황</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#rack">입고 내역</a></li>
			</ul>





			<div class="row">
				<form class="form-horizontal">
					<div class="col-md-6 filter">
						<div class="white-box">
							<h2 class="header-title">입고 조회 필터</h2>
<!-- 							<div class="form-group"> -->
<!-- 								<label class="col-md-4 control-label">기간</label> -->
<!-- 								<div class="col-md-8"> -->
<!-- 									<input class="form-control input-daterange-datepicker" -->
<!-- 										type="text" name="daterange" value="01/01/2015 - 01/31/2015"> -->
<!-- 								</div> -->
<!-- 							</div> -->
							<div class="form-group">
								<label class="control-label col-md-1">기간</label>
								<div class="col-md-8">
									<div class="input-daterange input-group" id="date-range">
										<input type="text" class="form-control" name="start">
										<span class="input-group-addon no-border text-white">to</span>
										<input type="text" class="form-control" name="end">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 filter">
						<div class="white-box">
							<h2 class="header-title">입고 조회 필터</h2>
							<!-- 							<div class="form-group"> -->
							<!-- 								<label class="col-md-1 control-label">랙</label> -->
							<!-- 								<div class="col-md-5"> -->
							<!-- 									<input class="form-control" value="" type="text"> -->
							<!-- 								</div> -->
							<!-- 							</div> -->
							<div class="form-group">
								<label class="control-label col-md-3">Default</label>

								<div class="col-md-9">
									<select multiple="multiple" class="multi-select"
										id="my_multi_select1" name="my_multi_select1[]"
										style="position: absolute; left: -9999px;">
										<option>Dallas Cowboys</option>
										<option>New York Giants</option>
										<option selected="">Philadelphia Eagles</option>
										<option selected="">Washington Redskins</option>
										<option>Chicago Bears</option>
										<option>Detroit Lions</option>
										<option>Green Bay Packers</option>
										<option>Minnesota Vikings</option>
										<option selected="">Atlanta Falcons</option>
										<option>Carolina Panthers</option>
										<option>New Orleans Saints</option>
										<option>Tampa Bay Buccaneers</option>
										<option>Arizona Cardinals</option>
										<option>St. Louis Rams</option>
										<option>San Francisco 49ers</option>
										<option>Seattle Seahawks</option>
									</select>
									<div class="ms-container" id="ms-my_multi_select1">
										<div class="ms-selectable">
											<ul class="ms-list" tabindex="-1">
												<li class="ms-elem-selectable"
													id="Dallas_Cowboys-selectable"><span>Dallas
														Cowboys</span></li>
												<li class="ms-elem-selectable"
													id="New_York_Giants-selectable"><span>New York
														Giants</span></li>
												<li selected="" class="ms-elem-selectable ms-selected"
													id="Philadelphia_Eagles-selectable" style="display: none;"><span>Philadelphia
														Eagles</span></li>
												<li selected="" class="ms-elem-selectable ms-selected"
													id="Washington_Redskins-selectable" style="display: none;"><span>Washington
														Redskins</span></li>
												<li class="ms-elem-selectable" id="Chicago_Bears-selectable"><span>Chicago
														Bears</span></li>
												<li class="ms-elem-selectable" id="Detroit_Lions-selectable"><span>Detroit
														Lions</span></li>
												<li class="ms-elem-selectable"
													id="Green_Bay_Packers-selectable"><span>Green
														Bay Packers</span></li>
												<li class="ms-elem-selectable"
													id="Minnesota_Vikings-selectable"><span>Minnesota
														Vikings</span></li>
												<li selected="" class="ms-elem-selectable ms-selected"
													id="Atlanta_Falcons-selectable" style="display: none;"><span>Atlanta
														Falcons</span></li>
												<li class="ms-elem-selectable"
													id="Carolina_Panthers-selectable"><span>Carolina
														Panthers</span></li>
												<li class="ms-elem-selectable"
													id="New_Orleans_Saints-selectable"><span>New
														Orleans Saints</span></li>
												<li class="ms-elem-selectable"
													id="Tampa_Bay_Buccaneers-selectable"><span>Tampa
														Bay Buccaneers</span></li>
												<li class="ms-elem-selectable"
													id="Arizona_Cardinals-selectable"><span>Arizona
														Cardinals</span></li>
												<li class="ms-elem-selectable" id="St_Louis_Rams-selectable"><span>St.
														Louis Rams</span></li>
												<li class="ms-elem-selectable"
													id="San_Francisco_49ers-selectable"><span>San
														Francisco 49ers</span></li>
												<li class="ms-elem-selectable"
													id="Seattle_Seahawks-selectable"><span>Seattle
														Seahawks</span></li>
											</ul>
										</div>
										<div class="ms-selection">
											<ul class="ms-list" tabindex="-1">
												<li class="ms-elem-selection" id="Dallas_Cowboys-selection"
													style="display: none;"><span>Dallas Cowboys</span></li>
												<li class="ms-elem-selection" id="New_York_Giants-selection"
													style="display: none;"><span>New York Giants</span></li>
												<li selected="" class="ms-elem-selection ms-selected"
													id="Philadelphia_Eagles-selection" style=""><span>Philadelphia
														Eagles</span></li>
												<li selected="" class="ms-elem-selection ms-selected"
													id="Washington_Redskins-selection" style=""><span>Washington
														Redskins</span></li>
												<li class="ms-elem-selection" id="Chicago_Bears-selection"
													style="display: none;"><span>Chicago Bears</span></li>
												<li class="ms-elem-selection" id="Detroit_Lions-selection"
													style="display: none;"><span>Detroit Lions</span></li>
												<li class="ms-elem-selection"
													id="Green_Bay_Packers-selection" style="display: none;"><span>Green
														Bay Packers</span></li>
												<li class="ms-elem-selection"
													id="Minnesota_Vikings-selection" style="display: none;"><span>Minnesota
														Vikings</span></li>
												<li selected="" class="ms-elem-selection ms-selected"
													id="Atlanta_Falcons-selection" style=""><span>Atlanta
														Falcons</span></li>
												<li class="ms-elem-selection"
													id="Carolina_Panthers-selection" style="display: none;"><span>Carolina
														Panthers</span></li>
												<li class="ms-elem-selection"
													id="New_Orleans_Saints-selection" style="display: none;"><span>New
														Orleans Saints</span></li>
												<li class="ms-elem-selection"
													id="Tampa_Bay_Buccaneers-selection" style="display: none;"><span>Tampa
														Bay Buccaneers</span></li>
												<li class="ms-elem-selection"
													id="Arizona_Cardinals-selection" style="display: none;"><span>Arizona
														Cardinals</span></li>
												<li class="ms-elem-selection" id="St_Louis_Rams-selection"
													style="display: none;"><span>St. Louis Rams</span></li>
												<li class="ms-elem-selection"
													id="San_Francisco_49ers-selection" style="display: none;"><span>San
														Francisco 49ers</span></li>
												<li class="ms-elem-selection"
													id="Seattle_Seahawks-selection" style="display: none;"><span>Seattle
														Seahawks</span></li>
											</ul>
										</div>
									</div>
								</div>
							</div>

							<!-- 							<button type="submit" class="btn btn-default mt-5" -->
							<!-- 								onclick="warehouseAddAction()">조회</button> -->

						</div>
					</div>
				</form>
			</div>


			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<!-- 						<h2 class="header-title">Projects</h2> -->
						<div id="receivingStatusList" class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>품목명</th>
										<th>품목 분류</th>
										<th>수량</th>
										<th>위치</th>
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
			<!--입고 목록End row-->




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
	</div>
	<!-- End Wrapper-->

	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_datePicker.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_multiSelect.jspf"%>
	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/receiving.js"></script>
	<!-- Page Level Script -->

</body>
</html>