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
				<li class="active"><a href="${ROOT_PATH}/sales/clientDelete">거래처 삭제</a></li>
			</ul>

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
	                                        <td>${dto.id}</td>
	                                        <th>
	                                        	<a href="clientDetail?id=${dto.id}&pageNum=${pageNum}&number=${number + 1}"
	                                        		onclick="window.open(this.href, 'mywin', 'left=1000,  width=1000, height=700, toolbar=1');">${dto.name}</a>
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
		</div>	
		<!-- End Wrapper-->
		
		<%@ include file="../common/footer.jsp"%>
		
		
</body>
</html>