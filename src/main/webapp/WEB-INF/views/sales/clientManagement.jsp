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
					<li class="active">거래처 관리</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/sales/clientRegister">거래처 등록</a></li>
			</ul>

            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	거래처 전체 목록 </h2><span style="text-align:right;">(등록된 거래처 : ${cnt}개)</span>
                        <div class="table-responsive">
                        	<div class="col-md-2 mt-1">
								<input class="btn btn-default" type="button" id="delButton" name="delButton" value="품목삭제">
							 </div>
							 
                            <table id="example" class="display table">
                                <thead>
                                    <tr>
                                        <td style="text-align: center;">
                                            <input type="checkbox" name="checkAll" id="checkAll">
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
	                                            <input type="checkbox" name="client_id" id="client_id" value="${dto.id}">
	                                        </th>
	                                        <td>${dto.id}</td>
	                                        <th>
	                                        	<a href="clientDetail?id=${dto.id}&pageNum=${pageNum}"
	                                        		onclick="window.open(this.href, 'mywin', 'left=100,  width=1000, height=600, toolbar=1');return false;">${dto.name}</a>
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
		</div>	
		<!-- End Wrapper-->
		
		<%@ include file="../common/footer.jsp"%>
		<script src="${RESOURCES_PATH}/sales/js/clientManagement.js"></script>
		
</body>
</html>