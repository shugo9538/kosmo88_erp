<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<body class="sticky-header">
	
<div class="wrapper">
	<!--Start row-->
    <div class="row">
        <div class="col-md-12">
            <div class="white-box" id="white-box">
            
            	<!-- 거래처 PDF 출력 -->
	           <div  style="text-align:right;" class="dt-buttons">
	               	<button class="btn btn-danger" type="button" id="pdfmake">
	               		<span>
	               			<i class="fa fa-download">
	               				PDF 다운로드
	               			</i>
	               		</span>
	               	</button>
               </div> 
            
                <h2 style="font-size:34px; text-align:center;" class="header-title col-md-12 mb-5">${cdto.name}</h2>
                
                <form class="js-validation-bootstrap form-horizontal ">
                	
                	<input type="hidden" id="client_name" value="${cdto.name}">
                	<input type="hidden" id="client_id" value="${cdto.id}">
	                <table id="client_list" class="table table table-hover m-0">
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
    </div>
    <!-- end row -->
	<%@ include file="./js_sales.jsp"%>
	<script src="${RESOURCES_PATH}/sales/js/clientDetail.js"></script>
	<!-- pdf 출력 -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
	<script type="text/javascript" src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>

</div>
</body>
</html>