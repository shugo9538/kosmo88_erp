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
  <title> 회계관리 - 일반전표</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
                <h4 class="page-title">  전표입력/장부관리 </h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">승인전표 목록</a>
                    </li>
                    <li>
                        <a href="#">미승인전표 목록</a>
                    </li>
                   <!--  <li class="active">
                        Data Table
                    </li> -->
<<<<<<< HEAD
                </ol>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->          
           
               <!--Start row-->
               <div class="row">
                   <div class="col-md-12">
       				<!-- 메뉴버튼 -->
                    <div>
				        <ul class="nav nav-pills custom-nav">
							<li class="active"><a href="${ROOT_PATH}/account/slipDetail">일반전표 등록</a></li>
							<li class="active"><a href="${ROOT_PATH}/account/slipModify">일반전표 수정</a></li>
						</ul>
                 	</div>
      	 			 <!-- 메뉴버튼 끝 -->  
                       <div class="white-box">
                           <h2 class="header-title">일반전표 목록
                             ( 구매 영업에서 세부내용 오면 뿌릴 항목 추가해야함)
                           </h2>
                            <div class="table-responsive">
                             <table id="example" class="table table table-hover m-0">
                                    <thead>
                                        <tr>
                                            <!-- <th>순서</th> -->
                                            <th>전표번호</th>
                                            <th>유형</th>
                                            <th>발행일</th>
                                            <th>승인일자(notnull바꿔야함)</th>
                                            <th>전표승인상태(Y/N)</th>
                                            <th>부서코드</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <!-- 등록전표가 있는 경우 -->                     
                                    <c:if test="${cnt > 0}">
                                    	<c:forEach var="dto" items="${slip}">
   											<tr>
   											<%-- 	<td>${number}
   													<c:set var="number" value="${number -1 }"/>
   												</td> --%>
                                        		<td>${dto.id}</td>
                                        		<td>${dto.type}</td>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.register_date}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.update_date}"/>
                                        		</td>
                                        		<!-- 전표 승인 여부 확인 -->
                                        		<td>
                                       				<c:choose>
                                       					<c:when test="${dto.state eq 'Y'}">
                                       						<span style="color:red">승인</span>
                                       					</c:when>
                                       					<c:when test="${dto.state eq 'N'}">
                                       						<span>미승인</span>
                                       					</c:when>
                                       				</c:choose>
                                        		</td>
                                        		
                                        		<td>
	                                        		<c:choose>
	                                        			<c:when test="${dto.department_id == 1}">
=======
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
		<form  action="${ROOT_PATH}/account/slipConfirmAction" method="post" id="slipFrom" name="slipFrom" onsubmit="return slipCheck()">
				<input type="hidden" id="root" value="${ROOT_PATH}">
				<!-- _csrf TOKEN  -->
				<sec:csrfInput/>
			
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<!-- 메뉴버튼 -->
					<div>
						<ul class="nav nav-pills custom-nav">
							<%-- <li class="active"><a href="${ROOT_PATH}/account/slipDetail">일반전표
									등록</a></li>
							<li class="active"><a href="${ROOT_PATH}/account/slipModify">일반전표
									수정</a></li> --%>
							<!-- <li class="active"><a href="#">부서별 전표 승인</a></li> -->
						</ul>
					</div>
					<!-- 메뉴버튼 끝 -->
					<div class="white-box">
						<h2 class="header-title">일반전표 목록</h2>
						<div class="table-responsive">
							<table id="example" class="table table table-hover m-0">
								<thead>
									<tr>
										<th></th>
										<th>전표번호</th>
										<th>유형</th>
										<th>발행일</th>
										<th>승인일자</th>
										<th>전표승인상태</th>
										<th>부서코드</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="dto" items="${slip}">
										<input type="hidden" name="slip_id" ${dto.id}/>
									
										<tr>
											<td>
												<input type="checkbox" id="slipid_chk" name="slipid_chk" value="${dto.id}" 
													onclick="checkbox_slipId(this)">
											</td>
											<td>
											<%-- <a href="${ROOT_PATH}/account/slipModifyDetail?id=${dto.id}">
												${dto.id}</a> --%>
											${dto.id}
											</td>
											<td>${dto.type}</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
													value="${dto.register_date}" /></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
													value="${dto.update_date}" /></td>
											<!-- 전표 승인 여부 확인 -->
											<td><c:choose>
													<c:when test="${dto.state eq 'Y'}">
														<span style="color: red">승인</span>
													</c:when>
													<c:when test="${dto.state eq 'N'}">
														<span>미승인</span>
													</c:when>
												</c:choose></td>

											<td><c:choose>
													<c:when test="${dto.department_id == 1}">
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
	                                        			인사팀
	                                        			</c:when>
	                                        			<c:when test="${dto.department_id == 2}">
	                                        			개발팀
	                                        			</c:when>
<<<<<<< HEAD
	                                        		</c:choose>
                                        		</td>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                     </c:if>

                                     <!-- 등록 전표가 없는경우 -->
                                  <c:if test="${cnt == 0}">
                                     	<tr>
                                     		<td colspan="7" align="center">
                                     			<span style="color:red"> 등록된 전표가 없습니다. </span>
                                     		</td>
                                     	</tr>
                                     </c:if> 
                                    </tbody>
                                    
                                    <tfoot>
                                    <!-- 등록거래처가 있는경우 --> 
                                     <c:if test="${cnt > 0}">
                                     <tr>
                                     	<th colspan="8">
                                     	<!-- 맨처음[◀◀] / 이전블럭[◀]  -->
                                     	<c:if test="${startPage > pageBlock}">
                                     		<a href="${ROOT_PATH}/account/slipList?categoryNum=120" style="color:block">[◀◀]</a>
                                     		<a href="${ROOT_PATH}/account/slipList?categoryNum=120&pageNum=${startPage-pageBlock}" style="color:block">[◀]</a>
                                     	</c:if>
                                     	
                                     	<c:forEach var="i" begin="${startPage}" end="${endPage}">
                                     		<c:if test="${i == currengPage}">
                                     			<span><b>[${i}]</b></span>
                                     		</c:if>
                                     		<c:if test="${i != currengPage}">
                                     			<a href="${ROOT_PATH}/account/slipList?categoryNum=120&pageNum=${i}">[${i}]</a>
                                     		</c:if>
                                     	</c:forEach>
                                     	<!-- 다음블록[▶▶] / 맨마지막블럭[▶]  -->
                                     	<c:if test="${pageCount > endPage}">
                                     		<a href="${ROOT_PATH}/account/slipList?categoryNum=120&pageNum=${startPage + pageBlock}">[▶]</a>
                                     		<a href="${ROOT_PATH}/account/slipList?categoryNum=120&pageNum=${pageCount}">[▶▶]</a>
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
               
              <!--Start row-->
               <div class="row">
                   <div class="col-md-12">
                       <div class="white-box">
                       <h2 class="header-title">전표번호 : 11111</h2>
                            <div class="table-responsive">
                             <table id="example" class="table table table-hover m-0">
                                    <thead>
                                        <tr>
                                            <th>순번</th>
                                            <th>구분</th>
                                            <th>코드</th>
                                            <th>계정과목</th>
                                            <th>거래처코드</th>
                                            <th>거래처명</th>
                                            <th>사업자번호</th>
                                            <th>금액</th>
                                            <th>적요명</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                    	<td>1</td>
                                    	<td>차변</td>
                                    	<td>81900</td>
                                    	<td>지급임차료</td>
                                    	<td>00095</td>
                                    	<td>한국렌트카(주)</td>
                                    	<td>666-81-12343</td>
                                    	<td>5,000,000</td>
                                    	<td>일반매입</td>
                                    	<td></td>
                                    </tr>
                                    <tr>
                                    	<td>2</td>
                                    	<td>대변</td>
                                    	<td>13500</td>
                                    	<td>부가세대급금</td>
                                    	<td>00095</td>
                                    	<td>한국렌트카(주)</td>
                                    	<td>666-81-12343</td>
                                    	<td>500,0000</td>
                                    	<td>매입부가세</td>
                                    </tr>
                                    <tr>
                                    	<td>3</td>
                                    	<td>대변</td>
                                    	<td>25100</td>
                                    	<td>외상매입금</td>
                                    	<td>00095</td>
                                    	<td>한국렌트카(주)</td>
                                    	<td>666-81-12343</td>
                                    	<td>5,500,000</td>
                                    	<td>외상매입금 발생</td>
                                    	<td></td>
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
=======
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						             <div class="form-group">
                            <div class="col-md-8 col-md-offset-3">
                              <button class="btn  btn-primary" type="submit">부서별 전표 승인</button>
                            </div>
                          </div>
					</div>
				</div>
			</div>
			             
			</form>
			<!--End row-->
	
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<h2 class="header-title">전표번호 : 11111</h2>
						<div class="table-responsive">
							<table id="example" class="table table table-hover m-0">
								<thead>
									<tr>
										<th>순번</th>
										<th>구분</th>
										<th>코드</th>
										<th>계정과목</th>
										<th>거래처코드</th>
										<th>거래처명</th>
										<th>사업자번호</th>
										<th>금액</th>
										<th>적요명</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>차변</td>
										<td>81900</td>
										<td>지급임차료</td>
										<td>00095</td>
										<td>한국렌트카(주)</td>
										<td>666-81-12343</td>
										<td>5,000,000</td>
										<td>일반매입</td>
										<td></td>
									</tr>
									<tr>
										<td>2</td>
										<td>대변</td>
										<td>13500</td>
										<td>부가세대급금</td>
										<td>00095</td>
										<td>한국렌트카(주)</td>
										<td>666-81-12343</td>
										<td>500,0000</td>
										<td>매입부가세</td>
									</tr>
									<tr>
										<td>3</td>
										<td>대변</td>
										<td>25100</td>
										<td>외상매입금</td>
										<td>00095</td>
										<td>한국렌트카(주)</td>
										<td>666-81-12343</td>
										<td>5,500,000</td>
										<td>외상매입금 발생</td>
										<td></td>
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
		<%@ include file="common/accountFooter.jsp" %>
		<!--End footer -->
	</div>
	<!--End main content -->
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0

</body>

</html>
