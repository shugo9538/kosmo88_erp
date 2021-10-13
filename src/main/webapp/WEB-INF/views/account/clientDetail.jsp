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
  <title> 회계팀 - 거래처 등록</title>
</head>
<body class="sticky-header" onload="clientDetail();">

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
               <h4 class="page-title"> 거래처 등록
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
                       <h2 class="header-title">거래처 등록</h2><!-- js-validation-bootstrap form-horizontal -->
                          <form class="client_detail_form" id="client_detail_form" name="client_detail_form" 
                          action="${ROOT_PATH}/account/clientInsertAction" method="post" onsubmit="return clientDetailChk();">
							<!-- _csrf TOKEN  -->
							<sec:csrfInput/>
							<input type="hidden" name="enabled" value="Y">
							
							<%-- <!-- 아이디  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="id">아이디 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="id" name="id" value="${client.id}">
                            </div> 
                          </div>--%>
							<!-- 거래처명  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="name">거래처명 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="name" name="name" placeholder="입력하세요">
                            </div>
                          </div>
							<!-- 대표자명  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="ceo_name">대표자명 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="ceo_name" name="ceo_name" placeholder="입력하세요">
                            </div>
                          </div>
							<!-- 사업자번호  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="register_num">사업자번호 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="register_num" name="register_num" placeholder="입력하세요">
                            </div>
                          </div>
							<!-- 사업자주소지1  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="address">사업자주소지1 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="address" name="address" placeholder="입력하세요">
                            </div>
                          </div>
							<!-- 사업자주소지2  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="detail_address">사업자주소지2 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="detail_address" name="detail_address" placeholder="입력하세요">
                            </div>
                          </div>
							<!-- 사업자주소지우편번호  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="zip_code">사업자주소지3 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="zip_code" name="zip_code" placeholder="입력하세요">
                            </div>
                          </div>
							<!-- 사업자번호  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="register_date">사업자번호 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="register_date" name="register_date" placeholder="입력하세요">
                            </div>
                          </div>
							<!-- 연락처  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="phone">사업자연락처 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="phone" name="phone" placeholder="입력하세요">
                            </div>
                          </div>
							<!-- 담당자 이메일  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="email">담당자 이메일 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="email" name="email" placeholder="입력하세요">
                            </div>
                          </div>
							
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
