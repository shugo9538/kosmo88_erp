<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>

<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">거래처 관리</h4>
				<ol class="breadcrumb">
					<li class="active">거래처 관리</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/purchase/clientRegister">거래처 등록</a></li>
				<!-- <li class="active"><a href="${ROOT_PATH}/purchase/clientChoiceDelete">거래처 삭제</a></li>  -->
			</ul>
			
         <!--Start row-->
         <div class="row">
             <div class="col-md-12">
             	<!-- Start white-box -->
                 <div class="white-box">
                     <h2 class="header-title">
                     	<i class="fa fa-chevron-circle-right mr-2"></i>
                     	거래처 전체 목록</h2>
                     <div class="table-responsive">
                    	 <div class="col-md-2 mt-1 mb-4">
							<input class="btn btn-default" type="button" id="delButton" name="delButton" value="거래처 삭제">
						 </div>
                     	
                         <table id="example" class="display table">
                             <thead>
                                 <tr>
                                     <td style="text-align:center">
                                         <input type="checkbox" id="checkAll" name="checkAll" id="select">
                                     </td>
                                     <th>회사명</th>
                                     <th>사업자번호</th>
                                     <th>대표자명</th>
                                     <th>전화번호</th>
                                     <th>주소</th>
                                     <th>등록일</th>
                                 </tr>
                             </thead>
                             <tbody>
                             	 <!-- 거래처가 있으면 -->
                             	 <c:if test="${cnt > 0}">
                             	 	<c:forEach var="dto" items="${dtos}">
                             	 		<tr>
		                                    <th style="text-align:center">
		                                        <input type="checkbox" class="client_id" name="client_id" value="${dto.id}"> <!-- client id -->
		                                    </th>
		                                    <td><a href="${ROOT_PATH}/purchase/clientDetail?id=${dto.id}">${dto.name}</a></td>
		                             	 	<td>
		                             	 		${fn:substring(dto.register_num,0,3)} -
		                             	 		${fn:substring(dto.register_num,3,5)} - 
		                             	 		${fn:substring(dto.register_num,5,10)}
		                             	 	</td>
		                             	 	<td>${dto.ceo_name}</td>
		                             	 	<td>
		                             	 		${fn:substring(dto.phone,0,3)} -
		                             	 		${fn:substring(dto.phone,3,7)} -
		                             	 		${fn:substring(dto.phone,7,10)}
		                             	 	</td>
		                             	 	<td>${dto.address}</td>
		                             	 	<td>
		                             	 		<fmt:formatDate value="${dto.register_date}" pattern="yyyy-MM-dd hh:mm:ss" />
		                             	 	</td>
	                             		</tr>	 
                             	 	</c:forEach>
                             	 </c:if>
                             	 
                             	 <!-- 거래처가 없으면 -->
                             	 <c:if test="${cnt == 0}">
                             	 	<tr>
										<td colspan="7" align="center">
											등록한 거래처가 없습니다. 거래처를 등록해주세요!!
										</td>
									</tr>
                             	 </c:if>
                             	 
                             </tbody>
                         </table>
                     </div>
                 </div>
               </div>
             </div>
             <!--End row-->
		</div>
		<!-- End Wrapper-->
		
		<%@ include file="../common/footer.jsp"%>
		<script src="${RESOURCES_PATH}/purchase/js/clientManagement.js"></script>
</body>
</html>