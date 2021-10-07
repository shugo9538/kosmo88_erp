<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<%@ include file="./js_purchase.jsp"%>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">견적서 목록</h2>
                
                
                <form class="js-validation-bootstrap form-horizontal ">
	                <table id="example" class="display table">
                                <thead>
                                    <tr>
                                        <th></th>			<!-- client_email  -->
                                        <th></th> 			<!-- client_zip_code -->
                                        <th></th> 			<!-- client_address -->
                                        <th></th> 			<!-- client_detail_address -->
	                                    <th>견적번호</th> 		<!-- request_id  pk -->
                                        <th>거래처</th>		<!-- client_name  -->
                                        <th>거래처대표자</th>  <!-- client_ceo_name  -->
                                        <th>거래처 연락처</th>  <!-- client_phone  -->
                                        <th>담당자</th>		<!-- employee_name  -->
                                        <th>주문일자</th> 	 	<!-- begin_date  -->
                                        <th>선택</th>
                                        <th></th>           <!-- employee_id -->
                                        <th></th> 			<!-- employee_phone -->
                                        <th></th> 			<!-- employee_email -->
                                        <th></th> 			<!-- department_id -->
                                        <th></th>			<!-- department_name -->
                                        <th></th>			<!-- client_id -->
                                    </tr>
                                </thead>
                                <tbody>
                                <!-- 등록된 견적서가 있는 경우 -->
                                <c:if test="${cnt != 0}">
                                	<c:forEach var="dto" items="${dtos}">
                                		<tr>
                                			<td><input type="hidden" id="client_email" value="${dto.client_email}"></td>
                                			<td><input type="hidden" id="client_zip_code" value="${dto.client_zip_code}"></td>
                                			<td><input type="hidden" id="client_address" value="${dto.client_address}"></td>
                                			<td><input type="hidden" id="client_detail_address" value="${dto.client_detail_address}"></td>
                                			<td><input style="border:none;" type="text" id="request_id" value="${dto.request_id}"></td>
	                                        <th><input style="border:none;" type="text" id="client_name" value="${dto.client_name}" readonly></th>
	                                        <td><input style="border:none;" type="text" id="client_ceo_name" value="${dto.client_ceo_name}" readonly></td>
	                                        <td><input style="border:none;" type="text" id="client_phone" value="${dto.client_phone}" readonly></td>
	                                        <td><input style="border:none;" type="text" id="employee_name" value="${dto.employee_name}" readonly></td>
	                                        <td><fmt:formatDate value="${dto.begin_date}" pattern="yy년 MM월 dd일" /><input type="hidden" id="begin_date" value="${dto.begin_date}"></td>
	                                        <td><input class="btn  btn-primary" type="button" id="select" name="${dto.request_id}" value="선택"></td>
	                                        <td><input type="hidden" id="employee_id" value="${dto.employee_id}"></td>
	                                        <td><input type="hidden" id="employee_phone" value="${dto.employee_phone}"></td>
                                			<td><input type="hidden" id="employee_email" value="${dto.employee_email}"></td>
                                			<td><input type="hidden" id="department_id" value="${dto.department_id}"></td>
                                			<td><input type="hidden" id="department_name" value="${dto.department_name}"></td>
                                			<td><input type="hidden" id="client_id" value="${dto.client_id}"></td>
	                                    </tr>
                                	</c:forEach>
                                </c:if>
                                <!-- 등록된 견적서가 없는 경우 -->
                                <c:if test="${cnt == 0}">
                                	<tr>
                                		<td colspan="14">
                                			등록된 견적서가 없습니다.
                                		</td>
                                	</tr>
                                </c:if>
                           </tbody>
                       </table>
                       <div style="text-align:center;" class="form-group mt-5 col-md-12">
                            <input class="btn  btn-primary" type="button" value="닫기"
                            	onclick="window.close();"/>
                   	 </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end row -->
</div>
	
	<script src="${RESOURCES_PATH}/purchase/js/selectEstimate.js"></script>
</body>
</html>