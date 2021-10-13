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
  <title> 회계팀 - 지출결의</title>
</head>
<body class="sticky-header" onload="slipDetail();">

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
                   <a href="${ROOT_PATH}/account/slipList?categoryNum=120">전표입력/장부관리</a>
                   	 &gt;
               		회계팀 일반전표 등록
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
                       <h2 class="header-title">지출결의등록</h2><!-- js-validation-bootstrap form-horizontal -->
                          <form class="account_insert_from" id="account_insert_from" name="slip_detail_form" 
                          action="${ROOT_PATH}/account/slipInsertAction" method="post" onsubmit="return slipDetailChk();">
							<!-- _csrf TOKEN  -->
							<sec:csrfInput/>
							<!-- 부서번호  -->
							<input type="hidden" name="department_id" value="200">
							<!-- 전표유형  -->
							<input type="hidden" name="type" value="GENERAL">
							<!-- 전표상태  -->
							<input type="hidden" name="state" value="N">
							<!-- 사원번호  -->
							<input type="hidden" name="employee_id" value="ACC84">
							
							<!-- 지출유형  -->
							<div class="form-group">
                            <label class="col-md-3 control-label" for="type1">지출유형 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="type1" name="type1" value="일반" readonly>
                            </div>
                          </div>
							
							<!-- 지출계정  -->
							<div class="form-group">
								<label class="col-md-3 control-label" for="account_title">지출계정<span
									class="text-danger">*</span></label>
								<div class="col-md-9">
									<select class="form-control" id="account_title"
										name="account_title">
										<option value="0">지출 계정을 선택을 하세요</option>
										<option value="복리후생비">1. 복리후생비</option> 
										<option value="여비교통비">2. 여비교통비</option> 
										<option value="접대비">3. 접대비</option> 
										<option value="통신비">4. 통신비</option>
										<option value="수도광열비">5. 수도광열비</option>
										<option value="세금과공과금">6. 세금과공과금</option>
										<option value="지급임차료">7. 지급임차료</option>
										<option value="보험료">8. 보험료</option>
										<option value="차량유지비">9. 차량유지비</option>
										<option value="사무용품비">10. 사무용품비</option>
										<option value="소모품비">11. 소모품비</option>
										<option value="이자비용">12. 이자비용</option>
										<option value="법인세">13. 법인세</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
                            <label class="col-md-3 control-label" for="client_id">거래처 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                           <select class="form-control" id="client_id"
										name="client_id">
										<option value="0">거래처를 선태택하세요</option>
										<c:forEach var="dto" items="${client}"> 
										<option value="${dto.id}">${dto.id} / ${dto.name}</option>
										</c:forEach>
									</select>
                            </div>
                          </div>
							<div class="form-group">
                            <label class="col-md-3 control-label" for="abs">적요 <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="abs" name="abs" placeholder="적요를 입력하세요">
                            </div>
                          </div>
                            <div class="form-group">
                            <label class="col-md-3 control-label" for="expenses">지출금액<span style="color:red">(숫자만)</span> <span class="text-danger">*</span></label>
                            <div class="col-md-9">
                              <input class="form-control" type="text" id="expenses" name="expenses"
                              	oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\.*)\./g, '$1')">
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
                              <button class="btn  btn-primary" type="submit">지출등록</button>
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
