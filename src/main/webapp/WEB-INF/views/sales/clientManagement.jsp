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
		<!--body wrapper start-->
        <div class="wrapper">
              
          <!--Start Page Title-->
           <div class="page-title-box">
                <h4 class="page-title">견적서 관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">Dashboard</a>
                    </li>
                    <li>
                        <a href="#">Table</a>
                    </li>
                    <li class="active">
                        Responsive Table
                    </li>
                </ol>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->          
           
           
               <!-- Start responsive Table-->
                <div class="col-md-12">
                 <div class="white-box">
                    <h2 class="header-title">Responsive Table</h2>
                     <div class="table-responsive">
                         <table class="table table-bordered">
                          <thead>
                            <tr>
                              <th>#</th>
                              <th>회사명</th>
                              <th>사업자번호</th>
                              <th>대표자명</th>
                              <th>전화번호</th>
                              <th>주소</th>
                              <th>등록일</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>1</td>
                              <td>lg전자</td>
                              <td>1111-2222-333</td>
                              <td>장승철</td>
                              <td>032-333-4823</td>
                              <td>서울시 금천구</td>
                              <td>2021-08-24</td>
                            </tr>
                            
                           </tbody>
                        </table>
    
                     </div>
                 </div>
                 </div>
               <!-- End responsive Table-->               
               
			    </div>
        <!-- End Wrapper-->
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
</body>
</html>