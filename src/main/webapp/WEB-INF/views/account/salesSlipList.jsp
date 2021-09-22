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
                <h4 class="page-title">매입/매출장 목록</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="${ROOT_PATH}/account/purchase">매입목록</a>
                    </li>
                    <li>
                        <a href="${ROOT_PATH}/account/salesSlip">매출목록</a>
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
		                    <h2 class="header-title">매입/매출장</h2>
		                    <h2 class="header-title">2021년</h2>
	                    </div>
                     <div class="table-responsive">
                         <table class="table table-bordered">
                          <thead>
                            <tr>
                              <th>전표일자</th>
                              <th>번호</th>
                              <th>코드</th>
                              <th>거래처</th>
                              <th>사업자번호</th>
                              <th>품명</th>
                              <th>공급가액</th>
                              <th>세액(부가세)</th>
                              <th>합계</th>
                            </tr>
                          </thead>
                          <tfoot>
                            <tr>
                              <th colspan="5" align="center">합계</th>
                              <th>00건(매수00매)</th>
                              <th>200,000,000</th>
                              <th>20,000,000</th>
                              <th>22,000,000</th>
                            </tr>
                          </tfoot>
                          <tbody>
                            <tr>
                              <td>2021-01-01 </td>
                              <td>50001 </td>
                              <td>00105</td>
                              <td>(주)바른식품</td>
                              <td>515-811-4586</td>
                              <td>상품</td>
                              <td>20,000,000</td>
                              <td>2,000,000</td>
                              <td>22,000,000</td>
                            </tr>
                            <tr>
                              <td>2021-01-01 </td>
                              <td>50001 </td>
                              <td>00105</td>
                              <td>(주)바른식품</td>
                              <td>515-811-4586</td>
                              <td>상품</td>
                              <td>20,000,000</td>
                              <td>2,000,000</td>
                              <td>22,000,000</td>
                            </tr>
                            <tr>
                              <td>2021-01-01 </td>
                              <td>50001 </td>
                              <td>00105</td>
                              <td>(주)바른식품</td>
                              <td>515-811-4586</td>
                              <td>상품</td>
                              <td>20,000,000</td>
                              <td>2,000,000</td>
                              <td>22,000,000</td>
                            </tr>
                            <tr>
                              <td>2021-01-01 </td>
                              <td>50001 </td>
                              <td>00105</td>
                              <td>(주)바른식품</td>
                              <td>515-811-4586</td>
                              <td>상품</td>
                              <td>20,000,000</td>
                              <td>2,000,000</td>
                              <td>22,000,000</td>
                            </tr>
                            <tr>
                              <td>2021-01-01 </td>
                              <td>50001 </td>
                              <td>00105</td>
                              <td>(주)바른식품</td>
                              <td>515-811-4586</td>
                              <td>상품</td>
                              <td>20,000,000</td>
                              <td>2,000,000</td>
                              <td>22,000,000</td>
                            </tr>
                        </table>
                     </div>
                 </div>
                 </div>
               <!-- End responsive Table-->               
			    </div>
        <!-- End Wrapper-->

        <!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>	
         <!--End footer -->
       </div>
      <!--End main content -->
</body>
</html>
