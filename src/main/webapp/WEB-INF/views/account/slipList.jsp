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
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">
              
          <!--Start Page Title-->
           <div class="page-title-box">
                <h4 class="page-title">전표입력/장부관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">일반전표 삭제</a>
                    </li>
                    <li>
                        <a href="#">일반전표 수정</a>
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
                           <h2 class="header-title">일반전표 목록</h2>
                            <div class="table-responsive">
                             <table id="example" class="table table table-hover m-0">
                                    <thead>
                                        <tr>
                                            <th>전표번호</th>
                                            <th>유형</th>
                                            <th>발행일</th>
                                            <th>승인일자</th>
                                            <th>상태(Y/N)</th>
                                            <th>부서코드</th>
                                            <th>파트별ID</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>11111</td>
                                            <td>33333</td>
                                            <td>2021-09-22</td>
                                            <td>2021-09-22</td>
                                            <td>미승인</td>
                                            <td>22222</td>
                                            <td>33333</td>
                                        </tr>
                                        <tr>
                                            <td>11111</td>
                                            <td>33333</td>
                                            <td>2021-09-22</td>
                                            <td>2021-09-22</td>
                                            <td>Y</td>
                                            <td>22222</td>
                                            <td>33333</td>
                                        </tr>
                                        <tr>
                                            <td>11111</td>
                                            <td>33333</td>
                                            <td>2021-09-22</td>
                                            <td>2021-09-22</td>
                                            <td>Y</td>
                                            <td>22222</td>
                                            <td>33333</td>
                                        </tr>
                                        <tr>
                                            <td>11111</td>
                                            <td>33333</td>
                                            <td>2021-09-22</td>
                                            <td>2021-09-22</td>
                                            <td>Y</td>
                                            <td>22222</td>
                                            <td>33333</td>
                                        </tr>
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
         <!--End footer -->
       </div>
      <!--End main content -->

</body>

</html>
