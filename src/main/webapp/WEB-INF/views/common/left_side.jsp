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
						<a href="${ROOT_PATH}/hr/configurations">기초정보 환경설정</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/hrManagement">인사카드 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/attendanceManagement">근태 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/holidayManagement">휴가 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/salaryManagement">급여관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/slipManagement">전표 관리</a>
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
					
					<!-- 아래추가사항 -->
					<li>
						<a href="${ROOT_PATH}/account/clientList?categoryNum=110"> 1. 기초정보 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/salesSlipList?categoryNum=130"> 2. 매입/매출장</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/slipList?categoryNum=120"> 3. 일반전표</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/accountList?categoryNum=140"> 4. 금융/자금관리</a>
					</li>					
					<li>
						<a href="${ROOT_PATH}/account/financialStatement?categoryNum=150">5. 결산/재무제표</a>
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
						<a href="${ROOT_PATH}/sales/clientManagement">거래처 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/sales/estimateManagement">견적서 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/sales/orderManagement">판매 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/sales/#">출하 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/sales/shipmentManagement">판매전표 관리</a>
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
						<a href="${ROOT_PATH}/purchase/clientManagement"> 거래처 관리 </a>
					</li>
					<li>
						<a href="${ROOT_PATH}/purchase/estimateManagement"> 견적서 관리 </a>
					</li>
					<li>
						<a href="${ROOT_PATH}/purchase/orderManagement"> 구매 관리 </a>
					</li>
					<li>
						<a href="${ROOT_PATH}/purchase/purchaseSlipManagement"> 구매전표 관리 </a>
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
						<a href="${ROOT_PATH}/wms/warehouse/">창고 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/wms/stock/">재고 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/wms/truck/">차량 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/wms/shipping/">배차 관리</a>
					</li>
				</ul>
			</li>
		</ul>
		<!--End sidebar nav-->
	</div>
</div>