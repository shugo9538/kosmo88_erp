<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">${cdto.name}</h2>
                
                
                <form class="js-validation-bootstrap form-horizontal ">
	                <table id="example" class="display table mt-12">
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">거래처 번호</th>
	                		<td style="padding:15px;">${cdto.id}</td>
	                		<th style="background-color: #f1f1f1; padding:15px;">구분</th>
	                		<td style="padding:15px;">법인</td>
	                	</tr>
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">대표자명</th>
	                		<td style="padding:15px;">${cdto.ceo_name}</td>
	                		<th style="background-color: #f1f1f1; padding:15px;">거래처 연락처</th>
	                		<td style="padding:15px;"> ${cdto.phone}</td>
	                	</tr>
	                		
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">거래처 이메일</th>
	                		<td style="padding:15px;">${cdto.email}</td>
	                		<th style="background-color: #f1f1f1; padding:15px;">사업자 번호</th>
	                		<td style="padding:15px;">${cdto.register_num}</td>
	                	</tr>
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">거래처 주소</th>
	                		<td style="padding:15px;" colspan="3">(${cdto.zip_code}) <br>${cdto.address} <br>${cdto.detail_address}</td>
	                	</tr>
	                		
	                	<tr>
	                		<th style="background-color: #f1f1f1; padding:15px;">등록일</th>
	                		<td style="padding:15px;" colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${cdto.register_date}"/></td>
	                	</tr>
	                </table>
	                <div style="text-align:center;" class="form-group mt-5 col-md-12">
	                   <input class="btn  btn-primary" type="button" value="수정" 
	                   	onclick="window.location='clientUpdate?client_id=${cdto.id}'"/>
	                   <input class="btn  btn-primary" type="button" value="삭제"
	                   	onclick="clientDelete();"/>
	                   <input class="btn  btn-defalte" type="button" value="닫기"
	                   	onclick="window.close();"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end row -->
</div>
</body>
</html>