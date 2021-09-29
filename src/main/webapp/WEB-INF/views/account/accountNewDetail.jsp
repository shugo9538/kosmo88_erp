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
<script type="text/javascript" src="/logistics_erp/resources/assets/js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js" ></script>
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
                          <form class="account_insert_from" id="account_insert_from" name="account_insert_from" 
                          action="${ROOT_PATH}/account/accountInsertAction" method="post" >
							
							<!-- _csrf TOKEN  -->
							<sec:csrfInput/>
							
							<div class="form-group">
								<label class="col-md-3 control-label" for="account_holder_id">소유주<span
									class="text-danger">*</span></label>
								<div class="col-md-9">
									<select class="form-control" id="account_holder_id"
										name="account_holder_id" required>
										<option value="">선택을 하세요</option>
										<option value="1">회사</option>
										<option value="2">거래처</option>
									</select>
								</div>
							</div>

							<div class="form-group">
                            <label class="col-md-3 control-label" for="account_name">계좌명 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="account_name" name="account_name" placeholder="계좌명을 입력하세요" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="account_bank">계좌은행<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <select class="form-control" id="account_bank" name="account_bank" required>
                                <option value="0">계좌은행을 선택하세요</option>
                                <option value="1">우리은행</option>
                                <option value="2">국민은행</option>
                                <option value="3">신한은행</option>
                                <option value="4">하나은행</option>
                                <option value="5">기업은행</option>
                                <option value="6">카카오뱅크</option>
                                <option value="8">토스</option>
                                <option value="9">농협은행</option>
                                <option value="10">SC제일은행 </option>
                                <option value="11">수협</option>
                                <option value="12">케이뱅크</option>
                                <option value="13">대구은행</option>
                                <option value="14">부산은행</option>
                              </select>
                            </div>
                          </div>
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="account_number">계좌번호<span style="color:red">(숫자만)</span> <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="account_number" name="account_number" placeholder="계좌번호를 입력하세요" required>
                            </div>
                          </div>
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="account_balance">기초잔액<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="number" id="account_balance" name="account_balance" value="0" required>
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
                                <input type="checkbox" id="val-terms" name="val-terms" value="1" required>
                                <label  class="css-input css-checkbox css-checkbox-primary" for="val-terms">
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
		<script src="/logistics_erp/resources/accounting/js/account.js"></script>
			
         <!--End footer -->
       </div>
      <!--End main content -->

</body>

</html>
