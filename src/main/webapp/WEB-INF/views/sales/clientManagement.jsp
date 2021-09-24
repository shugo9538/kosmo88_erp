<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		
		<!--body wrapper start-->
        <div class="wrapper">

            <!--Start Page Title-->
            <div class="page-title-box">
                <h4 class="page-title">거래처 관리</h4>
                <ol class="breadcrumb">
                    <li>
                        <a href="#">전체 목록</a>
                    </li>
                    <li class="active">
                        	거래처 관리
                    </li>
                </ol>
                <div class="clearfix"></div>
            </div>
            <!--End Page Title-->


            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	거래처 등록</h2>
                        <div class="form-group">
                        </div>
                        <form class="js-validation-bootstrap form-horizontal" action="base_forms_validation.html"
                            method="post">
                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">회사명</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="회사명">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">사업자번호</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="사업자번호">
                                </div>
                                
                                <label class="col-md-1 control-label header-title" for="val-username">대표 전화</label>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="000">
                                </div>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="xxxx">
                                </div>
                                <div>
                                    
                                </div>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="xxxx">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">사업장주소</label>
                                
                                <div style="padding-left: 15px;" class="input-group m-b-0 col-md-2">
                                    <input class="form-control" type="text" placeholder="우편번호">
                                    <span class="input-group-btn">
                                        <button type="button" class="form-control">우편번호검색</button>
                                    </span> 
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username"></label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="주소">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username"></label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="상세주소">
                                </div>
                            </div>

                            <div class="form-group">
                            </div>
                            <div class="form-group">
                            </div>

                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">담당자</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="회사명">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">담당자 부서</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="대표자명">
                                </div>

                                <label class="col-md-1 control-label header-title" for="val-username">담당자 전화</label>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="010">
                                </div>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="xxxx">
                                </div>
                                <div>
                                    
                                </div>
                                <div class="col-md-1">
                                    <input class="form-control" type="text" id="val-username" name="val-username"
                                        placeholder="xxxx">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-1 control-label header-title" for="val-username">담당자 이메일</label>
                                <div class="col-md-3">
                                    <input class="form-control" type="email" id="val-username" name="val-username"
                                        placeholder="담당자 이메일">
                                </div>

                            </div>


                            <div class="form-group">
                                <div class="col-md-5 col-md-offset-5">
                                	<input class="btn  btn-primary" type="submit" value="등록">
                                    <input class="btn  btn-default" type="reset" value="취소">
                                    
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- end row -->

            <!--Start row-->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h2 class="header-title">
                        	<i class="fa fa-chevron-circle-right mr-2"></i>
                        	거래처 전체 목록</h2>
                        <div class="table-responsive">
                            <div class="form-group">
                            </div>
                            <div class="form-group">
                            
                                <div class="col-md-1 col-md-offset-0">
                                    <input class="btn  btn-default" type="submit" value="삭제">
                                </div>
                            </div>
                            <table id="example" class="display table">
                                <thead>
                                    <tr>
                                        <td style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </td>
                                        <th>회사명</th>
                                        <th>사업자번호</th>
                                        <th>대표자명</th>
                                        <th>전화번호</th>
                                        <th>주소</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">이노텍</a></th>
                                        <td>2222-3444-2243</td>
                                        <td>김철수</td>
                                        <td>032-2222-2342</td>
                                        <td>서울 금천구</td>
                                        <td>2021-08-24</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">삼성</a></th>
                                        <td>1111-2234-1233</td>
                                        <td>감창수</td>
                                        <td>032-2222-5446</td>
                                        <td>경기도 안양시</td>
                                        <td>2021-08-24</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">대우</a></th>
                                        <td>5555-11234-5522</td>
                                        <td>김영태</td>
                                        <td>032-2222-3423</td>
                                        <td>서울 도봉구</td>
                                        <td>2021-08-24</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">이노텍</a></th>
                                        <td>2222-3444-2243</td>
                                        <td>김철수</td>
                                        <td>032-2222-2342</td>
                                        <td>서울 금천구</td>
                                        <td>2021-08-24</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">삼성</a></th>
                                        <td>1111-2234-1233</td>
                                        <td>감창수</td>
                                        <td>032-2222-5446</td>
                                        <td>경기도 안양시</td>
                                        <td>2021-08-24</td>
                                    </tr>
                                    <tr>
                                        <th style="text-align: center;">
                                            <input type="checkbox" name="select" id="select">
                                        </th>
                                        <th><a href="#">대우</a></th>
                                        <td>5555-11234-5522</td>
                                        <td>김영태</td>
                                        <td>032-2222-3423</td>
                                        <td>서울 도봉구</td>
                                        <td>2021-08-24</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        
                    </div>
                </div>
                <!--End row-->
        
        <!-- End Wrapper-->
        
                    </div>
            	<div>
            </div>
        </div>
       
       
        <!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>