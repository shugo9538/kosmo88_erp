<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="left-side sticky-left-side">
	<!--logo-->
	<div class="logo">
		<a href="${ROOT_PATH}/">ERP 프로그램</a>
	</div>
	<div class="logo-icon text-center">
		<a href="${ROOT_PATH}/">
			<img src="${RESOURCES_PATH}/assets/images/logo-icon.png" alt="">
		</a>
	</div>
	<!--logo-->
	<div class="left-side-inner">
		<!--Sidebar nav-->
		<ul class="nav nav-pills nav-stacked custom-nav">
			<li class="menu-list" id="hr">
				<a href="${ROOT_PATH}/">
					<i class="icon-home"></i>
					<span>인사관리</span>
				</a>
				<ul class="sub-menu-list">
					<li class="active">
						<a href="${ROOT_PATH}/hr/configurations"> 기초정보 환경설정</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/hrManagement"> 인사카드 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/attendanceManagement"> 근태 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/holidayManagement"> 휴가 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/salaryManagement"> 급여관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/slipManagement"> 전표 관리</a>
					</li>
				</ul>
			</li>
			<li class="menu-list" id="account">
				<a href="#">
					<i class="icon-layers"></i>
					<span>회계관리</span>
				</a>
				<ul class="sub-menu-list">
					<li class="active">
						<a href="${ROOT_PATH}/account/configurations"> 기초정보 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/statementBook"> 전표입력/장부관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/financialFunds"> 금융/자금관리</a>
					</li>
				</ul>
			</li>
			<li class="menu-list" id="sales">
				<a href="#">
					<i class="icon-grid"></i>
					<span>영업관리</span>
				</a>
				<ul class="sub-menu-list">
					<li>
						<a href="${ROOT_PATH}/sales/clientManagement"> 거래처 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/sales/salesManagement">판매 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/sales/estimateMangement">견적서 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/sales/orderManagement">주문서 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/sales/shipmentManagement">출하 관리</a>
					</li>
				</ul>
			</li>
			<li class="menu-list" id="purchase">
				<a href="#">
					<i class="icon-envelope-open"></i>
					<span>구매관리</span>
				</a>
				<ul class="sub-menu-list">
					<li>
						<a href="${ROOT_PATH}/purchase/purchaseManagement"> 구매관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/purchase/clientManagement"> 거래처 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/purchase/orderManagement"> 발주 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/purchase/currentStatus"> 구매관리 현황</a>
					</li>
				</ul>
			</li>
			<li class="menu-list" id="logistics">
				<a href="#">
					<i class="icon-loop"></i>
					<span>물류관리</span>
				</a>
				<ul class="sub-menu-list">
					<li>
						<a href="${ROOT_PATH}/dispatching/">배차 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/truck/">차량 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/route/">경로 정보(보류)</a>
					</li>
				</ul>
			</li>
			<li class="menu-list" id="wms">
				<a href="#">
					<i class="icon-loop"></i>
					<span>WMS</span>
				</a>
				<ul class="sub-menu-list">
					<li>
						<a href="${ROOT_PATH}/warehouse/">창고 관리</a>
					</li>
<!-- 					<li> -->
<%-- 						<a href="${ROOT_PATH}/wms/stock/">재고 관리</a> --%>
<!-- 					</li> -->
					<li>
						<a href="${ROOT_PATH}/receiving/">입고 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/shipping/">출고 관리</a>
					</li>
				</ul>
			</li>
		</ul>
		<!--End sidebar nav-->
	</div>
</div>