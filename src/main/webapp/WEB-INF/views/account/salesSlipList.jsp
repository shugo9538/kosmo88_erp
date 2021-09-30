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
  <title> 회계관리 - 일반전표</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

 <!-- //제이쿼리 ui css -->
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <!-- //제이쿼리 style css -->
 <link rel="stylesheet" href="/resources/demos/style.css">
 <!-- //제이쿼리 js -->
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <!-- //제이쿼리 ui js -->
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- jQuery datepicker 한국어 전환 --> 
<script src="/logistics_erp/resources/accounting/js/datepicker-ko.js">

/* datepicker */
$(function(){
	// 매입매출장 목록
    $("#statd_date").datepicker(); // 검색시작일
    $("#end_date").datepicker(); // 검색 마지마막일
});

</script>

</head>
<body class="sticky-header">

    <!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
    <!--End left side menu-->
    
	
    <!-- main content start-->
    <div class="main-content" >
        <!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		<%-- <%@ include file="common/accountHeader.jsp" %>   --%>  
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">
          <!--Start Page Title-->
           <div class="page-title-box">
                <h2 class="page-title">매입/매출장 목록</h2>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->  
           
               <!-- Start responsive Table-->
                <div class="col-md-12">
           	   <!-- 메뉴버튼 -->
                            	<div>
			        <ul class="nav nav-pills custom-nav">
						<li class="active"><a href="${ROOT_PATH}/account/purchaseList?categoryNum=131">매입목록</a></li>
								
						<li class="active"><a href="${ROOT_PATH}/account/salesList?categoryNum=132">매출목록</a></li>
								
					</ul>
                 	</div>
      	 		 <!-- 메뉴버튼 끝 -->    
                 <div class="white-box">
	                 	<div class="title" style="text-align-last: center">
		                    <h2 class="header-title">매입/매출장</h2>
		                    <h2 class="header-title">2021년</h2>
	                    </div>
	                    
	               <!--Start row-->
		                <div class="row">
		                    <div class="col-md-12">
		                        <form action="#" class="form-horizontal">
		                            <div class="form-group">
		                                <label class="control-label col-md-4">검색 일자</label>
		                                    <div class="input-daterange input-group" id="date-range">
		                                    	<div class="col-md-3">
		                                        <input type="text" class="form-control" name="start" id="statd_date" readonly/>
		                                        </div>
		                                        <div class="col-md-1">
		                                        <input type="text" class="form-control" readonly value="~">
		                                        </div>
		                                        <div class="col-md-3">
		                                        <input type="text" class="form-control" name="end" id="end_date" readonly/>
						                        </div>
						                        <div class=" col-md-3">
						                        <select class="form-control" id="salesPurchase">
							                        <option value="0" selected>선택</option>
							                        <option value="1">매출</option>
							                        <option value="2">매입</option>
						                        </select>
						                        </div>
		                                </div>
		                            </div>
								</form>
		                    </div>
		                </div>
		            <!--End row-->    
	                    
                     <div class="table-responsive">
                         <table id="example" class="table table-bordered">
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
                                    <!-- 등록 매출/매입전표가 있는경우 -->
                                    <c:if test="${cnt > 0}">
                                    	<c:set var="sum_supply" value="0"/>
                                    	<c:set var="sum_tax" value="0"/>
                                    	<c:set var="sum_total" value="0"/>
                                    	<c:forEach var="dto" items="${saleslip}">
   											<tr>
   												<%-- <td>${number}
   													<c:set var="number" value="${number -1 }"/>
   												</td> --%>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd" value="${dto.confirm_date}"/>
                                        		</td>
                                        		<td>${dto.id}</td>
                                        		<%-- <td>${dto.account_title}</td> --%>
                                        		<td>${dto.client_code}</td>
                                        		<td>${dto.client_name}</td>
                                        		<td>${dto.client_num}</td>
                                        		<td>${dto.product_name}</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.supply_amount}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.tax_amount}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.supply_amount + dto.tax_amount}"/>
                                        		</td>
                                        		<td>${dto.type}</td>
                                        		<td>${dto.abs}</td>
                                        		<td>${dto.slip_id}</td>
                                        		<c:set var="sum_supply" value="${sum_supply + dto.supply_amount}"/>
                                    			<c:set var="sum_tax" value="${sum_tax + dto.tax_amount}"/>
                                    			<c:set var="sum_total" value="${sum_total + dto.supply_amount + dto.tax_amount}"/>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                    	 <tr style="background-color:ghostwhite; font-weight: bold;">
                                            <td colspan="5" align="center">합계</td>
                                            <td>${cnt}건 (매수 ${cnt}매)</td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_supply}"/>
                                            </td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_tax}"/>
                                            </td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_total}"/>
                                            </td>
                                            <td colspan="3"></td>
                                        </tr>
                                     </c:if>
                                    <!-- 등록 매출/매입전표가 있는경우 -->                     
                                    <c:if test="${cnt > 0}">
                                    	<c:set var="sum_supply" value="0"/>
                                    	<c:set var="sum_tax" value="0"/>
                                    	<c:set var="sum_total" value="0"/>
                                    	<c:forEach var="dto" items="${saleslip}">
   											<tr>
   												<%-- <td>${number}
   													<c:set var="number" value="${number -1 }"/>
   												</td> --%>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd" value="${dto.confirm_date}"/>
                                        		</td>
                                        		<td>${dto.id}</td>
                                        		<%-- <td>${dto.account_title}</td> --%>
                                        		<td>${dto.client_code}</td>
                                        		<td>${dto.client_name}</td>
                                        		<td>${dto.client_num}</td>
                                        		<td>${dto.product_name}</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.supply_amount}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.tax_amount}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.supply_amount + dto.tax_amount}"/>
                                        		</td>
                                        		<td>${dto.type}</td>
                                        		<td>${dto.abs}</td>
                                        		<td>${dto.slip_id}</td>
                                        		<c:set var="sum_supply" value="${sum_supply + dto.supply_amount}"/>
                                    			<c:set var="sum_tax" value="${sum_tax + dto.tax_amount}"/>
                                    			<c:set var="sum_total" value="${sum_total + dto.supply_amount + dto.tax_amount}"/>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                    	 <tr style="background-color:ghostwhite; font-weight: bold;">
                                            <td colspan="5" align="center">합계</td>
                                            <td>${cnt}건 (매수 ${cnt}매)</td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_supply}"/>
                                            </td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_tax}"/>
                                            </td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_total}"/>
                                            </td>
                                            <td colspan="3"></td>
                                        </tr>
                                     </c:if>
									
									<!-- 등록 매출/매입전표가 있는경우 -->                     
                                    <c:if test="${cnt > 0}">
                                    	<c:set var="sum_supply" value="0"/>
                                    	<c:set var="sum_tax" value="0"/>
                                    	<c:set var="sum_total" value="0"/>
                                    	<c:forEach var="dto" items="${saleslip}">
   											<tr>
   												<%-- <td>${number}
   													<c:set var="number" value="${number -1 }"/>
   												</td> --%>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd" value="${dto.confirm_date}"/>
                                        		</td>
                                        		<td>${dto.id}</td>
                                        		<%-- <td>${dto.account_title}</td> --%>
                                        		<td>${dto.client_code}</td>
                                        		<td>${dto.client_name}</td>
                                        		<td>${dto.client_num}</td>
                                        		<td>${dto.product_name}</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.supply_amount}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.tax_amount}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.supply_amount + dto.tax_amount}"/>
                                        		</td>
                                        		<td>${dto.type}</td>
                                        		<td>${dto.abs}</td>
                                        		<td>${dto.slip_id}</td>
                                        		<c:set var="sum_supply" value="${sum_supply + dto.supply_amount}"/>
                                    			<c:set var="sum_tax" value="${sum_tax + dto.tax_amount}"/>
                                    			<c:set var="sum_total" value="${sum_total + dto.supply_amount + dto.tax_amount}"/>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                    	 <tr style="background-color:ghostwhite; font-weight: bold;">
                                            <td colspan="5" align="center">합계</td>
                                            <td>${cnt}건 (매수 ${cnt}매)</td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_supply}"/>
                                            </td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_tax}"/>
                                            </td>
                                            <td>
                                            <fmt:formatNumber pattern="###,###,###,###" value="${sum_total}"/>
                                            </td>
                                            <td colspan="3"></td>
                                        </tr>
                                     </c:if>
                                     <!-- 등록 매출/매입전표가 없는경우 -->
                                    <c:if test="${cnt == 0}">
                                     	<tr>
                                     		<td colspan="12" align="center">
                                     			<span style="color:red"> 등록된 전표가 없습니다. </span>
                                     		</td>
                                     	</tr>
                                     </c:if> 
                                    </tbody>
                                    
                                    <tfoot>
                                    <!-- 등록 매출/매입전표가 있는경우 --> 
                                     <c:if test="${cnt > 0}">
                                     <tr>
                                     	<th colspan="12">
                                     	<!-- 맨처음[◀◀] / 이전블럭[◀]  -->
                                     	<c:if test="${startPage > pageBlock}">
                                     		<a href="${ROOT_PATH}/account/salesSlipList?categoryNum=130" style="color:block">[◀◀]</a>
                                     		<a href="${ROOT_PATH}/account/salesSlipList?categoryNum=130&pageNum=${startPage-pageBlock}" style="color:block">[◀]</a>
                                     	</c:if>
                                     	
                                     	<c:forEach var="i" begin="${startPage}" end="${endPage}">
                                     		<c:if test="${i == currengPage}">
                                     			<span><b>[${i}]</b></span>
                                     		</c:if>
                                     		<c:if test="${i != currengPage}">
                                     			<a href="${ROOT_PATH}/account/salesSlipList?categoryNum=130&pageNum=${i}">[${i}]</a>
                                     		</c:if>
                                     	</c:forEach>
                                     	<!-- 다음블록[▶▶] / 맨마지막블럭[▶]  -->
                                     	<c:if test="${pageCount > endPage}">
                                     		<a href="${ROOT_PATH}/account/salesSlipList?categoryNum=130&pageNum=${startPage + pageBlock}">[▶]</a>
                                     		<a href="${ROOT_PATH}/account/salesSlipList?categoryNum=130&pageNum=${pageCount}">[▶▶]</a>
                                     	</c:if>
                                     	</th>
                                     	</tr>
                                     </c:if>
                                    </tfoot>
                                   </table>  
                            </div>
                       </div>
                   </div>
               </div>
               <!--End row-->

        <!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>	
		<%-- <%@ include file="common/accountFooter.jsp"%> --%>
         <!--End footer -->
       </div>
      <!--End main content -->
</body>
</html>
