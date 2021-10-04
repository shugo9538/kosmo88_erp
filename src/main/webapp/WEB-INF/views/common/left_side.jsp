<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="left-side sticky-left-side">
<<<<<<< HEAD
  <!--logo-->
  <div class="logo">
    <a href="${ROOT_PATH}/">우여곡절 ERP</a>
  </div>
  <div class="logo-icon text-center">
    <a href="${ROOT_PATH}/">
      <img src="${RESOURCES_PATH}/assets/images/logo-icon.png" alt="" />
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
            <a href="${ROOT_PATH}/hr/attendance/">근태 관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/hr/holidayManagement">휴가 관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/hr/salaryManagement">급여관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/hr/payslip">전표 관리</a>
          </li>
        </ul>
      </li>
      <li class="menu-list" id="account">
        <a href="#">
          <i class="icon-layers"></i>
          <span>회계관리</span>
        </a>
        <ul class="sub-menu-list">
          <!--
					<li class="active">
<<<<<<< HEAD
						<a href="${ROOT_PATH}/account/configurations"> 기초정보 관리</a>
=======
						<a href="${ROOT_PATH}/hr/configurations">기초정보 환경설정</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/employee">인사카드 관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/hr/attendance/">근태 관리</a>
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
					</li>
					<li>
						<a href="${ROOT_PATH}/account/statementBook"> 전표입력/장부관리</a>
					</li>
					<li>
						<a href="${ROOT_PATH}/account/financialFunds"> 금융/자금관리</a>
					</li>
<<<<<<< HEAD
					  -->
          <!-- 아래추가사항 -->
          <li>
            <a href="${ROOT_PATH}/account/clientList?categoryNum=110">
              1. 기초정보 관리</a
            >
          </li>
          <li>
            <a href="${ROOT_PATH}/account/salesSlipList?categoryNum=130">
              2. 매입/매출장</a
            >
          </li>
          <li>
            <a href="${ROOT_PATH}/account/slipList?categoryNum=120">
              3. 일반전표</a
            >
          </li>
          <li>
            <a href="${ROOT_PATH}/account/accountList?categoryNum=140">
              4. 금융/자금관리</a
            >
          </li>
          <li>
            <a href="${ROOT_PATH}/account/financialStatement?categoryNum=150"
              >5. 결산/재무제표</a
            >
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
            <a href="${ROOT_PATH}/purchase/clientManagement">거래처 관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/purchase/estimateManagement">견적서 관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/purchase/purchaseManagement">구매 관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/purchase/#">제품 관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/purchase/purchaseSlipManagement"
              >구매전표 관리</a
            >
          </li>
        </ul>
      </li>
      <li class="menu-list" id="wms">
        <a href="#">
          <i class="icon-loop"></i>
          <span>물류관리</span>
        </a>
        <ul class="sub-menu-list">
          <li>
            <a href="${ROOT_PATH}/wms/warehouse/warehouse?id=1&tab=stock">재고 관리</a>
          </li>
          <li>
          <!-- 추후에 Id는 로그인한 회원정보에서 가져온다 -->
            <a href="${ROOT_PATH}/wms/warehouse/warehouse?id=1&tab=warehouse">창고 정보</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/wms/warehouse/warehouse?id=1&tab=section">섹션 정보</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/wms/receiving/receiving?id=1&tab=request">입고 관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/wms/shipping/shipping?id=1&tab=request">출고 관리</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/wms/warehouse/list">창고 관리(괸리자)</a>
          </li>
          <li>
            <a href="${ROOT_PATH}/wms/inbound/manageInbound">입하 지시(괸리자)</a>
          </li>
          <!-- <li>
						<a href="${ROOT_PATH}/wms/truck/">차량 관리</a>
					</li> -->
        </ul>
      </li>
    </ul>
    <!--End sidebar nav-->
  </div>
=======
					<li>
						<a href="${ROOT_PATH}/hr/payslip">전표 관리</a>
					</li>
				</ul>
			</li>
			<li class="menu-list" id="account">
				<a href="#">
					<i class="icon-layers"></i>
					<span>회계관리</span>
				</a>
=======
	<!--logo-->
	<div class="logo">
		<a href="${ROOT_PATH}/">우여곡절 ERP</a>
	</div>
	<div class="logo-icon text-center">
		<a href="${ROOT_PATH}/"> <img
			src="${RESOURCES_PATH}/assets/images/logo-icon.png" alt="">
		</a>
	</div>
	<!--logo-->
	<div class="left-side-inner">
		<!--Sidebar nav-->
		<ul class="nav nav-pills nav-stacked custom-nav">
			<li class="menu-list" id="hr"><a href="${ROOT_PATH}/"> <i
					class="icon-home"></i> <span>인사관리</span>
			</a>
				<ul class="sub-menu-list">
					<li class="active"><a href="${ROOT_PATH}/hr/configurations">기초정보
							환경설정</a></li>
					<li><a href="${ROOT_PATH}/hr/employee">인사카드 관리</a></li>
					<li><a href="${ROOT_PATH}/hr/attendance/">근태 관리</a></li>
					<li><a href="${ROOT_PATH}/hr/holiday">휴가 관리</a></li>
					<li><a href="${ROOT_PATH}/hr/salary">급여관리</a></li>
					<li><a href="${ROOT_PATH}/hr/payslip">전표 관리</a></li>
				</ul></li>
			<li class="menu-list" id="account"><a href="#"> <i
					class="icon-layers"></i> <span>회계관리</span>
			</a>
>>>>>>> 3f375313169fe8de23782103645212b360ff4f43
				<ul class="sub-menu-list">
					<!-- 아래추가사항 -->
					<li><a href="${ROOT_PATH}/account/clientList?categoryNum=110">기초정보
							관리</a></li>
					<li><a
						href="${ROOT_PATH}/account/salesSlipList?categoryNum=130">매입/매출장</a>
					</li>
					<li><a href="${ROOT_PATH}/account/slipList?categoryNum=120">일반전표</a>
					</li>
					<li><a href="${ROOT_PATH}/account/accountList?categoryNum=140">금융/자금관리</a>
					</li>
					<li><a
						href="${ROOT_PATH}/account/financialStatement?categoryNum=150">결산/재무제표</a>
					</li>
				</ul></li>
			<li class="menu-list" id="sales"><a href="#"> <i
					class="icon-grid"></i> <span>영업관리</span>
			</a>
				<ul class="sub-menu-list">
					<li><a href="${ROOT_PATH}/sales/clientManagement">거래처 관리</a></li>
					<li><a href="${ROOT_PATH}/sales/estimateManagement">견적서 관리</a>
					</li>
					<li><a href="${ROOT_PATH}/sales/orderManagement">판매 관리</a></li>
				</ul></li>
			<li class="menu-list" id="purchase"><a href="#"> <i
					class="icon-envelope-open"></i> <span>구매관리</span>
			</a>
				<ul class="sub-menu-list">
					<li><a href="${ROOT_PATH}/purchase/clientManagement">거래처
							관리</a></li>
					<li><a href="${ROOT_PATH}/purchase/estimateManagement">견적서
							관리</a></li>
					<li><a href="${ROOT_PATH}/purchase/orderManagement">구매 관리</a>
					</li>
				</ul></li>
			<li class="menu-list" id="wms"><a href="#"> <i
					class="icon-loop"></i> <span>물류 관리</span>
			</a>
				<ul class="sub-menu-list">
					<li><a href="${ROOT_PATH}/wms/warehouse/warehouse">창고 관리</a></li>
					<li><a href="${ROOT_PATH}/wms/receiving/receiving">입고 관리</a></li>
					<li><a href="${ROOT_PATH}/wms/shipping/shipping">출고 관리</a></li>
					<li><a href="${ROOT_PATH}/wms/stock/">재고 관리</a></li>
				</ul></li>
		</ul>
		<!--End sidebar nav-->
	</div>
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
</div>
