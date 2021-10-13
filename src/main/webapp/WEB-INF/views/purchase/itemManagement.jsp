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
				<h4 class="page-title">상품 관리</h4>
				<ol class="breadcrumb">
					<li class="active">상품 관리</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			
         <!--Start row-->
         <div class="row">
             <div class="col-md-12">
             	<!-- Start white-box -->
                <div class="white-box">
                	<h2 class="header-title">
                     	<i class="fa fa-chevron-circle-right mr-2"></i>
                     	상품 전체 목록
                    </h2> 	
                 	<form class="form-horizontal" id="itemManagementForm" name="itemManagementForm"
						method="post">
                     	<!-- csrf 토큰 -->
						<sec:csrfInput />
                    	<div class="table-responsive">
                     		<table id="itemList" class="display table" style="width:100%">
                             
                        	</table>
                    	</div>
                 	</form>    
                 </div>
               </div>
	        </div>
	        <!--End row-->
		</div>
		<!-- End Wrapper-->
		
		<%@ include file="../common/footer.jsp"%>
		<%@ include file="./js_purchase.jsp"%>
		<script src="${RESOURCES_PATH}/purchase/js/itemManagement_ajax.js"></script>
</body>
</html>