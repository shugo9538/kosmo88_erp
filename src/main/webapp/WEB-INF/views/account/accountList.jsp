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
  <link rel="icon" href="assets/images/favicon.png" type="image/png">
  <title>우여곡절 - 계좌조회 </title>
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
                <h4 class="page-title">통장거래내역</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="account-salary.jsp">급여통장</a>
                    </li>
                    <li>
                        <a href="account-client.jsp">거래처통장</a>
                    </li>
                    <li class="active">
                        <a href="account.jsp">통장목록</a>
                    </li>
                </ol>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->          
           
               <!--Start row-->
               <div class="row">
                   <div class="col-md-12">
                       <div class="white-box">
                           <h2 class="header-title">통장 목록</h2>
                            <div class="table-responsive">
                             <table id="example" class="display table">
                                    <thead>
                                        <tr>
                                            <th>계좌코드</th>
                                            <th>계좌명</th>
                                            <th>계좌번호</th>
                                            <th>은행</th>
                                            <th>잔액</th>
                                            <th>요약</th>
                                            <th>등록일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
           								    <td>3148</td>
                                            <td>우여곡절-급여</td>
                                            <td>1002-050-447307</td>
                                            <td>우리은행</td>
                                            <td>100000</td>
                                            <td>급여통장</td>
                                            <td>2021-09-19</td>
                                        </tr>
                                        <tr>
           								    <td>3148</td>
                                            <td>우여곡절-거래처내역</td>
                                            <td>1002-050-447307</td>
                                            <td>우리은행</td>
                                            <td>100000</td>
                                            <td>급여통장</td>
                                            <td>2021-09-19</td>
                                        </tr>
                                        <tr>
           								    <td>3148</td>
                                            <td>1002-050-447307</td>
                                            <td>1002-050-447307</td>
                                            <td>우리은행</td>
                                            <td>100000</td>
                                            <td>급여통장</td>
                                             <td>2021-09-19</td>
                                        </tr>
                                        <tr>
           								    <td>3148</td>
                                            <td>1002-050-447307</td>
                                            <td>1002-050-447307</td>
                                            <td>우리은행</td>
                                            <td>100000</td>
                                            <td>급여통장</td>
                                             <td>2021-09-19</td>
                                        </tr>
                                        <tr>
           								    <td>3148</td>
                                            <td>1002-050-447307</td>
                                            <td>1002-050-447307</td>
                                            <td>우리은행</td>
                                            <td>100000</td>
                                            <td>급여통장</td>
                                             <td>2021-09-19</td>
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
