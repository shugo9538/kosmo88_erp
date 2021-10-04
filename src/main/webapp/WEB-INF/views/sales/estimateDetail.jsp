<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">견 적 서</h2>
                
                
                <form class="js-validation-bootstrap form-horizontal ">
                	<input type="hidden" id="request_id" value="${dto.request_id}">
                	
	                <table id="example" class="display table mt-12">
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">견적서 번호</th>
	                		<td style="padding:10px;">${dto.request_id}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">요청일자</th>
	                		<td style="padding:10px;">
	                			<fmt:formatDate value="${dto.begin_date}" pattern="yyyy-MM-dd HH:mm" />
	                		</td>
	                	</tr>
	                	
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">거래처명</th>
	                		<td style="padding:10px;">${dto.client_name}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">대표자</th>
	                		<td style="padding:10px;">${dto.client_ceo_name}</td>
	                	</tr>
	                		
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">거래처 연락처</th>
	                		<td style="padding:10px;">${dto.client_phone}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">거래처 이메일</th>
	                		<td style="padding:10px;">${dto.client_email}</td>
	                	</tr>
	                	
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자</th>
	                		<td style="padding:10px;">${dto.employee_name}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자 부서</th>
	                		<td style="padding:10px;">${dto.department_name}</td>
	                	</tr>
	                	
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자 연락처</th>
	                		<td style="padding:10px;">${dto.employee_phone}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자 이메일</th>
	                		<td style="padding:10px;">${dto.employee_email}</td>
	                	</tr>	
	                </table>
	                
	                <c:set var="totalPrice" value="0" />
	                <h2 style="font-size:18px; text-align:left;" class="header-title col-md-12 mt-12"></h2>
	                
	                <table id="example" class="display table ">
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">상품명</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">상품종류</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">판매단가</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">수량</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">공급가액</th>
	                	</tr>
<<<<<<< HEAD
	                	<c:forEach var="dto" items="${dto}">
	                	<c:set var="sale_price" value="${dto.item_sales_price * idto.item_quantity}" />
	                		<td>${dto.item_name}</td>
	                		<td>${dto.item_category}</td>
	                		<td>
	                			<fmt:formatNumber value="${dto.item_sales_price}" pattern="#,###" />원
	                		</td>
	                		<td>${dto.item_quantity}</td>
	                		<%-- <td>
	                			<fmt:formatNumber value="${dto.item_sales_price}" pattern="#,###" />원
	                		</td> --%>
	                		<%-- <c:set var="totalPrice" value="${totalPrice + price}" /> --%>
	                	</c:forEach>
	                </table>
	                <div style="text-align:right;" class="form-group col-md-12">
	                	<%-- <h3>TOTAL : <fmt:formatNumber value="${totalPrice}" pattern="#,###" />원</h3> --%>
=======
	                	<c:forEach var="idto" items="${idtos}">
	                	<c:set var="price" value="${idto.item_purchase_price * idto.item_quantity}" />
	                		<td>${idto.item_name}</td>
	                		<td>${idto.item_category}</td>
	                		<td>
	                			<fmt:formatNumber value="${idto.item_purchase_price}" pattern="#,###" />원
	                		</td>
	                		<td>${idto.item_quantity}</td>
	                		<td>
	                			<fmt:formatNumber value="${price}" pattern="#,###" />원
	                		</td>
	                		<c:set var="totalPrice" value="${totalPrice + price}" />
	                	</c:forEach>
	                </table>
	                <div style="text-align:right;" class="form-group col-md-12">
	                	<h3>TOTAL : <fmt:formatNumber value="${totalPrice}" pattern="#,###" />원</h3>
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
                    </div>
	                <div style="text-align:center;" class="form-group mt-5 col-md-12">
	                    <input class="btn  btn-primary" type="button" value="삭제" 
	                    	onclick="estimateDelete();"/>
	                    <input class="btn  btn-defalte" type="button" value="닫기"
	                    	onclick="window.close();"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end row -->
    <script src="${RESOURCES_PATH}/sales/js/estimateDetail.js"></script>
</div>
</body>
</html>