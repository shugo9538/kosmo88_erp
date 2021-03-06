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
		
		 <c:set var="now" value="<%=new java.util.Date()%>" />
 		<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy년MM월dd일" /></c:set>
		      
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
		                    <h1 class="header-title"  style="font-size:35px">재무상태표</h1>
		                    <h2 class="header-title">제 01기(당)기<c:out value="${sysYear}"/></h2>
	                    </div>
                     <div class="table-responsive">
                         <table id="finacialStatment" class="table table table-hover m-0">
                          <thead>
                            <tr>
                              <th class="title_font">과목</th>
                              <th colspan="2" class="title">제 01(당)기</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td> 자             산 </td>
                              <!-- root 경로 -->
                              <td><input type="hidden" id="root" value="${ROOT_PATH}"></td>
                              <td></td>
                            </tr>
                            <tr class="warning">
                              <td> Ⅰ. 유  동    자  산  </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset1 + asset2}" pattern="###,###,###,###"/>
                              </td>
                            </tr>
                            <tr>
                              <td> (1) 당  좌    자  산 </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset1}" pattern="###,###,###,###"/>
                              </td>
                            </tr>
                            <tr>
                              <!-- <td>      현금 및 현금성자산(보통예금)</td> -->
                              <td>  
                               	현금 및 현금성자산(보통예금)
                              </td>
                              <td class="red">
                              	<fmt:formatNumber value="${cash_asets}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                            </tr>
                            <tr>
                              <!-- <td>      매   출    채   권(외상매출금)</td> -->
                              <td>
                              <input type="hidden" id="sales" value="매출채권">
               					<a href="#" onclick="sales();"> 매   출    채   권(외상매출금)</a>              
                              </td>
                              <td class="red">
                              	<fmt:formatNumber value="${accounts_receivable}" pattern="###,###,###,###"/>	
                              </td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>      부 가 세 대  급 금</td>
                              <td class="red">
                              	<fmt:formatNumber value="${vatPayment}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                            </tr>
                            <tr>
                              <td> (2) 재  고    자  산 </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset2}" pattern="###,###,###"/>
                              </td>
                            </tr>
                            <tr>
                              <td>      상              품</td>
                              <td class="red">
                              <fmt:formatNumber value="${inventory_assets}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                            </tr>
                            <tr class="info">
                              <td>자    산    총    계</td>
                              <td></td>
                              <td class="red">
                              <fmt:formatNumber value="${asset3}" pattern="###,###,###,###"/>
                              </td>
                            </tr>
                            <tr class="warning">
                              <td> 부             채 </td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr class="total2">
                              <td> Ⅰ. 유  동    부  채  </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset4}" pattern="###,###,###,###"/>
                              </td>
                            </tr>
                            <tr>
                              <td>      매   입    채   무(외상매입금)</td>
                              <td class="red">
                              	<fmt:formatNumber value="${purchase_receivable}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>      부 가 세 예  수 금</td>
                              	<td class="red">
                              	<fmt:formatNumber value="${vatDeposit}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                            </tr>
                            <tr  class="info">
                              <td>부    채    총    계</td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset4}" pattern="###,###,###,###"/>
                              </td>
                            </tr>
                            <tr>
                              <td>자본</td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr  class="info">
                              <td> Ⅰ. 자      본      금  </td>
                              <td></td>
                               <td class="red">
                             	 <fmt:formatNumber value="${asset5}" pattern="###,###,###,###"/>
                              </td>
                            </tr>
                            <tr>
                              <td>      자     본       금</td>
                              <td class="red">
                             	 <fmt:formatNumber value="${capital}" pattern="###,###,###,###" />
                              </td>
                              <td></td>
                            </tr>
 							<tr  class="info">
                              <td>(당기순이익)</td>
                              <td></td>
                              <td></td>
                            </tr>                           
							<tr>
                              <td class="red">
                           		    당기 :<fmt:formatNumber value="${income8}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>자본총계(당기순이익+)</td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset7 - asset4 + income8}" pattern="###,###,###,###"/>
                              </td>
                            </tr>
                            <tr  class="info">
                              <td>부채및자본총계</td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${asset7}" pattern="###,###,###,###"/>
                              </td>
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
