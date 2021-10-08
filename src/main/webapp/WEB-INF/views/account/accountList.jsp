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
</head>

<body class="sticky-header">


    <!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
    <!--End left side menu-->

    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		<%@ include file="common/accountHeader.jsp"%>    
        <!-- header section end-->



        <!--body wrapper start-->
        <div class="wrapper">
              
          <!--Start Page Title-->
           <div class="page-title-box">
                <h4 class="page-title">금융/자금관리(통장)</h4>
                <ol class="breadcrumb">
                   <!-- 
                    <li>
                        <a href="#">급여통장</a>
                    </li>
                    <li>
                        <a href="#">거래처통장</a>
                    </li>
                    <li class="active">
                        <a href="#">통장목록</a>
                    </li>
                    -->
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
							<li class="active">
								<a href="${ROOT_PATH}/account/accountNewDetail">통장 추가</a>
							</li>
							<li class="active">
								<a 
<%-- 								href="${ROOT_PATH}/account/accountModifyDetail?account_number=" --%>
									id ="accountModify" onclick="accountEnabled();">통장 미사용처리</a>
							</li>
							<li>
								<!-- <button onclick="accountModifyDetail();">버튼테스트</button> -->
								<!-- <div id="result"></div> -->
							</li>
							<li class="active">
								<a href="${ROOT_PATH}/account/accountSimplDetail">거래내역 단건추가</a>
							</li>
						<%-- 	<li class="active">
								<a href="${ROOT_PATH}/account/accountMultitDetail">거래내역 다건추가</a>
								<a href="#">거래내역 다건추가</a>
							</li> --%>
						</ul>
					</div>
					<!-- 메뉴버튼 끝 -->
					<div class="white-box">
                           <h2 class="header-title">통장 목록</h2>
                            <div class="table-responsive">
                             <table id="example" class="table table table-hover m-0"><!-- display table  -->
                                    <thead>
                                        <tr>
                                        	<th>
                                            	<input type="hidden" id="root" value="${ROOT_PATH}">
                                        	</th>
                                            <th>번호</th>
                                            <th>계좌명</th>
                                            <th>계좌번호</th>
                                            <th>은행</th>
                                            <th>잔액</th>
                                            <th>등록일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="dto" items="${account}" varStatus="status">
   											<tr>
   												<td>
   													<input type="checkbox" name="check_accountNum" 
   														onclick="checkbox_accountNum(this);" value="${dto.account_number}"/>
   												</td>
                                        		<td>${dto.id}</td>
                                        		<td>${dto.name}</td>
                                        		<td>
	                                        		<input type="hidden" id="account_number" name="account_number" value="${dto.account_number}">
	                                    			<a href="#" id="accountNum" onclick="accountDetail(${dto.account_number});" >
	                                        		${dto.account_number}</a>
                                        		</td>
                                        		<td>${dto.bank}</td>
                                        		<td>
                                        		<fmt:formatNumber pattern="###,###,###,###" value="${dto.balance}"/>
                                        		</td>
                                        		<td>
                                        		<fmt:formatDate pattern="yyyy-MM-dd" value="${dto.register}"/>
                                        		</td>
                                       	    </tr>		                                     		
                                    	</c:forEach>
                                    </tbody>
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
		<%@ include file="common/accountFooter.jsp"%>	
         <!--End footer -->

       </div>
      <!--End main content -->

</body>

</html>
