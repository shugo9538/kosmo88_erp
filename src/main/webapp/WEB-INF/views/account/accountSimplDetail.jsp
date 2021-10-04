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
<!-- 통장 거래내역 추가 페이지 -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- 통장 거래내역 추가 페이지  -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/logistics_erp/resources/accounting/js/datepicker-ko.js"></script>
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
                    <h4 class="page-title">
                    <a href="${ROOT_PATH}/account/accountList?categoryNum=140">통장목록</a>
                   	 &gt;
               		통장거래내역추가
                   	 </h4>
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
                       <h2 class="header-title">통장거래내역추가</h2><!-- js-validation-bootstrap form-horizontal -->
                          <form class="js-validation-slip" id="js-validation-slip" 
                          action="${ROOT_PATH}/account/accountSimplAction" method="post">
                          <!-- CSRF Token  -->
                          <sec:csrfInput/>
                         	
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="transaction_date">거래일자 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="transaction_date" name="transaction_date">
                            	<script>
								   $("#transaction_date").datepicker();
								</script>
                            </div>
                          </div>
                            
                         <!--    <div class="form-group">
                            <label class="col-md-3 control-label" for="transaction_time">거래시간 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="transaction_time" name="transaction_time" placeholder="아직 시간 입력 설정 않함 날짜만">
                            </div>
                          </div> -->
                          
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="account_number" style="color:red">등록계좌정보<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <c:if test="${!empty account}">
                              <select class="form-control" id="account_number" name="account_number" required>
                                <option value="">계좌은행을 선택하세요</option>
                              	<c:forEach var="dto" items="${account}">
                                <option value="${dto.account_number}">${dto.name}-${dto.bank}(${dto.account_number})</option>
                            	 </c:forEach>
                              </select>
                              </c:if>
                              <c:if test="${empty account}">
                              	<span style="color:red">은행정보가 없습니다.</span>
                              </c:if>
                            </div>
                          </div>
                           
                           <!--  
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="val-update_date" style="color:red">계좌번호(db정보)<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                            	<c:if test="${!empty account}">
                               <select class="form-control" id="val-type" name="val-type">
                               		<option value="">계좌번호를 선택하세요</option>
                                <c:forEach var="dto" items="${account}">
                               	 <option value="${dto.account_number}">${dto.account_number}</option>
                                </c:forEach>
                              </select>
                              	</c:if>
                              	<c:if test="${empty account}">
                              		<span style="color:red">계좌번호가 없습니다.</span>
                              	</c:if>
                            </div>
                          </div>
                          -->
                          
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="abs">적요 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="abs" name="abs" placeholder="상태" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="type">유형 <span class="text-danger">*</span></label>
								<div class="col-md-9">
									<select class="form-control" id="type" name="type" required>
										<option value="">입/출금 유형</option>
										<option value="입금">입금</option>
										<option value="출금">출금</option>
									</select>
								</div>
							</div>
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="balance">거래금액 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="balance" name="balance" placeholder="입금금액을입력하세요"
                              oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\.*)\./g, '$1')">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label">승인체크<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <div class="checkbox primary">
                                <input type="checkbox" id="val-terms" name="val-terms" value="1" required>
                                <label  class="css-input css-checkbox css-checkbox-primary" for="val-terms" >
                                	입력사항을 확인 후 체크 바랍니다.
                                </label>
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-md-8 col-md-offset-3">
                              <button class="btn  btn-primary" type="submit">거래내역등록</button>
                              <button class="btn  btn-primary" type="reset">입력취소</button>
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
