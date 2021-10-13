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
<title>회계관리 - 일반전표</title>
</head>
<body class="sticky-header">

	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->


	<!-- main content start-->
	<div class="main-content">

		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		<%@ include file="common/accountHeader.jsp"%>
		<!-- header section end-->

		<!--body wrapper start-->
		<div class="wrapper">
		
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">전표입력/장부관리</h4>
				<ol class="breadcrumb">
					<li><a href="#">승인전표 목록</a></li>
					<li><a href="#" id="alerttest">미승인전표 목록</a> 
					</li>
					<!--  <li class="active">
                        Data Table
                    </li> -->
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
							<li class="active"><a href="${ROOT_PATH}/account/slipDetail">회계지출결의
									</a></li>
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
										<input type="hidden" id="root" value="${ROOT_PATH}">
										<tr>
											<td>
												<input type="checkbox" id="slipid_chk" name="slipid_chk" value="${dto.id}" 
													onclick="checkbox_slipId(this)">
											</td>
											<td>
												<a href="#" id="selectSlipInfo" onclick="slip_Id(${dto.id})">${dto.id}</a>
											</td>
											<td>
												<c:choose>
													<c:when test="${dto.type == 'DEPOSIT'}">
													<span  class="deposit">입금</span>
													</c:when>
													<c:when test="${dto.type == 'WITHDRAW'}">
													<span  class="withdraw">출금</span>
													</c:when>
													<c:when test="${dto.type == 'GENERAL'}">
													<span  class="general">일반</span>
													</c:when>
												</c:choose>
											
											</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
													value="${dto.register_date}" /></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
													value="${dto.update_date}" /></td>
											
											<!-- 전표 승인 여부 확인 -->
											<td><c:choose>
													<c:when test="${dto.state eq 'Y'}">
														<span class="confirm">승인</span>
													</c:when>
													<c:when test="${dto.state eq 'N'}">
														<span>미승인</span>
													</c:when>
												</c:choose></td>

											<td><c:choose>
													<c:when test="${dto.department_id == 1}">
	                                        			인사팀
	                                        			</c:when>
													<c:when test="${dto.department_id == 2}">
	                                        			개발팀
	                                        			</c:when>
													<c:when test="${dto.department_id == 100}">
	                                        			인사팀
	                                        			</c:when>
													<c:when test="${dto.department_id == 200}">
	                                        			회계팀
	                                        			</c:when>
													<c:when test="${dto.department_id == 300}">
	                                        			영업팀
	                                        			</c:when>
													<c:when test="${dto.department_id == 400}">
	                                        			구매팀
	                                        			</c:when>
													<c:when test="${dto.department_id == 500}">
	                                        			물류팀
	                                        			</c:when>
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						             <div class="form-group">
                            <div class="col-md-8 col-md-offset-3">
                              <button class="btn  btn-primary" id="sa-warning" type="submit">부서별 전표 승인</button>
                            </div>
                          </div>
					</div>
				</div>
			</div>
			             
			</form>
			<!--End row-->
<!-- 	
			Start row
			<div class="row">
				<div class="col-md-12">
					<div class="white-box" id="datatables">
						<h2 class="header-title">전표 상세정보</h2> 
						<h3 class="header-title">전표번호 : 11111 (주문번호 : 22222)</h3>
						<div class="table-responsive">
							<table id="slipInfo" class="table table table-hover m-0">
								<thead>
									<tr class="slip_defail">
										<th>담당 부서 :</th>
										<th>담당자 : </th>
										<th colspan="3">담당자 연락처 :</th>
									</tr>
									
									<tr class="slip_defail">
										<th>주문일자 : </th>
										<th>요청일자 : </th>
										<th>거래처명 : </th>
										<th>사업자번호 : </th>
										<th>연락처 : </th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>상품명</td>
										<td>상품종류</td>
										<td>판매단가</td>
										<td>수량</td>
										<td>공급가액</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<td>ㅇ</td>
										<td>ㅇ</td>
										<td>ㅇ</td>
										<td>ㅇ</td>
										<td>ㅇ</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
			End row

 -->		</div>
		<!-- End Wrapper-->
		
		<!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>
		<%@ include file="common/accountFooter.jsp" %>
		<!--End footer -->
	</div>
	<!--End main content -->

</body>

</html>
