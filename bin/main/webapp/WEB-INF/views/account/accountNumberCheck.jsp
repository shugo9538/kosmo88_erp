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
<body class="sticky-header" onload="accountNumberCheckFocus();">

    <!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
    <!--End left side menu-->

    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
		<%-- <%@ include file="../common/header.jsp"%>   --%>  
		<%@ include file="common/accountHeader.jsp"%>    
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">
              
              <!--Start Page Title-->
               <div class="page-title-box">
                    <h4 class="page-title"> 계좌번호 확인</h4>
                    <ol class="breadcrumb">
                        <li>
                            <a href="#"></a>
                        </li>
                        <li>
                            <a href="#"></a>
                        </li>
                        <li class="active">
                        </li>
                    </ol>
                    <div class="clearfix"></div>
                 </div>
                  <!--End Page Title-->          
           
           
               <!--Start row-->
               <div class="row">
                   <div class="col-md-12">
                       <div class="white-box">  
                       <h2 class="header-title">계좌번호 확인</h2><!-- js-validation-bootstrap form-horizontal -->
                          <form class="account_insert_from" id="accountChkFrom" name="accountChkFrom" 
                          action="${ROOT_PATH}/account/accountNumberCheck" method="post" onsubmit="return accountCheck()">
							<!-- _csrf TOKEN  -->
							<sec:csrfInput/>
							
							<!-- 계좌번호가 없을경우  -->
							<c:if test="${selectCnt == 0}">
	                            <div class="form-group">
	                            <label class="col-md-3 control-label" for="account_number"></label>
	                            <div class="col-md-9">
	                              <input class="form-control" value="${account_number}" readonly>
	                              <span style="color:blue"> 입력하신 계좌번호는 사용 가능합니다.</span>
	                            </div>
                          		</div>
                            </c:if>
                            
                            <!-- 계좌번호가 있을경우  -->
                            <c:if test="${selectCnt == 1}">
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="account_number">계좌번호<span style="color:red">(숫자만)</span> <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input type="hidden" id="root" value="${ROOT_PATH}">
                              <input class="form-control" type="text" class="account_number" id="account_number"  name="account_number" placeholder="계좌번호를 입력하세요"
                              		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\.*)\./g, '$1')">
                            	<span style="color:red">${account_number} 계좌번호는 등록된 계좌번호입니다.</span><br>
                            	<span style="color:red"> 새로운 계좌번호를 입력 바랍니다.</span>
                            </div>
                          </div>
                          </c:if>
                          
                          <!-- 계좌번호 입력후 체크  -->
                      <!--     <div class="form-group">
                            <label class="col-md-3 control-label">입력체크<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <div class="checkbox primary">
                                <input type="checkbox" id="inputChk" name="inputChk" value="1">
                                <label  class="css-input css-checkbox css-checkbox-primary" for="inputChk">
                                	입력하신 계좌번호 중복  확인 후 체크 바랍니다.
                                </label>
                              </div>
                            </div>
                          </div> -->
                          <div class="form-group">
                            <div class="col-md-8 col-md-offset-3">
                            	<!-- 계좌번호가 없는경우  -->
                              <c:if test="${selectCnt == 0}">
                              	<button class="btn  btn-primary" type="button" onclick="settingAccountNum(${account_number})">계좌번호 사용</button>
                             	<!-- 계좌번호가 있는 경우  -->
                              </c:if>
                              <c:if test="${selectCnt == 1}">
	                              <button class="btn  btn-primary" type="submit">계좌번호 검색</button>
	                              <button class="btn  btn-primary" type="reset">입력취소</button>
                               </c:if>
                            </div>
                          </div>
                        </form>
                    	</div>
                    </div>
                </div>
                 <!-- end row --> 
            </div>
      <!-- End Wrapper-->
        <!--Start  Footer -->
		<%@ include file="../common/footer.jsp"%>
		<%@ include file="common/accountFooter.jsp" %>
         <!--End footer -->
       </div>
      <!--End main content -->
</body>
</html>
