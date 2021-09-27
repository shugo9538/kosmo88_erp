<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
                <h4 class="page-title">거래처 등록</h4>
                <ol class="breadcrumb">
                    <li><a href="${ROOT_PATH}/purchase/clientManagement">거래처 관리</a></li>
                    <li class="active">거래처 등록</li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->

			<form class="js-validation-bootstrap form-horizontal" name="clientRegisterform" action="${ROOT_PATH}/purchase/clientRegisterAction" method="post" >
				
				<!-- csrf 토큰 -->
				<sec:csrfInput />
			 
            	<!--Start row-->
	            <div class="row">
	            	<div class="col-md-12">
		            	<!-- Start white-box -->
		            	<div class="white-box">
							<div class="col-md-12">
							<h2 class="header-title"><i class="fa fa-chevron-circle-right mr-2"></i>거래처 등록</h2>
								<div class="form-group mt-1">
	                                <label class="col-md-1 control-label header-title">거래처명</label>
	                                <div class="col-md-3">
	                                    <input class="form-control" type="text" id="name" name="name"
	                                        placeholder="거래처명" required>
	                                </div>
	                               
	                                <label class="col-md-1 control-label header-title" for="ceo_name">대표자명</label>
	                                <div class="col-md-3">
	                                    <input class="form-control" type="text" id="ceo_name" name="ceo_name"
	                                        placeholder="대표자명" required>
	                                </div>
	                                
	                                <label class="col-md-1 control-label header-title" for="phone1">거래처 연락처</label>
	                                <div class="col-md-1">
	                                    <input class="form-control" type="text" id="phone1" name="phone1" maxlength="3"
	                                        placeholder="000" required onkeyup="nextPhone1()">
	                                </div>
	                                <div class="col-md-1">
	                                    <input class="form-control" type="text" id="phone2" name="phone2" maxlength="4"
	                                        placeholder="1111" required onkeyup="nextPhone2()">
	                                </div>
	                                
	                                <div class="col-md-1">
	                                    <input class="form-control" type="text" id="phone3" name="phone3" maxlength="4"
	                                        placeholder="2222" required onkeyup="nextPhone3()">
	                                </div>
	                            </div>
								
								<div class="form-group">
	                            	<label class="col-md-1 control-label header-title" for="email">거래처 이메일</label>
	                                <div class="col-md-3">
	                                    <input class="form-control" type="email" id="email" name="email"
	                                        placeholder="거래처 이메일" required>
	                                </div>
	                                
	                                <label class="col-md-1 control-label header-title" for="register_num1">사업자번호</label>
									<div class="col-md-1">
										<input class="form-control" placeholder="000" type="text" id="register_num1" name="register_num1" 
											maxlength="3" required onkeyup="nextRegister_num1()">
									</div>
									
									<div class="col-md-1">
										<input class="form-control" placeholder="11" type="text" id="register_num2" name="register_num2"  
											maxlength="2" required onkeyup="nextRegister_num2()">
									</div>
									
									<div class="col-md-1">
										<input class="form-control" placeholder="22222" type="text" id="register_num3" name="register_num3"  
											maxlength="5" required onkeyup="nextRegister_num3()">
									</div>
	                            </div>
	                            
	                            <div class="form-group mt-5">
	                                <label class="col-md-1 control-label header-title" for="zip_code">우편번호</label>
	                                
	                                <div style="padding-left: 15px;" class="input-group m-b-0 col-md-2">
	                                    <input class="form-control" type="text" placeholder="우편번호" id="zip_code" name="zip_code" maxlength="5" required>
	                                    <span class="input-group-btn">
	                                        <button type="button" class="btn  btn-primary" id="search_zipcode" name="search_zip_code" onclick="daumPostcode()">우편번호검색</button>
	                                    </span>
	                                </div>
	                            </div>
								
								<div class="form-group">
	                                <label class="col-md-1 control-label header-title" for="address">주소</label>
	                                <div class="col-md-3">
	                                    <input class="form-control" type="text" id="address" name="address"
	                                        placeholder="주소" required>
	                                </div>
	                            </div>
							
								<div class="form-group">
	                                <label class="col-md-1 control-label header-title" for="detail_address">상세주소</label>
	                                <div class="col-md-3">
	                                    <input class="form-control" type="text" id="detail_address" name="detail_address"
	                                        placeholder="상세주소" required>
	                                </div>
	                            </div>
							</div>
							
							<div class="col-md-12 mt-5">
							<h2 class="header-title"><i class="fa fa-chevron-circle-right mr-2"></i>거래처 상품 등록</h2>
							
								<div id="item-group">
							
									<div id="item">
										<div class="form-group mt-3">
											<label class="col-md-1 control-label header-title" for="item_name">상품명</label>
				                            <div class="col-md-2">
				                                <input class="form-control" type="text" name="item_name"
				                                    placeholder="상품명" required>
				                            </div>
											
											<label class="col-md-2 control-label header-title" for="category">상품종류</label>
											<div class="col-md-2">
				                                <input class="form-control" type="text" name="category"
				                                    placeholder="상품종류" required>
				                            </div>
											
											<label class="col-md-2 control-label header-title" for="price">상품가격(구매원가)</label>
				                            <div class="col-md-2">
				                                <input class="form-control" type="text" name="price" maxlength="10"
				                                    placeholder="상품가격" required>
				                            </div>
				                            
											<div role="button" class="col-md-1" onclick="delItem(this)">
												<i class="icon-minus"></i>
											</div>
										</div>		
			                    	</div>
			                    	
				                    <div role="button" class="preview col-md-12 md-5" id="addItem"
										onclick="addItem()">
										<i class="icon-plus"></i> 상품추가
									</div>
			                    </div>
							</div>
							
							<div class="form-group mt-5">
		                        <div class="col-md-5 col-md-offset-5">
		                        	<input class="btn  btn-primary" type="submit" value="등록">
		                            <input class="btn  btn-default" type="reset" value="취소">
		                        </div>
							</div>
						</div>
						<!-- end white-box -->
					</div>		
	            </div>
           		<!-- end row -->
            </form>
	         <!--Start row-->
	         <div class="row">
	             <div class="col-md-12">
	             	<!-- Start white-box -->
	                 <div class="white-box">
	                     <h2 class="header-title">
	                     	<i class="fa fa-chevron-circle-right ml-3 mr-2"></i>
	                     	거래처 전체 목록</h2>
	                     <div class="table-responsive">
	                         <table id="example" class="display table">
	                             <thead>
	                                 <tr>
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
	                             	 		<input type="hidden" value="${dto.id}"> <!-- client id -->
	                             	 		<tr>
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
			                             	 		<fmt:formatDate value="${dto.register_date}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" />
			                             	 	</td>
		                             		</tr>	 
	                             	 	</c:forEach>
	                             	 </c:if>
	                             	 
	                             	 <!-- 거래처가 없으면 -->
	                             	 <c:if test="${cnt == 0}">
	                             	 	<tr>
											<td colspan="6" align="center">
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
         	<div>
    	</div>
	</div>
    <!-- End Wrapper-->
    
	<%@ include file="../common/footer.jsp"%>
	<script src="${RESOURCES_PATH}/purchase/js/clientRegister.js"></script>
</body>
</html>