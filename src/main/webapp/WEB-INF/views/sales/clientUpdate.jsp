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
                
                <form class="js-validation-bootstrap form-horizontal" action="clientUpdateAction"
                	method="post">
                    <input type="hidden" name="pageNum" value="${pageNum }">
                    <input type="hidden" name="name" value="${dto.name}">
                    
                    
                    <div class="form-group mt-5">
                        <label class="col-md-2 control-label header-title" for="id">거래처번호</label>
                        <div class="col-md-2">
                            <input class="form-control" type="text" id="id" name="id" value="${dto.id}"
                                        required readonly>
                        </div>
                        
                        <label class="col-md-2 control-label header-title" for="val-username">구분</label>
                        <div class="col-md-2">
                        	<input class="form-control" type="text" id="id" name="id" value="법인"
                                        required readonly>
                        </div>
                    </div>                        
                   
                    <div class="form-group">
                        <label class="col-md-2 control-label header-title" for="ceo_name">대표자명</label>
                        <div class="col-md-2">
                           <input class="form-control" type="text" id="ceo_name" name="ceo_name" value="${dto.ceo_name}"
                                        required>
                        </div>
                        
                        <label class="col-md-2 control-label header-title" for="phone">거래처 연락처</label>
                        <div class="col-md-2">
                            <input class="form-control" type="text" id="phone" name="phone" value="${dto.phone}"
                                        required>
                        </div>
                    </div>
                    
                    <div class="form-group">
                       <label class="col-md-2 control-label header-title" for="email">거래처 이메일</label>
                        <div class="col-md-2">
                           <input class="form-control" type="text" id="email" name="email" value="${dto.email}"
                                        required>
                        </div>
                        
                        <label class="col-md-2 control-label header-title" for="register_num">사업자번호</label>
		                 <div class="col-md-2">
		                    <input class="form-control" type="text" id="register_num" name="register_num" value="${dto.register_num}"
                                        required>
		                 </div>
		             </div>

                     <div class="form-group">
                         <label class="col-md-2 control-label header-title" for="zip_code">우편번호</label>
                         <div style="padding-left: 15px;" class="input-group m-b-0 col-md-2">
                             <input class="form-control" type="text" id="zip_code" name="zip_code" value="${dto.zip_code}"
                                        required>
                         </div>
                     </div>
                     <div class="form-group">
                         <label class="col-md-2 control-label header-title" for="address">주소</label>
                         <div class="col-md-3">
                             <input class="form-control" type="text" id="address" name="address" value="${dto.address}"
                                        required>
                         </div>
                     </div>
                     <div class="form-group">
                         <label class="col-md-2 control-label header-title" for="detail_address">상세주소</label>
                         <div class="col-md-3">
                             <input class="form-control" type="text" id="detail_address" name="detail_address" value="${dto.detail_address}"
                                        required>
                         </div>
                     </div>
                     <div class="form-group">
                     	<label class="col-md-2 control-label header-title" for="register_date">등록일</label>
                         <div class="col-md-3">
                             <input class="form-control" type="text" id="register_date" name="register_date" value="${dto.register_date}"
                                        required readonly>
                         </div>
                     </div>

                     <div class="form-group mt-5">
                         <div style="padding-left:70px" class="col-md-12 col-md-offset-3">
                            <input class="btn  btn-primary" type="submit" value="수정">
	                        <input class="btn  btn-default" type="reset" value="취소">
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