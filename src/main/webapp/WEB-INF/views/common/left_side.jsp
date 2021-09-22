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
			<li class="menu-list nav-active">
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
			<li class="menu-list">
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
					
					<!-- 아래추가사항 -->
					<li>
						<a href="${ROOT_PATH}/account/clientList"> 1. 기초정보 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/salesSlipList"> 2. 매입/매출장</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/slipList"> 3. 일반전표</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/accountList"> 4. 금융/자금관리</a>
					</li>					
					<li>
						<a href="${ROOT_PATH}/account/financialStatement">5. 결산/재무제표</a>
					</li>
				</ul>
			</li>
			<li class="menu-list">
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
			<li class="menu-list">
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
			<li class="menu-list">
				<a href="#">
					<i class="icon-loop"></i>
					<span>물류관리</span>
				</a>
				<ul class="sub-menu-list">
					<li>
						<a href="${ROOT_PATH}/logistics/warehouseManagement"> 창고 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/logistics/dispatchingManagement"> 배차관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/logistics/carManagement"> 차량 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/logistics/routeInformation"> 경로 정보</a>
					</li>
				</ul>
			</li>
		</ul>
		<!--End sidebar nav-->
	</div>
</div>