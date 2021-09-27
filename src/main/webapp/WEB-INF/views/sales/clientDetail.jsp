<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box">
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-8">
                	
                	${dto.name}</h2>
                <div class="form-group">
                </div>
                
                <form class="js-validation-bootstrap form-horizontal">
                    <input type="hidden" name="pageNum" value="${pageNum}">
                    <input type="hidden" name="id" value="${dto.id}">
                    <input type="hidden" name="name" value="${dto.name}">
                    <input type="hidden" name="ceo_name" value="${dto.ceo_name}">
                    <input type="hidden" name="phone" value="${dto.phone}">
                    <input type="hidden" name="email" value="${dto.email}">
                    <input type="hidden" name="register_num" value="${dto.register_num}">
                    <input type="hidden" name="zip_code" value="${dto.zip_code}">
                    <input type="hidden" name="address" value="${dto.address}">
                    <input type="hidden" name="detail_address" value="${dto.detail_address}">
                    <input type="hidden" name="register_date" value="${dto.register_date}">
                    
                    
                    <div class="form-group mt-5">
                        <label class="col-md-2 control-label header-title" for="val-username">거래처번호</label>
                        <div class="col-md-2">
                            <p class="form-control-static">${dto.id}</p>
                        </div>
                        
                        <label class="col-md-2 control-label header-title" for="val-username">구분</label>
                        <div class="col-md-2">
                            <p class="form-control-static">법인</p>
                        </div>
                    </div>                        
                   
                    <div class="form-group">
                        <label class="col-md-2 control-label header-title" for="ceo_name">대표자명</label>
                        <div class="col-md-2">
                            <p class="form-control-static">${dto.ceo_name}</p>
                        </div>
                        
                        <label class="col-md-2 control-label header-title" for="client_phone1">거래처 연락처</label>
                        <div class="col-md-2">
                            <p class="form-control-static">${dto.phone}</p>
                        </div>
                    </div>
                    
                    <div class="form-group">
                       <label class="col-md-2 control-label header-title" for="email">거래처 이메일</label>
                        <div class="col-md-2">
                           <p class="form-control-static">${dto.email}</p>
                        </div>
                        
                        <label class="col-md-2 control-label header-title" for="register_num">사업자번호</label>
		                 <div class="col-md-2">
		                    <p class="form-control-static">${dto.register_num}</p>
		                 </div>
		             </div>

                     <div class="form-group">
                         <label class="col-md-2 control-label header-title" for="zip_code">우편번호</label>
                         <div style="padding-left: 15px;" class="input-group m-b-0 col-md-2">
                             <p class="form-control-static">${dto.zip_code}</p>
                         </div>
                     </div>
                     <div class="form-group">
                         <label class="col-md-2 control-label header-title" for="address">주소</label>
                         <div class="col-md-3">
                             <p class="form-control-static">${dto.address}</p>
                         </div>
                     </div>
                     <div class="form-group">
                         <label class="col-md-2 control-label header-title" for="detail_address">상세주소</label>
                         <div class="col-md-3">
                             <p class="form-control-static">${dto.detail_address}</p>
                         </div>
                     </div>
                     
                     <div class="form-group">
                     	<label class="col-md-2 control-label header-title" for="register_date">등록일</label>
                         <div class="col-md-3">
                             <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.register_date}"/>
                         </div>
                     </div>

                     <div class="form-group mt-5">
                         <div style="padding-left:70px" class="col-md-12 col-md-offset-3">
                            <input class="btn  btn-primary" type="button" value="수정"
                            	onclick="window.location='clientUpdate?id=${dto.id}&pageNum=${pageNum}'"/>
                            <input class="btn  btn-primary" type="button" value="삭제"
                            	onclick="window.location='clientDelete?id=${dto.id}&pageNum=${pageNum}'"/>
                            <input class="btn  btn-primary" type="button" value="목록"
                            	onclick="window.location='clientManagement?pageNum=${pageNum}'">
                         </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- end row -->
</div>
</body>
</html>