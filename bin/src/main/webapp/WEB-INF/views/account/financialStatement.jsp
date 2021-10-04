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
		<%@ include file="common/accountHeader.jsp"%>
		<%@ include file="statement/financialStatementSetting.jsp" %>
		      
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">
              
          <!--Start Page Title-->
           <div class="page-title-box">
                <h4 class="page-title">재무제표</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="${ROOT_PATH}/account/financialStatement">재무상태표</a>
                    </li>
                    <li>
                        <a href="${ROOT_PATH}/account/incomeStatement">손익계산서</a>
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
		                    <h2 class="header-title">재무상태표</h2>
		                    <h3 class="header-title">제 18기(당)기 2021.09.19 현재 </h3>
	                    </div>
                     <div class="table-responsive">
                         <table class="table table-bordered">
                          <thead>
                            <tr>
                              <th>과목</th>
                              <th colspan="2">제 18(당)기</th>
                              <th colspan="2">제 17(전)기</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td> 자             산 </td>
                              <!-- root 경로 -->
                              <td><input type="hidden" id="root" value="${ROOT_PATH}"></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr class="total2">
                              <td> Ⅰ. 유  동    자  산  </td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td>2,764,422,100</td>
                            </tr>
                            <tr>
                              <td> (1) 당  좌    자  산 </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset1}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>1,956,562,100</td>
                            </tr>
                            <tr>
                              <!-- <td>      현금 및 현금성자산(보통예금)</td> -->
                              <td>  
                              <input type="hidden" id="accountTitle" value="계정과목">
                              <a href="#" onclick="accountTitleDetail();">    
                               	현금 및 현금성자산(보통예금)</a>
                              </td>
                              <td class="red">
                              	<fmt:formatNumber value="${cash_asets}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>686,488,500</td>
                              <td></td>
                            </tr>
                            <tr>
                              <!-- <td>      매   출    채   권(외상매출금)</td> -->
                              <td>
               					<a href="#"> 매   출    채   권(외상매출금)</a>              
                              </td>
                              <td class="red">
                              	<fmt:formatNumber value="${accounts_receivable}" pattern="###,###,###,###"/>	
                              </td>
                              <td></td>
                              <td>731,651,000</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>      부 가 세 대  급 금</td>
                              <td class="red">
                              	<fmt:formatNumber value="${vatPayment}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td></td>
                              <td>314,356,000</td>
                            </tr>
                            <tr>
                              <td> (2) 재  고    자  산 </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset2}" pattern="###,###,###"/>
                              </td>
                              <td></td>
                              <td>807,860,000</td>
                            </tr>
                            <tr>
                              <td>      상              품</td>
                              <td class="red">
                              <fmt:formatNumber value="${inventory_assets}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>322,710,000</td>
                              <td></td>
                            </tr>
                            <tr class="total1">
                              <td>자    산    총    계</td>
                              <td></td>
                              <td class="red">
                              <fmt:formatNumber value="${asset3}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>5,134,878,100</td>
                            </tr>
                            <tr>
                              <td> 부             채 </td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr class="total2">
                              <td> Ⅰ. 유  동    부  채  </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset4}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>1,942,210,500</td>
                            </tr>
                            <tr>
                              <td>      매   입    채   무(외상매입금)</td>
                              <td class="red">
                              	<fmt:formatNumber value="${purchase_receivable}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>678,710,000</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>      부 가 세 예  수 금</td>
                              	<td class="red">
                              	<fmt:formatNumber value="${vatDeposit}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>543,185,000</td>
                              <td></td>
                            </tr>
                            <tr class="total1">
                              <td>부    채    총    계</td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset4}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>1,997,310,500</td>
                            </tr>
                            <tr>
                              <td>자본</td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr class="total2">
                              <td> Ⅰ. 자      본      금  </td>
                              <td></td>
                               <td class="red">
                             	 <fmt:formatNumber value="${asset5}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>541,997,000</td>
                            </tr>
                            <tr>
                              <td>      자     본       금</td>
                              <td></td>
                              <td class="red">
                             	 <fmt:formatNumber value="${capital}" pattern="###,###,###,###" />
                              </td>
                              <td></td>
                              <td>541,997,000</td>
                            </tr>
                            <tr class="total2">
                              <td> Ⅱ. 이  익  잉  여  금    </td>
                              <td></td>
                              <td>3,629,439,406</td>
                              <td></td>
                              <td>2,595,570,600</td>
                            </tr>
 							<tr>
                              <td>(당기순이익)</td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>                           
							<tr>
                              <td>
                               		  당기 :1,509,072,120     
                              </td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>   전기 :     1,509,072,120</td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>자본총계(당기순이익+)</td>
                              <td></td>
                              <td>4,171,436,406</td>
                              <td></td>
                              <td>3,137,567,600</td>
                            </tr>
                            <tr class="total1">
                              <td>부채및자본총계</td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset7}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>5,134,878,100</td>
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
		<%@ include file="common/accountFooter.jsp"%>
         <!--End footer -->
       </div>
      <!--End main content -->
</body>
</html>