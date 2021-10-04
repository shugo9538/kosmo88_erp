<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">${dto.name}</h2>
                <div class="form-group">
                </div>
                
                <form class="form-horizontal" name="clientUpdateForm" action="clientUpdateAction" 
                	method="post">
                	<sec:csrfInput />
                	
                    <input type="hidden" name="pageNum" value="${pageNum }">
                    <input type="hidden" name="name" value="${dto.name}">
                    
                    <table id="example" class="display table mt-12">
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">거래처 번호</th>
	                		<td style="padding:15px;">
	                			<input type="text" id="id" name="id" value="${dto.id}" readonly>
	                		</td>
	                		<th style="background-color: #f1f1f1; padding:15px;">구분</th>
	                		<td style="padding:15px;">
	                			<input type="text" value="법인" readonly>
	                		</td>
	                	</tr>
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">대표자명</th>
	                		<td style="padding:15px;">
	                			<input type="text" id="ceo_name" name="ceo_name" value="${dto.ceo_name}">
	                		</td>
	                		<th style="background-color: #f1f1f1; padding:15px;">거래처 연락처</th>
	                		<td style="padding:15px;"> 
	                			<input style="width:50px;" type="text" id="phone1" name="phone1" maxlength="3" 
	                				value="${fn:substring(dto.phone,0,3)}" required onkeyup="nextPhone1()"> - 
	                			<input style="width:50px;" type="text" id="phone2" name="phone2" maxlength="4" 
	                				value="${fn:substring(dto.phone,4,8)}" required onkeyup="nextPhone2()"> - 
	                			<input style="width:50px;" type="text" id="phone3" name="phone3" maxlength="4" 
	                				value="${fn:substring(dto.phone,9,13)}" required onkeyup="nextPhone3()">
	                		</td>
	                	</tr>
	                		
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">거래처 이메일</th>
	                		<td style="padding:15px;">
	                			<input type="text" id="email" name="email" value="${dto.email}">
	                		</td>
	                		<th style="background-color: #f1f1f1; padding:15px;">사업자 번호</th>
	                		<td style="padding:15px;">
	                			<input style="width:50px;" type="text" id="register_num1" name="register_num1" maxlength="3" 
	                				value="${fn:substring(dto.register_num,0,3)}" required onkeyup="nextRegisterNum1()"> - 
	                			<input style="width:50px;" type="text" id="register_num2" name="register_num2" maxlength="2" 
	                				value="${fn:substring(dto.register_num,4,6)}" required onkeyup="nextRegisterNum2()"> - 
	                			<input style="width:50px;" type="text" id="register_num3" name="register_num3" maxlength="5" 
	                				value="${fn:substring(dto.register_num,7,12)}" required onkeyup="nextRegisterNum3()">
	                		</td>
	                	</tr>
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;" rowspan="3">거래처 주소</th>
	                		<td style="padding:15px;" colspan="3">
	                			<input style="width:100px;"type="text" id="zip_code" name="zip_code" value="${dto.zip_code }">
	                			<button type="button" id="search_zip_code" name="search_zip_code" 
	                                      value="${dto.zip_code}" onclick="daumPostcode()">우편번호검색</button>
	                		</td>
	                	</tr>
	                		
	                	<tr>
	                		<td>
	                			<input style="width:350px;" type="text" id="address" name="address" value="${dto.address}">
	                		</td>
	                	</tr>
	                	<tr>
	                		<td>
	                			<input style="width:350px;"type="text" id="detail_address" name="detail_address" value="${dto.detail_address}">
	                		</td>
	                	</tr>
	                		
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">등록일</th>
	                		<td style="padding:15px;" colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.register_date}"/></td>
	                	</tr>
	                </table>
	                <div style="text-align:center;" class="form-group mt-5 col-md-12">
                            <input class="btn  btn-primary" type="submit" value="수정하기"
                            	onclick="window.location='clientUpdate?id=${dto.id}'"/>
                            <input class="btn  btn-defalte" type="button" value="닫기"
                            	onclick="window.close();"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end row -->
</div>

	<script src="${RESOURCES_PATH}/sales/js/clientUpdate.js"></script>
</body>
</html>