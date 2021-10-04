<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/accountsettings.jsp"%>     
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>우여곡절 - 계좌조회 </title>
</head>

<body class="sticky-header">

    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start -->
		<%@ include file="common/accountDetailHeader.jsp"%>    
        <!-- header section end-->


        <!--body wrapper start-->
        <div class="wrapper">
              
          <!--Start Page Title-->
           <div class="page-title-box">
                <h4 class="page-title">
              ${dto.name}거래내역</h4>
                <ol class="breadcrumb">
             <!--        <li>
                        <a href="#">급여통장</a>
                    </li>
                    <li>
                        <a href="#">거래처통장</a>
                    </li>
                    <li class="active">
                        <a href="#">통장목록</a>
                    </li> -->
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
							<table id="example" class="table table table-hover m-0">
								<!-- display table  -->
								<thead>
									<tr>
										<th>통장별칭</th>
										<th>거래일자</th>
										<th>거래시간</th>
										<th>은행</th>
										<th>계좌번호</th>
										<th>적요</th>
										<th>유형</th>
										<th>입금</th>
										<th>출금</th>
										<th>잔액
											<script type="text/javascript">
												var result= 1 + 1;
												document.write(result);
											</script>
										</th>
									</tr>
								</thead>
								<tbody>
										
										<!-- 입금시 금액 / 출금시 금액  -->	
										<c:set var="deposit" value="입금"/>
										<c:set var="withdraw" value="출금"/>
										<c:forEach var="dto" items="${dtos}">
											<tr>
												<td>${dto.account_name}</td>
												<td>${dto.transaction_date}</td>
												<td>${dto.transaction_date}</td>
												<td>${dto.account_bank}</td>
												<td>${dto.account_number}</td>
												<td>${dto.abs}</td>
												<td>${dto.type}
												</td>
												
												<!-- 자료형 CHARR10이라 EL태그 비교문이 먹지를않음 varchar10으로수정함   -->
												
													<c:if test="${dto.type eq deposit}">
														<c:set var="deposit_balance" value="${dto.current_balance}"/>
														<td>
															<fmt:formatNumber value="${deposit_balance}" pattern="###,###,###,###"/>
														</td>
													</c:if>
													
													<c:if test="${dto.type ne deposit}">
														<td>
														-
														</td>
													</c:if>
												
													<c:if test="${dto.type eq withdraw}">
														<c:set var="withdraw_balance" value="${dto.current_balance}"/>
														<td>
															<fmt:formatNumber value="${withdraw_balance}" pattern="###,###,###,###"/>
														</td>	
													</c:if>
													
													<c:if test="${dto.type ne withdraw}">
														<td>
														-
														</td>	
													</c:if>
												
												<!-- 잔액계산  -->
												<!--  
													입금시 금액 - 출금시 금액 = 잔액
													잔액있을시 
													잔액 = 기존잔액 + 입금액  or 잔액 = 기존잔액 - 출금액   (차대변 상계)
												-->
											<td>
												<fmt:formatNumber value="${dto.next_balance}" pattern="###,###,###,###"/>
											</td>
										</tr>
										</c:forEach>
								</tbody>
							</table>
						</div>
                       </div>
                   </div>
               <!--End row-->
			    </div>
        <!-- End Wrapper-->
			</div>
        <!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>	
         <!--End footer -->

       </div>
      <!--End main content -->

</body>

</html>
