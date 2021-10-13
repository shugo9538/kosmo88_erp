<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="author" content="">
  <title> 회계관리 - 거래처 목록</title>

</head>

<body class="sticky-header">


    <!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
    <!--End left side menu-->

    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
		<%@ include file="../common/header.jsp"%> 
		<%@ include file="common/accountHeader.jsp"%>   
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">
              
          <!--Start Page Title-->
           <div class="page-title-box">
                <h4 class="page-title">기초정보 관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="${ROOT_PATH}/account/clientDetail">신규거래처 등록</a>
                    </li>
                    <li>
                        <a href="#">거래처 정보 수정</a>
                    </li>
                   <!--  <li class="active">
                        Data Table
                    </li> -->
                </ol>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->          
           
               <!--Start row-->
               <div class="row">
                   <div class="col-md-12">
                       <div class="white-box">
                           <h2 class="header-title">거래처 관리 (등록 거래처 총 ${cnt}개)</h2>
                            <div class="table-responsive">
                             <table id="example" class="table table table-hover m-0"><!-- display table  -->
                                    <thead>
                                        <tr>
                                            <th>거래처코드</th>
                                            <th>거래처유형</th>
                                            <th>거래처명</th>
                                            <th>대표자</th>
                                            <th>사업자등록번호</th>
                                            <th>주소지</th>
                                            <th>우편번호</th>
                                            <th>이메일</th>
                                            <th>등록일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="dto" items="${client}">
   											<tr>
   												<!-- 거래처코드  -->
                                        		<td>${dto.id}</td>
   												<!-- 거래처유형  -->
                                        		<td>${dto.type}</td>
   												<!-- 거래처명  -->
                                        		<td>${dto.name}</td>
   												<!-- 대표자  -->
                                        		<td>${dto.ceo_name}</td>
   												<!-- 사업자등록번호  -->
                                        		<td>${dto.register_num}</td>
   												<!-- 주소지  -->
                                        		<td>${dto.address}</td>
   												<!-- 우편번호  -->
                                        		<td>${dto.zip_code}</td>
   												<!-- 이메일  -->
                                        		<td>${dto.email}</td>
   												<!-- 등록일  -->
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.register_date}"/>
                                        		</td>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                    </tbody>
                                   </table>  
                            </div>
                       </div>
                   </div>
               </div>
               <!--End row-->
			    </div>
        <!-- End Wrapper-->

        <!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>
		<%@ include file="common/accountFooter.jsp"%>	
         <!--End footer -->
       </div>
      <!--End main content -->

</body>

</html>
