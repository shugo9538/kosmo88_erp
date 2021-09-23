<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>우여곡절 - 재무상태표</title>
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
                <h3 class="page-title">
                    <a href="${ROOT_PATH}/account/salesSlipList?categoryNum=130">
               		 매입/매출장 목록</a>
                </h3>
                <ol class="breadcrumb">
                   <!--  <li>
                        <a href="#">매입목록</a>
                    </li> -->
                    <li>
                        <a href="${ROOT_PATH}/account/salesList">매출목록</a>
                    </li>
                   <!--  <li class="active">
                        Responsive Table
                    </li> -->
                </ol>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->          
           
           
               <!-- Start responsive Table-->
                <div class="col-md-12">
                 <div class="white-box">
	                 	<div class="title" style="text-align-last: center">
		                    <h2 class="header-title">매입전표 목록</h2>
		                    <h2 class="header-title">2021년</h2>
	                    </div>
                     <div class="table-responsive">
                         <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                        	<th>전표일자</th>
                                            <th>전표번호</th>
                                            <th>거래처코드</th>
                                            <th>거래처</th>
                                            <th>사업자번호</th>
                                            <th>품명</th>
                                            <th>공급가액</th>
                                            <th>세액</th>
                                            <th>합계</th>
                                            <th>유형</th>
                                            <th>요약</th>
                                            <th>일반전표ID</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>2021-01-01</td>
                                            <td>50001</td>
                                            <td>00105</td>
                                            <td>(주)머핀나라</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>20,000,000</td>
                                            <td>2,000,000</td>
                                            <td>22,000,000</td>
                                            <td>외상매입금</td>
                                            <td>상품매입</td>
                                            <td>22222</td>
                                        </tr>
                                        <tr>
                                            <td>2021-02-01</td>
                                            <td>50002</td>
                                            <td>00106</td>
                                            <td>(주)머핀나라</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>20,000,000</td>
                                            <td>2,000,000</td>
                                            <td>22,000,000</td>
                                            <td>외상매입금</td>
                                            <td>상품매입</td>
                                            <td>22222</td>
                                        </tr>
                                        <tr>
                                            <td>2021-03-01</td>
                                            <td>50003</td>
                                            <td>00107</td>
                                            <td>(주)머핀나라</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>20,000,000</td>
                                            <td>2,000,000</td>
                                            <td>22,000,000</td>
                                            <td>외상매입금</td>
                                            <td>상품매입</td>
                                            <td>22222</td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                         <tr style="background-color:ghostwhite; font-weight: bold;">
                                            <td colspan="5" align="center">합계</td>
                                            <td>3건 (매수 3매)</td>
                                            <td>79,000,000</td>
                                            <td>7,900,000</td>
                                            <td>86,900,000</td>
                                            <td colspan="3"></td>
                                        </tr>
                                    </tfoot>    
                                   </table>  
                            </div>
                       </div>
                   </div>
               </div>
               <!--End row-->

        <!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>	
         <!--End footer -->
       </div>
      <!--End main content -->
</body>
</html>
