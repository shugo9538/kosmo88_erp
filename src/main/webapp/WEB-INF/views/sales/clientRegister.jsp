<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
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
                        	거래처 등록</h2>
                        <div class="form-group">
                        </div>
                        <form class="js-validation-bootstrap form-horizontal" action="clientRegisterAction"
                            method="post">
                                                        
                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">거래처명</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="name" name="client_name"
                                        placeholder="거래처명" required>
                                </div>
                               
                                <label class="col-md-1 control-label header-title" for="ceo_name">대표자명</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="ceo_name" name="ceo_name"
                                        placeholder="대표자명" required>
                                </div>
                                
                                <label class="col-md-1 control-label header-title" for="client_phone1">거래처 연락처</label>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="phone1" name="phone1" maxlength="3"
                                        placeholder="000" required>
                                </div>
                                
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="phone2" name="phone2" maxlength="4"
                                        placeholder="1111" required>
                                </div>
                                
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="phone3" name="phone3" maxlength="4"
                                        placeholder="2222" required>
                                </div>
                            </div>
                            
                            <div class="form-group">
                               <label class="col-md-1 control-label header-title" for="email">거래처 이메일</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="email" id="email" name="email"
                                        placeholder="거래처 이메일" required>
                                </div>
                                
                                <label class="col-md-1 control-label header-title" for="register_num">사업자번호</label>
	                        <div class="col-md-1">
	                           <input class="form-control" placeholder="xxx" type="text" id="register_num1" name="register_num1" maxlength="3" required>
	                        </div>
	                        
	                        <div class="col-md-1">
	                           <input class="form-control" placeholder="xx" type="text" id="register_num2" name="register_num2"  maxlength="2" required>
	                        </div>
	                        
	                        <div class="col-md-1">
	                           <input class="form-control" placeholder="xxxxx" type="text" id="register_num3" name="register_num3"  maxlength="5" required>
	                        </div>
	                            </div>
	
	                            <div class="form-group mt-5">
	                                <label class="col-md-1 control-label header-title" for="zip_code">우편번호</label>
	                                <div style="padding-left: 15px;" class="input-group m-b-0 col-md-2">
	                                    <input class="form-control" type="text" placeholder="우편번호" id="zip_code" name="zipcode" maxlength="5" required>
	                                    <span class="input-group-btn">
	                                        <button type="button" class="form-control btn  btn-primary" id="zipcode" name="zip_code">우편번호검색</button>
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
                                        <th>번호</th>
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
	                                        <td>${number}
	                                        	<c:set var="number" value="${number -1}"/>
	                                        </td>
	                                        <th>
	                                        	<a href="clientDetail?id=${dto.id}&pageNum=${pageNum}&number=${number + 1}"
	                                        		onclick="window.open(this.href, 'mywin', 'left=1000,  width=1000, height=700, toolbar=1');">${dto.name}</a>
	                                        </th>
	                                        <td>${fn:substring(dto.register_num,0,3)} - 
		                    					${fn:substring(dto.register_num,3,5)} - 
		                    					${fn:substring(dto.register_num,5,10)}
	                                        
	                                        </td>
	                                        <td>${dto.ceo_name}</td>
	                                        <td>${fn:substring(dto.phone,0,3)} -
	                                        	${fn:substring(dto.phone,3,7)} - 
                            					${fn:substring(dto.phone,7,11)}
	                                        
	                                        </td>
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
                                <tfoot>
                                    <!-- 등록거래처가 있는경우 --> 
                                     <c:if test="${cnt > 0}">
                                     <tr>
                                     	<th colspan="8">
	                                     	<!-- 맨처음[◀◀] / 이전블럭[◀]  -->
	                                     	<c:if test="${startPage > pageBlock}">
	                                     		<a href="${ROOT_PATH}/sales/clientManagement" style="color:block">[◀◀]</a>
	                                     		<a href="${ROOT_PATH}/sales/clientManagement?pageNum=${startPage-pageBlock}" style="color:block">[◀]</a>
	                                     	</c:if>
	                                     	
	                                     	<c:forEach var="i" begin="${startPage}" end="${endPage}">
	                                     		<c:if test="${i == currengPage}">
	                                     			<span><b>[${i}]</b></span>
	                                     		</c:if>
	                                     		<c:if test="${i != currengPage}">
	                                     			<a href="${ROOT_PATH}/sales/clientManagement?pageNum=${i}">[${i}]</a>
	                                     		</c:if>
	                                     	</c:forEach>
	                                     	<!-- 다음블록[▶▶] / 맨마지막블럭[▶]  -->
	                                     	<c:if test="${pageCount > endPage}">
	                                     		<a href="${ROOT_PATH}/sales/clientManagement?pageNum=${startPage + pageBlock}">[▶]</a>
	                                     		<a href="${ROOT_PATH}/sales/clientManagement?pageNum=${pageCount}">[▶▶]</a>
	                                     	</c:if>
	                                     	</th>
                                     	</tr>
                                     </c:if>
                                </tfoot>
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
	</div>
</body>
</html>