<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<!-- alert 추가  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
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
                <h4 class="page-title">견적서 관리</h4>
                <ol class="breadcrumb">
                    <li>견적서 관리</li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->
            
            <ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/sales/estimateRegister">견적서 등록</a></li>
			</ul>
            
            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                	<!-- Start white-box -->
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	견적서 전체 목록
                        </h2>
                        <!-- form -->
                        <form class="form-horizontal" id="estimateManagementForm" name="estimateManagementForm"
                        	action="${ROOT_PATH}/sales/estimateRegisterAction" method="post">
	                     	<!-- csrf 토큰 -->
							<sec:csrfInput />
	                     <div class="table-responsive">
	                    	 <div class="col-md-2 mt-1 mb-4">
								<input class="btn btn-default" type="button" id="estimateChoiceDeleteBtn" value="견적서 삭제">
							 </div>
							 
	                         <table id="estimateList" class="display table" style="width:100%">
	                             <thead>
	                                 <tr>
	                                    <td style="text-align:center">
	                                         <input type="checkbox" id="checkAll" name="checkAll">
	                                    </td>
	                                    
	                                    <!-- p_estimate_list_view -->
	                                    
	                                    <th>견적번호</th> 		<!--  request_id  -->
                                        <th>거래처명</th>		<!--  client_name -->
                                        <th>거래처대표자명</th> <!--  client_ceo_name -->
                                        <th>거래처연락처</th>  <!--  client_phone -->
                                        <th>담당자</th>		<!-- employee_name -->
                                        <th>요청일자</th> 	 	<!--  begin_date  -->
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
		<%@ include file="./js_sales.jsp"%>
		<script src="${RESOURCES_PATH}/sales/js/estimateManagement_ajax.js"></script>
		<script src="${RESOURCES_PATH}/sales/js/estimateManagement.js"></script>
		<!-- 엑셀 출력  -->
		<script src="https://cdn.datatables.net/buttons/2.0.1/js/dataTables.buttons.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		<script src="https://cdn.datatables.net/buttons/2.0.1/js/buttons.html5.min.js"></script>
</body>
</html>