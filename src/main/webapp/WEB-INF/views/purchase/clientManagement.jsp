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
				<h4 class="page-title">거래처 관리</h4>
				<ol class="breadcrumb">
					<li class="active">거래처 관리</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/purchase/clientRegister">거래처 등록</a></li>
			</ul>
			
         <!--Start row-->
         <div class="row">
             <div class="col-md-12">
             	<!-- Start white-box -->
                 <div class="white-box">
                 	<h2 class="header-title">
                     	<i class="fa fa-chevron-circle-right mr-2"></i>
                     	거래처 전체 목록</h2>
                 	<form class="form-horizontal" id="clientManagementForm" name="clientManagementForm"
						action="${ROOT_PATH}/purchase/clientRegisterAction" method="post">
                     	<!-- csrf 토큰 -->
						<sec:csrfInput />
                     <div class="table-responsive">
                    	 <div class="col-md-2 mt-1 mb-4">
							<input class="btn btn-default" type="button" id="clientChoiceDeleteBtn" value="거래처 삭제">
						 </div>
                     	
                         <table id="clientList" class="display table">
                             <thead>
                                 <tr>
                                     <td style="text-align:center">
                                         <input type="checkbox" id="checkAll" name="checkAll">
                                     </td>
                                     <th>거래처 번호</th>
                                     <th>회사명</th>
                                     <th>사업자번호</th>
                                     <th>대표자명</th>
                                     <th>전화번호</th>
                                     <th>주소</th>
                                     <th>등록일</th>
                                 </tr>
                             </thead>
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
		<script src="${RESOURCES_PATH}/purchase/js/clientManagement.js"></script>
		
</body>
</html>