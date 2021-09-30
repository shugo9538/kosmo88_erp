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
                <h4 class="page-title">거래처 관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">전체 목록</a>
                    </li>
                    <li class="active">
                        	거래처 관리
                    </li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->


            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	견적서 등록</h2>
                        <div class="form-group">
                        </div>
                        <form class="form-horizontal" name="clientRegisterForm" action="${ROOT_PATH}/sales/clientRegisterAction" method="post">
                             <sec:csrfInput />
                            
                            <table class="display table mt-12">
                            	<tr>
                            		<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td><input type="text" name="name" id="name" required placeholder="거래처명"></td>
                            		<th style="background-color: #f1f1f1;">구분</th>
                            		<td><input type="text" value="법인" readonly></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">대표자</th>
                            		<td><input type="text" name="ceo_name" id="ceo_name" required placeholder="대표자"></td>
                            		<th style="background-color: #f1f1f1;">사업자 번호</th>
                            		<td>
										<input style="width:50px;" type="text" id="register_num1" name="register_num1" maxlength="3" 
			                				required placeholder="000" onkeyup="nextRegisterNum1()"> - 
			                			<input style="width:50px;" type="text" id="register_num2" name="register_num2" maxlength="2" 
			                				required placeholder="00" onkeyup="nextRegisterNum2()"> - 
			                			<input style="width:50px;" type="text" id="register_num3" name="register_num3" maxlength="5" 
			                				required placeholder="00000" onkeyup="nextRegisterNum3()">
									</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">거래처 이메일</th>
                            		<td >
                            			<input class="input" type="text" id="email1" name="email1" maxlength="20"
											style="width:100px">
										@
										<input class="input" type="text" id="email2" name="email2" maxlength="20"
											style="width:80px">
										<select class="input" name="email3" onchange="selectEmailChk();">
											<option value="0">직접입력</option>
											<option value="naver.com">네이버</option>
											<option value="google.com">구글</option>
											<option value="nate.com">네이트</option>
											<option value="daum.net">다음</option>
										</select>
                            		</td>
                            		<th style="background-color: #f1f1f1;">거래처 연락처</th>
                            		<td>
                            			<input style="width:50px;" type="text" id="phone1" name="phone1" maxlength="3" 
			                				required placeholder="010" onkeyup="nextPhone1()"> - 
			                			<input style="width:50px;" type="text" id="phone2" name="phone2" maxlength="4" 
			                				required placeholder="0000" onkeyup="nextPhone2()"> - 
			                			<input style="width:50px;" type="text" id="phone3" name="phone3" maxlength="4" 
			                				required placeholder="0000" onkeyup="nextPhone3()">
                            		</td>
                            	</tr>
                            	<tr>
                            		<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
                            		<td colspan="3">
                            			<input type="text" name="zip_code" id="zip_code" required placeholder="우편번호">
                            			<button type="button" id="search_zip_code" name="search_zip_code" 
	                                        	onclick="daumPostcode()">우편번호검색</button>
                            		</td>
                            		
                            	</tr>
                            	<tr>
                            		<td colspan="3">
                            			<input style="width:350px;" type="text" name="address" id="address" required placeholder="주소">
                            		</td>
                            	</tr>
                            	<tr>
                            		<td colspan="3">
                            			<input style="width:350px;" type="text" name="detail_address" id="detail_address" required placeholder="상세주소">
                            		</td>
                            	</tr>
                            
                            </table>
                            
                            <div class="form-group">
                                <div class="col-md-5 col-md-offset-5">
                                    <input class="btn  btn-primary" type="submit" value="등록">
                                    <input class="btn  btn-default" type="reset" value="취소">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end row -->

            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	거래처 전체 목록 </h2><span style="text-align:right;">(등록된 거래처 : ${cnt}개)</span>
                        <div class="table-responsive">
                            <div class="form-group">
                            </div>
                            <div class="form-group">
                            </div>
                            <table id="example" class="display table">
                                <thead>
                                    <tr>
                                        <td style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </td>
                                        <th>거래처 번호</th>
                                        <th>회사명</th>
                                        <th>사업자번호</th>
                                        <th>대표자명</th>
                                        <th>전화번호</th>
                                        <th>주소</th>
                                        <th>등록일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <!-- 등록된 거래처가 있는 경우 -->
                                <c:if test="${cnt > 0}">
                                	<c:forEach var="dto" items="${dto}">
                                		<tr>
	                                        <th style="text-align: center;">
	                                            <input type="checkbox" name="select" id="select">
	                                        </th>
	                                        <td>${dto.id}</td>
	                                        <th>
	                                        	<a href="clientDetail?id=${dto.id}&pageNum=${pageNum}&number=${number + 1}"
	                                        		onclick="window.open(this.href, 'mywin', 'left=1000,  width=1200, height=700, toolbar=1');return false;">${dto.name}</a>
	                                        </th>
	                                        <td>${dto.register_num}</td>
	                                        <td>${dto.ceo_name}</td>
	                                        <td>${dto.phone}</td>
	                                        <td>${dto.address}</td>
	                                        <td>
	                                        	<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.register_date}"/>
	                                        </td>
	                                    </tr>
                                	</c:forEach>
                                </c:if>
                                
                                <!-- 등록된 거래처가 없는 경우 -->
                                <c:if test="${cnt == 0}">
                                	<tr>
                                		<td colspan="7" align="center">
                                   			<span style="color:red"> 등록된 거래처가 없습니다. </span>
                                   		</td>
                                	</tr>
                                </c:if>   
                                    
                                </tbody>
                            </table>
                        </div>
                        
                    </div>
                </div>
                <!--End row-->
        <!-- End Wrapper-->
        
                    </div>
            	<div>
            </div>
        </div>
       
       
        <!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
		<script src="${RESOURCES_PATH}/sales/js/clientRegister.js"></script>
	</div>
</body>
</html>