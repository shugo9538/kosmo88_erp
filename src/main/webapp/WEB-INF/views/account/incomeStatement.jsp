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
		<%@ include file="common/accountHeader.jsp" %>
		<%@ include file="statement/incomeStatementSetting.jsp"%>    
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
                  <!--   <li class="active">
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
		                    <h2 class="header-title">손익계산서</h2>
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
                              <td> Ⅰ  . 매      출      액 </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${income1}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>2,764,422,100</td>
                            </tr>
                            <tr>
                              <td>       상    품   매   출 </td>
                              <td class="red">
                              	<fmt:formatNumber value="${sales_cost}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>2,764,422,100</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>Ⅱ  . 매    출   원   가 </td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td class="red">      상 품 매 출  원 가</td>
                              <td></td>                             	
                              <td></td>
                              <td>686,488,500</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>        기초  상품  재고액</td>
                              <td class="red">
                              	<fmt:formatNumber value="${basic_product}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>
                              731,651,000
                              </td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>        당기 상품 매 입 액</td>
                              <td class="red">
                              	<fmt:formatNumber value="${current_product}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td></td>
                              <td>314,356,000</td>
                            </tr>
                            <tr>
                              <td>        기말  상품  재고액</td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${end_product}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>807,860,000</td>
                            </tr>
                            <tr>
                              <td>Ⅲ  . 매  출  총  이  익</td>
                              <td></td>
                              <td class="red">
                              <fmt:formatNumber value="${income1}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>322,710,000</td>
                            </tr>
                            <tr>
                              <td>Ⅳ  . 판  매  관  리  비</td>
                              <td></td>
                              <td class="red">
                              <fmt:formatNumber value="${income2}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>5,134,878,100</td>
                            </tr>
                            <tr>
                              <td>      직   원    급   여</td>
                              <td class="red">
                              	<fmt:formatNumber value="${employee_salary}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>370,000,000</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>      복  리  후  생  비</td>
                              <td>29,080,000</td>
                              <td></td>
                              <td>29,080,000</td>
                              <td></td>
                            </tr>                                                       
                            <tr>
                              <td>      여  비  교  통  비</td>
                              <td>8,565,000</td>
                              <td></td>
                              <td>8,565,000</td>
                              <td></td>
                            </tr>  
                            <tr>
                              <td>      접      대      비</td>
                              <td>27,050,000</td>
                              <td></td>
                              <td>27,050,000</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>      통      신      비</td>
                              <td>7,755,000</td>
                              <td></td>
                              <td>7,755,000</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>      수  도  광  열  비</td>
                              <td>3,280,000</td>
                              <td></td>
                              <td>3,280,000</td>
                              <td></td>
                            </tr>
                                                        <tr>
                              <td>      세 금 과  공 과 금</td>
                              <td>1,600,000</td>
                              <td></td>
                              <td>1,600,000</td>
                              <td></td>
                            </tr> 
                                                        <tr>
                              <td>      지  급  임  차  료</td>
                              <td>29,000,000</td>
                              <td></td>
                              <td>29,000,000</td>
                              <td></td>
                            </tr> 
                                                        <tr>
                              <td>      보      험      료</td>
                              <td>26,930,314</td>
                              <td></td>
                              <td>26,930,314</td>
                              <td></td>
                            </tr> 
                                                        <tr>
                              <td>      차  량  유  지  비</td>
                              <td>9,200,000</td>
                              <td></td>
                              <td>9,200,000</td>
                              <td></td>
                            </tr> 
                                                        <tr>
                              <td>      사  무  용  품  비</td>
                              <td>5,485,000</td>
                              <td></td>
                              <td>5,485,000</td>
                              <td></td>
                            </tr> 
                                                        <tr>
                              <td>      소    모   품   비</td>
                              <td>5,000,000</td>
                              <td></td>
                              <td>5,000,000</td>
                              <td></td>
                            </tr>                                                                                                                                               
                            <tr>
                              <td> Ⅴ  . 영    업   이   익  </td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${income3}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>800,000</td>
                            </tr>
                            <tr>
                              <td>Ⅵ  . 영  업  외  수  익</td>
                              <td>1,000,000</td>
                              <td></td>
                              <td>1,000,000</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>      이    자   수   익</td>
                              <td>1,000,000</td>
                              <td></td>
                              <td>1,000,000</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>Ⅶ  . 영  업  외  비  용</td>
                              <td></td>
                              <td>80,000,000</td>
                              <td></td>
                              <td>80,000,000</td>
                            </tr>
                            <tr>
                              <td>      이   자    비   용</td>
                              <td>80,000,000</td>
                              <td></td>
                              <td>80,000,000</td>
                              <td></td>
                            </tr>
                            <tr>
                              <td>Ⅷ  . 법인세비용차감전순이익</td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${income6}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>1,513,671,806</td>
                            </tr>
                            <tr>
                              <td>Ⅸ  . 법  인  세  비  용</td>
                              <td></td>
                              <td>541,997,000</td>
                              <td></td>
                              <td>541,997,000</td>
                            </tr>
                            <tr>
                              <td>Ⅹ  . 당  기  순  이  익</td>
                              <td></td>
                              <td class="red">
                              	<fmt:formatNumber value="${income8}" pattern="###,###,###,###"/>
                              </td>
                              <td></td>
                              <td>1,513,671,806</td>
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
		<%@ include file="common/accountFooter.jsp" %>	
         <!--End footer -->
       </div>
      <!--End main content -->
</body>
</html>
