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
<body class="sticky-header" onload="accountFocus();">

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
               		거래통장추가
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
                       <h2 class="header-title">거래통장추가</h2><!-- js-validation-bootstrap form-horizontal -->
                          <form class="account_insert_from" id="account_insert_from" name="account_new_from" 
                          action="${ROOT_PATH}/account/accountInsertAction" method="post" onsubmit="return accountCheck()">
							<!-- _csrf TOKEN  -->
							<sec:csrfInput/>
							
							<div class="form-group">
								<label class="col-md-3 control-label" for="account_holder_id">소유주<span
									class="text-danger">*</span></label>
								<div class="col-md-9">
									<select class="form-control" id="account_holder_id"
										name="account_holder_id">
										<option value="0">선택을 하세요</option>
										<option value="1">회사</option>
										<option value="2">거래처</option>
									</select>
								</div>
							</div>

							<div class="form-group">
                            <label class="col-md-3 control-label" for="name">계좌명 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="name" name="name" placeholder="계좌명을 입력하세요">
                              	
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="bank">계좌은행<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <select class="form-control" id="bank" name="bank">
                                <option value="0">계좌은행을 선택하세요</option>
                                <option value="우리은행">우리은행</option>
                                <option value="국민은행">국민은행</option>
                                <option value="신한은행">신한은행</option>
                                <option value="하나은행">하나은행</option>
                                <option value="기업은행">기업은행</option>
                                <option value="카카오뱅크">카카오뱅크</option>
                                <option value="농협은행">농협은행</option>
                                <option value="SC제일은행">SC제일은행 </option>
                                <option value="케이뱅크">케이뱅크</option>
                                <option value="대구은행">대구은행</option>
                                <option value="부산은행">부산은행</option>
                              </select>
                            </div>
                          </div>
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="account_number">계좌번호<span style="color:red">(숫자만)</span> <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                            <input type ="hidden" name="accountNumberCheck" value="0">	
                              <input type="hidden" id="root" value="${ROOT_PATH}">
                              <input class="form-control" type="text" class="account_number" id="account_number"  name="account_number" placeholder="계좌번호를 입력하세요"
                              		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\.*)\./g, '$1')">
                              <input class="accountNumChk" name="accountNumChk" type="button" 
									value="계좌번호 확인" onclick="accountChk();" value="0">	
                            </div>
                          </div>
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="balance">기초잔액<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="balance" name="balance"
                              	oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\.*)\./g, '$1')">
                            </div>
                          </div>
                          
                       <!--   통장 개설일로 할지 등록일로 할지 계좌번호가 unique라 현재 변경불가
                       		<div class="form-group">
                            <label class="col-md-3 control-label" for="account_resister_date">통장개설일 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="date" id="account_resister_date" name="account_resister_date">
                            </div>
                          </div> 
                       -->
                          
                          <div class="form-group">
                            <label class="col-md-3 control-label">입력체크<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <div class="checkbox primary">
                                <input type="checkbox" id="inputChk" name="inputChk" value="1">
                                <label  class="css-input css-checkbox css-checkbox-primary" for="inputChk">
                                	입력사항을 확인 후 체크 바랍니다.
                                </label>
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-md-8 col-md-offset-3">
                              <button class="btn  btn-primary" type="submit">통장추가</button>
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
