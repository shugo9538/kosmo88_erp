<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
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
                <h4 class="page-title">구매 관리</h4>
                <ol class="breadcrumb">
                    <li class="active">구매 관리</li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->
            
            <ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/purchase/orderRegister">주문서 등록</a></li>
			</ul>
            
            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                	<!-- Start white-box -->
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	주문서 전체 목록
                        </h2>
                        <!-- form -->
                        <form class="form-horizontal" id="orderManagementForm" name="orderManagementForm"
                        	action="${ROOT_PATH}/purchase/orderRegisterAction" method="post">
	                     	<!-- csrf 토큰 -->
							<sec:csrfInput />
	                     <div class="table-responsive">
	                    	 <div class="col-md-2 mt-1 mb-4">
								<input class="btn btn-default" type="button" id="orderChoiceDeleteBtn" value="주문서 삭제">
							 </div>
							 
	                         <table id="orderList" class="display table" style="width:100%">
	                             <thead>
	                             	<tr>
		                                <td style="text-align:center">
		                                     <input type="checkbox" id="checkAll" name="checkAll">
		                                </td>
	                                    <!-- p_order_list_view -->
	                                    <th>주문번호</th> 		 <!-- request_id -->
	                                    <th>주문처</th>		 <!-- client_name -->
	                                    <th>대표자</th>  		 <!-- client_ceo_name -->
	                                    <th>주문처연락처</th>   <!-- client_phone -->
	                                    <th>담당자</th>		 <!-- employee_name -->
	                                    <th>주문일자</th> 	 	 <!-- begin_date -->
	                                    <th>납기요청일자</th>  	 <!-- end_date -->
                                        <th>승인상태</th>		 <!-- slip_state -->
                                        <th>입고상태</th>		 <!-- request_state -->
	                                 </tr>
	                             </thead>
	                         </table>							 
						 </div>
						 </form>	
                       	 <!-- form -->
                    </div>
                    <!-- End white-box -->
                </div>       
            </div>           
            <!--End row-->       
        </div>               
        <!-- End Wrapper --> 
        
		<%@ include file="../common/footer.jsp"%>
		<%@ include file="./js_purchase.jsp"%>
		<script src="${RESOURCES_PATH}/purchase/js/orderManagement_ajax.js"></script>
		<script src="${RESOURCES_PATH}/purchase/js/orderManagement.js"></script>
		
		<!-- 엑셀 출력  -->
		<script src="https://cdn.datatables.net/buttons/2.0.1/js/dataTables.buttons.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		<script src="https://cdn.datatables.net/buttons/2.0.1/js/buttons.html5.min.js"></script>
</body>
</html>