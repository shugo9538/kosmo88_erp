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
  <title> 회계관리 - 거래처 목록</title>

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
                <h4 class="page-title">기초정보 관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">신규거래처 등록</a>
                    </li>
                    <li>
                        <a href="#">거래처 정보 수정</a>
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
                       <div class="white-box">
                           <h2 class="header-title">거래처 관리 (등록 거래처 총 ${cnt}개)</h2>
                            <div class="table-responsive">
                             <table id="example" class="table table table-hover m-0"><!-- display table  -->
                                    <thead>
                                        <tr>
                                        	<th>번호</th>
                                            <th>거래처코드</th>
                                            <th>거래처유형</th>
                                            <th>거래처명</th>
                                            <th>대표자</th>
                                            <th>사업자등록번호</th>
                                            <th>주소지</th>
                                            <th>우편번호</th>
                                            <th>이메일</th>
                                            <th>등록일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <!-- 등록거래처가 있는경우 -->                     
                                    <c:if test="${cnt > 0}">
                                    	<c:forEach var="dto" items="${client}">
   											<tr>
   												<td>${number}
   													<c:set var="number" value="${number -1 }"/>
   												</td>
                                        		<td>${dto.id}</td>
                                        		<td>${dto.type}</td>
                                        		<td>${dto.name}</td>
                                        		<td>${dto.ceo_name}</td>
                                        		<td>${dto.register_num}</td>
                                        		<td>${dto.address}</td>
                                        		<td>${dto.zip_code}</td>
                                        		<td>${dto.email}</td>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.register_date}"/>
                                        		</td>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                     </c:if>

                                     <!-- 등록 거래처가 없는경우 -->
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
                                     		<a href="${ROOT_PATH}/account/clientList?categoryNum=110" style="color:block">[◀◀]</a>
                                     		<a href="${ROOT_PATH}/account/clientList?categoryNum=110&pageNum=${startPage-pageBlock}" style="color:block">[◀]</a>
                                     	</c:if>
                                     	
                                     	<c:forEach var="i" begin="${startPage}" end="${endPage}">
                                     		<c:if test="${i == currengPage}">
                                     			<span><b>[${i}]</b></span>
                                     		</c:if>
                                     		<c:if test="${i != currengPage}">
                                     			<a href="${ROOT_PATH}/account/clientList?categoryNum=110&pageNum=${i}">[${i}]</a>
                                     		</c:if>
                                     	</c:forEach>
                                     	<!-- 다음블록[▶▶] / 맨마지막블럭[▶]  -->
                                     	<c:if test="${pageCount > endPage}">
                                     		<a href="${ROOT_PATH}/account/clientList?categoryNum=110&pageNum=${startPage + pageBlock}">[▶]</a>
                                     		<a href="${ROOT_PATH}/account/clientList?categoryNum=110&pageNum=${pageCount}">[▶▶]</a>
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
