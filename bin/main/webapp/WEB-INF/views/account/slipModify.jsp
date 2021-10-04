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
                    <a href="${ROOT_PATH}/account/slipList?categoryNum=120">전표입력/장부관리</a>
                   	 &gt;
               		일반전표수정
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
                       <h2 class="header-title">일반전표 수정 입력</h2><!-- js-validation-bootstrap form-horizontal -->
                          <form class="js-validation-slip" id="js-validation-slip" action="#" method="post">
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="val-id">전표번호 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="val-id" name="val-id" value="${slip.id}" readonly>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="val-type">유형<span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <select class="form-control" id="val-type" name="val-type">
                                <option value="입금" <c:if test="${slip.type == '입금'}">selected</c:if>>입금</option>
                                <option value="출금" <c:if test="${slip.type == '출금'}">selected</c:if>>출금</option>
                                <option value="매입" <c:if test="${slip.type == '매입'}">selected</c:if>>매입</option>
                                <option value="매출" <c:if test="${slip.type == '매출'}">selected</c:if>>매출</option>
                                <option value="일반" <c:if test="${slip.type == '일반'}">selected</c:if>>일반</option>
                              </select>
                            </div>
                          </div>
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="val-register_date">발행일 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="val-register_date" 
                              name="val-register_date" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${slip.register_date}"/>"  readonly>
                            </div>
                          </div>
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="val-update_date">승인일자 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="date" id="val-update_date" name="val-update_date">
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${slip.update_date}"/>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="val-state">상태 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="val-state" name="val-state" placeholder="상태">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="val-department_id">부서코드 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="val-department_id" name="val-department_id" placeholder="부서코드">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label" for="val-department_request">부서요청코드 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="val-department_request" name="val-department_request" placeholder="부서요청코드">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-md-3 control-label"> 승인체크 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <div class="checkbox primary">
                                <input type="checkbox" id="val-terms" name="val-terms" value="1">
                                <label  class="css-input css-checkbox css-checkbox-primary" for="val-terms" >
                           		     입력사항을 확인 후 체크 바랍니다.
                                </label>
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-md-8 col-md-offset-3">
                              <button class="btn  btn-primary" type="submit">전표수정</button>
                              <button class="btn  btn-primary" onclick="location.href='${ROOT_PATH}/account/slipList?categoryNum=120'">수정취소</button>
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
         <!--End footer -->
       </div>
      <!--End main content -->

</body>

</html>
