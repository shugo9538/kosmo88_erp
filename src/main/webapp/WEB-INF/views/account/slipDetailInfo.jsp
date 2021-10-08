<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
            
           <!-- 구매/물류팀 -->
             <c:if test="${dept_id == 300 || dept_id == 400}"> 
              <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">전표정보</h2>
                <form class="js-validation-bootstrap form-horizontal ">
                	<input type="hidden" id="request_id" value="${dto.request_id}">
                	
	                <table id="example" class="display table mt-12">
	                		<c:forEach var="dto" items="#{slip}" begin="1" end="1"> 
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">요청코드</th>
	                		<td style="padding:10px;">${dto.request_id}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">부서명</th>
	                		<td style="padding:10px;"> ${dto.department_name}</td>
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
	                	</c:forEach>
	                </table>
	                
	                <h2 style="font-size:18px; text-align:left;" class="header-title col-md-12 mt-12"></h2>
	               
	                <c:set var="totalPrice" value="0" />
	                <c:set var="total" value="0"/>
	                <table id="example" class="display table ">
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">상품명</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">수량</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">단가</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">공급가액</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">세액</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">합계금액</th>
	                	</tr>
	                	<c:forEach var="idto" items="${slipList}">
	                	<tr>
	                		<td>${idto.item_name}</td>
	                		<td>${idto.quantity}</td>
	                		<td>${idto.purchase_price}</td>
	                		<td>${idto.sum_supply}</td>
	                		<td>${idto.sum_tax}</td>
	                		<td>${idto.sum_total}</td>
	                		<c:set var="totalPrice" value="${idto.sum_total + totalPrice}"/>
	                	</c:forEach>
	                </table>
	                <div style="text-align:right;" class="form-group col-md-12">
	                	<h3>TOTAL : <fmt:formatNumber value="${totalPrice}" pattern="#,###" />원</h3>
                    </div>
	                <div style="text-align:center;" class="form-group mt-5 col-md-12">
	                    <input class="btn  btn-primary" type="button" value="닫기" 
	                    	onclick="window.close();"/>
	                  <!--   <input class="btn  btn-defalte" type="button" value="닫기"
	                    	onclick="window.close();"/> -->
                    </div>
                </form>
                </c:if>
                
                <!-- 인사팀 -->
              <c:if test="${dept_id == 1}"> 
              <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">급여이체 정보</h2>
                <form class="js-validation-bootstrap form-horizontal ">
                	<input type="hidden" id="request_id" value="${dto.request_id}">
                	
	                <table id="example" class="display table mt-12">
	                		<%-- <c:forEach var="dto" items="#{slip}" begin="1" end="1">  --%>
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">사진</th>
	                		<td style="padding:10px;">${dto.request_id}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">사번</th>
	                		<td style="padding:10px;"> ${dto.department_name}</td>
	                	</tr>
	                	
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">거래처명</th>
	                		<td style="padding:10px;">${dto.client_name}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">직원명</th>
	                		<td style="padding:10px;">${dto.client_ceo_name}</td>
	                	</tr>
	                		
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">거래처 연락처</th>
	                		<td style="padding:10px;">${dto.client_phone}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">직원이메일</th>
	                		<td style="padding:10px;">${dto.client_email}</td>
	                	</tr>
	                	
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">이름</th>
	                		<td style="padding:10px;">${dto.employee_name}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">담당자 부서</th>
	                		<td style="padding:10px;">${dto.department_name}</td>
	                	</tr>
	                	
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">입사일</th>
	                		<td style="padding:10px;">${dto.employee_phone}</td>
	                		<th style="background-color: #f1f1f1; padding:10px;">직원 이메일</th>
	                		<td style="padding:10px;">${dto.employee_email}</td>
	                	</tr>
	                	<%-- </c:forEach> --%>
	                </table>
	                
	                <h2 style="font-size:18px; text-align:left;" class="header-title col-md-12 mt-12"></h2>
	               
	                <c:set var="totalPrice" value="0" />
	                <c:set var="total" value="0"/>
	                <table id="example" class="display table ">
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:10px;">상품명</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">수량</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">단가</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">공급가액</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">세액</th>
	                		<th style="background-color: #f1f1f1; padding:10px;">합계금액</th>
	                	</tr>
	                	<c:forEach var="idto" items="${slipList}">
	                	<tr>
	                		<td>${idto.item_name}</td>
	                		<td>${idto.quantity}</td>
	                		<td>
	                			<fmt:formatNumber value="${idto.purchase_price}" pattern="#,###"/>
	                		</td>
	                		<td>
	                			<fmt:formatNumber value="${idto.sum_supply}" pattern="#,###"></fmt:formatNumber>
	                		</td>
	                		<td>${idto.sum_tax}</td>
	                		<td>${idto.sum_total}</td>
	                		<c:set var="totalPrice" value="${idto.sum_total + totalPrice}"/>
	                	</c:forEach>
	                </table>
	                <div style="text-align:right;" class="form-group col-md-12">
	                	<h3>TOTAL : <fmt:formatNumber value="${totalPrice}" pattern="#,###" />원</h3>
                    </div>
	                <div style="text-align:center;" class="form-group mt-5 col-md-12">
	                    <input class="btn  btn-primary" type="button" value="닫기" 
	                    	onclick="window.close();"/>
	                  <!--   <input class="btn  btn-defalte" type="button" value="닫기"
	                    	onclick="window.close();"/> -->
                    </div>
                </form>
                </c:if>
            </div>
        </div>
    </div>
    <!-- end row -->
</div>
</body>
</html>