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
  <link rel="icon" href="assets/images/favicon.png" type="image/png">
  <title>우여곡절 - 계좌조회 </title>
  <script type="text/javascript" src="${RESOURCES_PATH}/accounting/js/account.js"></script>
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
                <h4 class="page-title">금융/자금관리(통장)</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">급여통장</a>
                    </li>
                    <li>
                        <a href="#">거래처통장</a>
                    </li>
                    <li class="active">
                        <a href="#">통장목록</a>
                    </li>
                </ol>
                <div class="clearfix"></div>
             </div>
              <!--End Page Title-->          
           
               <!--Start row-->
               <div class="row">
                   <div class="col-md-12">
                       <div class="white-box">
                           <h2 class="header-title">통장 목록</h2>
                            <div class="table-responsive">
                             <table id="example" class="table table table-hover m-0"><!-- display table  -->
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>계좌코드</th>
                                            <th>계좌명</th>
                                            <th>계좌번호</th>
                                            <th>은행</th>
                                            <th>잔액</th>
                                            <th>요약</th>
                                            <th>등록일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <!-- 등록거래처가 있는경우 -->                     
                                    <c:if test="${cnt > 0}">
                                    	<c:forEach var="dto" items="${account}">
   											<tr>
   												<td>${number}
   													<c:set var="number" value="${number -1 }"/>
   												</td>
                                        		<td>${dto.id}</td>
                                        		<td>${dto.name}</td>
                                        		<td>
                                        		<input type="hidden" id="root" value="${ROOT_PATH}">
                                        		<input type="hidden" id="num" value="${dto.account_number}">
                                    			<a href="#" id="accountNum" onclick="accountDetail();" >
                                        		${dto.account_number}</a>
                                        		</td>
                                        		<td>${dto.bank}</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.balance}"/>
                                        		</td>
                                        		<td>${dto.abs}</td>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd" value="${dto.register}"/>
                                        		</td>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                     </c:if>

                                     <!-- 보유통장이 없는경우 -->
                                  <c:if test="${cnt == 0}">
                                     	<tr>
                                     		<td colspan="8" align="center">
                                     			<span style="color:red"> 등록된 통장이 없습니다.</span>
                                     		</td>
                                     	</tr>
                                     </c:if>
                                    </tbody>
                                    
                                    <tfoot>
                                    <!-- 보유통장이 있는경우 --> 
                                     <c:if test="${cnt > 0}">
                                     <tr>
                                     	<th colspan="8">
                                     	<!-- 맨처음[◀◀] / 이전블럭[◀]  -->
                                     	<c:if test="${startPage > pageBlock}">
                                     		<a href="${ROOT_PATH}/account/accountList?categoryNum=140" style="color:block">[◀◀]</a>
                                     		<a href="${ROOT_PATH}/account/accountList?categoryNum=140&pageNum=${startPage-pageBlock}" style="color:block">[◀]</a>
                                     	</c:if>
                                     	
                                     	<c:forEach var="i" begin="${startPage}" end="${endPage}">
                                     		<c:if test="${i == currengPage}">
                                     			<span><b>[${i}]</b></span>
                                     		</c:if>
                                     		<c:if test="${i != currengPage}">
                                     			<a href="${ROOT_PATH}/account/accountList?categoryNum=140&pageNum=${i}">[${i}]</a>
                                     		</c:if>
                                     	</c:forEach>
                                     	<!-- 다음블록[▶▶] / 맨마지막블럭[▶]  -->
                                     	<c:if test="${pageCount > endPage}">
                                     		<a href="${ROOT_PATH}/account/accountList?categoryNum=140&pageNum=${startPage + pageBlock}">[▶]</a>
                                     		<a href="${ROOT_PATH}/account/accountList?categoryNum=140&pageNum=${pageCount}">[▶▶]</a>
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
			    </div>
        <!-- End Wrapper-->
			</div>
        <!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>	
         <!--End footer -->

       </div>
      <!--End main content -->

</body>

</html>
