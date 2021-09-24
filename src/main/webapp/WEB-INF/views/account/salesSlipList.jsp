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
                <h2 class="page-title">매입/매출장 목록</h2>
                <ol class="breadcrumb">
                  <%--   <li>
                        <a href="${ROOT_PATH}/account/purchaseList">매입목록</a>
                    </li>
                    <li>
                        <a href="${ROOT_PATH}/account/salesList">매출목록</a>
                    </li> --%>
                   <!--  <li class="active">
                        Responsive Table
                    </li> -->
                </ol>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->  
           
               <!-- Start responsive Table-->
                <div class="col-md-12">
           	   <!-- 메뉴버튼 -->
                            	<div>
			        <ul class="nav nav-pills custom-nav">
						<li class="active"><a href="${ROOT_PATH}/account/purchaseList">매입
								목록</a></li>
						<li class="active"><a href="${ROOT_PATH}/account/salesList">매출
								목록</a></li>
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
                       <div class="white-box">
                            <div class="col-md-8">
                             <h2 class="header-title">일자 검색</h2>
                         	    <form action="#" class="form-horizontal">
                                <div class="form-group">
                                    <label class="control-label col-md-4">Default Functionality</label>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="mm/dd/yyyy" id="datepicker">
                                            <span class="input-group-addon b-0 text-white"><i class="icon-calender"></i></span>
                                        </div> 
                                    </div>
                                </div>
			                                		
                            <div class="form-group">
                                <label class="control-label col-md-4">검색 일자</label>
                                <div class="col-md-8">
                                    <div class="input-daterange input-group" id="date-range">
                                        <input type="text" class="form-control" name="start" />
                                        <span class="input-group-addon no-border text-white">to</span>
                                        <input type="text" class="form-control" name="end" />
                                    </div>
                                </div>
                            </div>
						</form>
                            </div>
                       </div>
                    </div>
                </div>
                <!--End row-->
	                    
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
                                            <td>외상매출금</td>
                                            <td>상품매출</td>
                                            <td>22222</td>
                                        </tr>
                                        <tr>
                                            <td>2021-02-01</td>
                                            <td>50002</td>
                                            <td>00106</td>
                                            <td>(주)영진전자</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>5,000,000</td>
                                            <td>500,000</td>
                                            <td>5,500,000</td>
                                            <td>외상매출금</td>
                                            <td>상품매출</td>
                                            <td>22222</td>
                                        </tr>
                                        <tr>
                                            <td>2021-03-01</td>
                                            <td>50003</td>
                                            <td>00107</td>
                                            <td>(주)수정상사</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>1,000,000</td>
                                            <td>100,000</td>
                                            <td>1,100,000</td>
                                            <td>외상매출금</td>
                                            <td>상품매출</td>
                                            <td>22222</td>
                                        </tr>
                                        <tr>
                                            <td>2021-04-01</td>
                                            <td>50004</td>
                                            <td>00110</td>
                                            <td>(주)영훈통상</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>50,000,000</td>
                                            <td>5,000,000</td>
                                            <td>55,000,000</td>
                                            <td>외상매출금</td>
                                            <td>상품매출</td>
                                            <td>22222</td>
                                        </tr>
                                        <tr>
                                            <td>2021-05-01</td>
                                            <td>50005</td>
                                            <td>00105</td>
                                            <td>(주)오리온</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>700,000</td>
                                            <td>70,000</td>
                                            <td>770,000</td>
                                            <td>외상매입금</td>
                                            <td>상품매입</td>
                                            <td>22222</td>
                                        </tr>
                                        <tr>
                                            <td>2021-06-01</td>
                                            <td>50006</td>
                                            <td>00105</td>
                                            <td>(주)오뚜기</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>6,000,000</td>
                                            <td>600,000</td>
                                            <td>6,600,000</td>
                                            <td>외상매입금</td>
                                            <td>상품매입</td>
                                            <td>22222</td>
                                        </tr>
                                        <tr>
                                            <td>2021-07-01</td>
                                            <td>50001</td>
                                            <td>00105</td>
                                            <td>(주)파라메터</td>
                                            <td>119-811-4210</td>
                                            <td>상품</td>
                                            <td>8,000,000</td>
                                            <td>800,000</td>
                                            <td>8,800,000</td>
                                            <td>외상매입금</td>
                                            <td>상품매입</td>
                                            <td>22222</td>
                                        </tr>                                                                                                                                                                                                        
                                    <!-- 등록 매출/매입전표가 있는경우 -->                     
                                    <c:if test="${cnt > 0}">
                                    	<c:forEach var="dto" items="${saleslip}">
   											<tr>
   												<td>${number}
   													<c:set var="number" value="${number -1 }"/>
   												</td>
                                        		<td>${dto.id}</td>
                                        		<td>${dto.account_title}</td>
                                        		<td>${dto.supply_amount}</td>
                                        		<td>${dto.tax_amount}</td>
                                        		<td>${dto.type}</td>
                                        		<td>${dto.Abstract}</td>
                                        		<td>${dto.slip_id}</td>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                     </c:if>

                                     <!-- 등록 매출/매입전표가 없는경우 -->
                                    <%--  <c:if test="${cnt == 0}">
                                     	<tr>
                                     		<td colspan="8" align="center">
                                     			<span style="color:red"> 등록된 전표가 없습니다. </span>
                                     		</td>
                                     	</tr>
                                     </c:if>  --%>  
                                    </tbody>
                                    
                                    <tfoot>
                                    <!-- 등록 매출/매입전표가 있는경우 --> 
                                     <c:if test="${cnt > 0}">
                                     <tr>
                                     	<th colspan="8">
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
                                        <tr style="background-color:ghostwhite; font-weight: bold;">
                                            <td colspan="5" align="center">합계</td>
                                            <td>7건 (매수 7매)</td>
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
