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
                            
                            
                            <table class="display table mt-12">
                            	<tr>
                            		<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td><input type="text" name="name" id="name"><input type="button" id="selectClient" name="selectClient" value="거래처 선택"
	                             		onclick="selectClient();"></td>
                            		<th style="background-color: #f1f1f1;">구분</th>
                            		<td><input type="text" value="법인" readonly></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">대표자</th>
                            		<td><input type="text" name="ceo_name" id="ceo_name" placeholder="대표자"></td>
                            		<th style="background-color: #f1f1f1;">거래처 연락처</th>
                            		<td><input type="text" name="phone" id="phone" placeholder="거래처 연락처"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">거래처 이메일</th>
                            		<td colspan="3"><input type="text" name="email" id="email" placeholder="거래처 이메일"></td>
                            	</tr>
                            	<tr>
                            		<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
                            		<td colspan="3">
                            			<input type="text" name="zip_code" id="zip_code" placeholder="우편번호">
                            		</td>
                            	</tr>
                            	<tr>
                            		<td colspan="3">
                            			<input style="width:350px;" type="text" name="address" id="address" placeholder="주소">
                            		</td>
                            	</tr>
                            	<tr>
                            		<td colspan="3">
                            			<input style="width:350px;" type="text" name="detail_address" id="detail_address" placeholder="상세주소">
                            		</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td><input type="text" name="employee_name" id="employee_name"><input type="button" id="selectClient" name="selectClient" value="담당자 선택"
	                             		placeholder="담당자" onclick="selectManager();"></td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td><input type="text" name="employee_dp" id="employee_dp" placeholder="담당자 부서"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td><input type="text" name="employee_phone" id="name" placeholder="담당자 연락처"></td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td><input type="text" name="employee_email" id="employee_email" placeholder="담당자 이메일"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">상품명</th>
                            		<td><input type="text" name="product_name" id="product_name"><input type="button" id="selectClient" name="selectClient" value="상품 선택"
	                             		placeholder="상품명" onclick="selectProduct();"></td>
                            		<th style="background-color: #f1f1f1;">상품수량</th>
                            		<td><input type="number" name="product_quantity" id="product_quantity" placeholder="상품수량"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">구매가</th>
                            		<td><input type="number" name="product_price" id="product_price" placeholder="구매가"></td>
                            		<th style="background-color: #f1f1f1;">판매가</th>
                            		<td><input type="number" name="sale_price" id="sale_price" placeholder="판매가"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">요청일자</th>
                            		<td><input type="date" name="start_date" id="start_date"></td>
                            		<th style="background-color: #f1f1f1;">납기일자</th>
                            		<td><input type="date" name="end_date" id="end_date"></td>
                            	</tr>
                            </table>
                            
                            <div class="form-group">
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
                                <input class="btn  btn-default" type="submit" value="삭제">
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
                                        <th>주문자</th>
                                        <th>주문자연락처</th>
                                        <th>상품명</th>
                                        <th>수량</th>
                                        <th>판매가</th>
                                        <th>담당자</th>
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
                                        <td>우창준</td>
                                        <td>032-333-4423</td>
                                        <td>냉장고</td>
                                        <td>270개</td>
                                        <td>900,000원</td>
                                        <td>김철수</td>
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
		</div>
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
		<script src="${RESOURCES_PATH}/sales/js/orderManagement.js"></script>
		
</body>
</html>