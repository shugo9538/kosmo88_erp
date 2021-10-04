<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
            <div class="page-title-box">
                <h4 class="page-title">주문 관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">전체 목록</a>
                    </li>
                    <li class="active">
                      	  주문 관리
                    </li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->

            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	주문 등록</h2>
                        <div class="form-group">
                        </div>
                        <form class="form-horizontal" name="orderForm" action="${ROOT_PATH}/sales/orderRegisterAction" method="post">
                            <table id="estimate" class="display table mt-12" style="width:100%">
								<tr>
									<th style="background-color: #f1f1f1;">견적서 번호</th>
                            		<td colspan="3">
										<input type="text" name="ceo_name" id="ceo_name" required >
                            			<input type="button" class="btn  btn-primary" id="selectEstimate" name="selectEstimate" value="견적서 선택">
                            		</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">주문일자</th>
									<td>
										<input type="date" name="phone" id="phone" required placeholder="주문 일자">
									
									</td>
									<th style="background-color: #f1f1f1;">요청일자</th>
									<td>
										<input type="date" name="phone" id="phone" required placeholder="주문 일자">
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처명</th>
									<td>
										<input class="input" type="text" id="email" name="email" required placeholder="거래처명">
									</td>
									<th style="background-color: #f1f1f1;">대표자명</th>
									<td>
										<input class="input" type="text" id="email" name="email" required placeholder="대표자명">
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처 연락처</th>
									<td>
										<input class="input" type="text" id="email" name="email" required placeholder="거래처 연락처">
									</td>
									<th style="background-color: #f1f1f1;">거래처 이메일</th>
									<td>
										<input class="input" type="text" id="email" name="email" required placeholder="거래처 이메일">
									</td>
								</tr>
								<tr>
									<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
									<td colspan="3">
										<input type="text" name="zip_code"
										id="zip_code" required placeholder="우편번호">
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px;" type="text"
										name="address" id="address" placeholder="주소" required>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px;" type="text"
										name="detail_address" id="detail_address" placeholder="상세주소" required>
									</td>
								</tr>
								
								<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td>
                            			<input type="text" name="employee_name" id="employee_name" placeholder="담당자">
	                             	</td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td>
                            			<input type="text" name="employee_dp" id="employee_dp" placeholder="담당자 부서">
                            		</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td>
                            			<input type="text" name="employee_phone" id="employee_phone" placeholder="담당자 연락처">
                            		</td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td>
                            			<input type="text" name="employee_email" id="employee_email" placeholder="담당자 이메일">
                            		</td>
                            	</tr>
							</table>
							<table id="insertItemTable" class="table table-hover" style="width:100%">
								<tr>
									<th style="background-color: #f1f1f1;">상품명</th>
									<th style="background-color: #f1f1f1;">상품종류</th>
									<th style="background-color: #f1f1f1;">판매단가</th>
									<th style="background-color: #f1f1f1;">수량</th>
									<th style="background-color: #f1f1f1;">공급가액</th>
								</tr>
								<tr>
									<td>냉장고</td>
									<td>가전제품</td>
									<td>1,200,000원</td>
									<td>10</td>
									<td>12,000,000원</td>
								</tr>
								<tr>
									<td>냉장고</td>
									<td>가전제품</td>
									<td>1,200,000원</td>
									<td>10</td>
									<td>12,000,000원</td>
								</tr>
							</table>
                            
                            <div class="form-group mt-12">
                                <div class="col-md-5 col-md-offset-5">
                                	<input class="btn  btn-primary" type="submit" value="등록">
                                    <input class="btn  btn-default" type="reset" value="취소">
                                    
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end row -->
            
            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	주문 전체 목록</h2>
                        <div class="table-responsive">
                        <div class="form-group">
                        </div>
                        <div class="col-md-1 col-md-offset-0">
                            </div>
                            <table id="example" class="display table">
                                <thead>
                                    <tr>
                                        <td style="text-align: center;">
                                            <input type="checkbox" name="checkAll" id="checkAll">
                                        </td>
                                        <th>주문번호</th>
                                        <th>주문일자</th>
                                        <th>납기요청일자</th>
                                        <th>거래처명</th>
                                        <th>대표자</th>
                                        <th>대표자연락처</th>
                                        <th>담당자</th>
                                        <th>주문상태</th>
                                        <th>출고상태</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="order_id" id="order_id">
                                        </th>
                                        <th><a href="#">21424582</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>삼익전자</td>
                                        <td>김기철</td>
                                        <td>032-333-4423</td>
                                        <td>김철수</td>
                                        <td>
                                        	<input class="btn  btn-primary" type="button" value="주문요청">
                                        </td>
                                        <td>
                                        	<input class="btn  btn-defalt" type="button" value="출고준비">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="order_id" id="order_id">
                                        </th>
                                        <th><a href="#">21424582</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>삼익전자</td>
                                        <td>김기철</td>
                                        <td>032-333-4423</td>
                                        <td>김철수</td>
                                        <td>
                                        	<input class="btn  btn-defalt" type="button" value="승인대기">
                                        </td>
                                        <td>
                                        	<input class="btn  btn-defalt" type="button" value="출고준비">
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="order_id" id="order_id">
                                        </th>
                                        <th><a href="#">21424582</a></th>
                                        <td>2021-08-24</td>
                                        <td>2021-09-24</td>
                                        <td>삼익전자</td>
                                        <td>김기철</td>
                                        <td>032-333-4423</td>
                                        <td>김철수</td>
                                        <td>
                                        	<p style="color:blue;">승인완료</p>
                                        </td>
                                        <td>
                                        	<p style="color:blue;">출고완료</p>
                                        </td>
                                    </tr>
                                </tbody>
                                
                            </table>
                            <div style="text-align:center;" class="form-group mt-5 col-md-12">
	                            <input class="btn  btn-defalte" type="button" value="닫기"
	                            	onclick="window.close();"/>
                    		</div>
                        </div>
                    </div>
                </div>
                </div>
                <!--End row-->
            <div>

            </div>
        </div>
        <!-- End Wrapper-->
	
		<%@ include file="../common/footer.jsp"%>
		<script src="${RESOURCES_PATH}/sales/js/orderManagement.js"></script>
		
</body>
</html>