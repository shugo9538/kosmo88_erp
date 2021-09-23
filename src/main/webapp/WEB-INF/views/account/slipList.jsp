<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="author" content="">
  <title> 회계관리 - 일반전표</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body class="sticky-header">


    <!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
    <!--End left side menu-->

    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
		<%@ include file="../common/header.jsp"%>    
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">
              
          <!--Start Page Title-->
           <div class="page-title-box">
                <h4 class="page-title">  전표입력/장부관리 </h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">승인전표 목록</a>
                    </li>
                    <li>
                        <a href="#">미승인전표 목록</a>
                    </li>
                   <!--  <li class="active">
                        Data Table
                    </li> -->
                </ol>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->          
           
               <!--Start row-->
               <div class="row">
                   <div class="col-md-12">
                   	              <!-- 메뉴버튼 -->
                            	<div>
			        <ul class="nav nav-pills custom-nav">
						<li class="active"><a href="${ROOT_PATH}/account/slipDetail">일반전표 등록</a></li>
						<li class="active"><a href="${ROOT_PATH}/account/slipModify">일반전표 수정</a></li>
					</ul>
                 	</div>
      	  <!-- 메뉴버튼 끝 -->  
                       <div class="white-box">
                           <h2 class="header-title">일반전표 목록</h2>
                            <div class="table-responsive">
                             <table id="example" class="table table table-hover m-0">
                                    <thead>
                                        <tr>
                                            <th>전표번호</th>
                                            <th>유형</th>
                                            <th>발행일</th>
                                            <th>승인일자</th>
                                            <th>상태(Y/N)</th>
                                            <th>부서코드</th>
                                            <th>파트별ID</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                    	<td>11111</td>
                                    	<td>입금</td>
                                    	<td>2021-09-23</td>
                                    	<td>2021-09-24</td>
                                    	<td>미승인</td>
                                    	<td>22222</td>
                                    	<td>33333</td>
                                    </tr>
                                    <tr>
                                    	<td>11111</td>
                                    	<td>입금</td>
                                    	<td>2021-09-24</td>
                                    	<td>2021-09-25</td>
                                    	<td>미승인</td>
                                    	<td>22222</td>
                                    	<td>33333</td>
                                    </tr>
                                    <tr>
                                    	<td>11111</td>
                                    	<td>입금</td>
                                    	<td>2021-09-26</td>
                                    	<td>2021-09-27</td>
                                    	<td>미승인</td>
                                    	<td>22222</td>
                                    	<td>33333</td>
                                    </tr>
                                    <!-- 등록전표가 있는 경우 -->                     
                                    <c:if test="${cnt > 0}">
                                    	<c:forEach var="dto" items="${slip}">
   											<tr>
   												<td>${number}
   													<c:set var="number" value="${number -1 }"/>
   												</td>
                                        		<td>${dto.id}</td>
                                        		<td>${dto.type}</td>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.register_date}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.update_date}"/>
                                        		</td>
                                        		<td>${dto.state}</td>
                                        		<td>${dto.department_id}</td>
                                        		<td>${dto.department_request}</td>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                     </c:if>

                                     <!-- 등록 전표가 없는경우 -->
                                  <%--    <c:if test="${cnt == 0}">
                                     	<tr>
                                     		<td colspan="7" align="center">
                                     			<span style="color:red"> 등록된 전표가 없습니다. </span>
                                     		</td>
                                     	</tr>
                                     </c:if>  --%>  
                                    </tbody>
                                    
                                    <tfoot>
                                    <!-- 등록거래처가 있는경우 --> 
                                     <c:if test="${cnt > 0}">
                                     <tr>
                                     	<th colspan="8">
                                     	<!-- 맨처음[◀◀] / 이전블럭[◀]  -->
                                     	<c:if test="${startPage > pageBlock}">
                                     		<a href="${ROOT_PATH}/account/slipList?categoryNum=120" style="color:block">[◀◀]</a>
                                     		<a href="${ROOT_PATH}/account/slipList?categoryNum=120&pageNum=${startPage-pageBlock}" style="color:block">[◀]</a>
                                     	</c:if>
                                     	
                                     	<c:forEach var="i" begin="${startPage}" end="${endPage}">
                                     		<c:if test="${i == currengPage}">
                                     			<span><b>[${i}]</b></span>
                                     		</c:if>
                                     		<c:if test="${i != currengPage}">
                                     			<a href="${ROOT_PATH}/account/slipList?categoryNum=120&pageNum=${i}">[${i}]</a>
                                     		</c:if>
                                     	</c:forEach>
                                     	<!-- 다음블록[▶▶] / 맨마지막블럭[▶]  -->
                                     	<c:if test="${pageCount > endPage}">
                                     		<a href="${ROOT_PATH}/account/slipList?categoryNum=120&pageNum=${startPage + pageBlock}">[▶]</a>
                                     		<a href="${ROOT_PATH}/account/slipList?categoryNum=120&pageNum=${pageCount}">[▶▶]</a>
                                     	</c:if>
                                     	</th>
                                     	</tr>
                                     </c:if>
                                    </tfoot>
                                   </table>  
                            </div>
                       </div>
                   </div>
               </div>
               <!--End row-->
               
			    </div>
        <!-- End Wrapper-->

        <!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>	
         <!--End footer -->
       </div>
      <!--End main content -->

</body>

</html>
